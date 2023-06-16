package com.reev.telokkaapps.data.remote.remotemediator

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.reev.telokkaapps.data.local.database.TourismRoomDatabase
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceInteraction
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceSearchedRemoteKeys
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem
import com.reev.telokkaapps.data.remote.ApiServiceForModel

@OptIn(ExperimentalPagingApi::class)
class TourismPlaceSearchedRemoteMediator(
    private val db: TourismRoomDatabase,
    private val apiService: ApiServiceForModel,
    private val query: String

) : RemoteMediator<Int, TourismPlaceItem>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TourismPlaceItem>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH ->{
                Log.i("refresh", "TourismPlaceSearchedRemoteMediator refreshing....")
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: INITIAL_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                nextKey
            }
        }

        try {
            val data = mutableListOf<TourismPlace>()
            val responseData = apiService.search(page = page, data = state.config.pageSize, query = query)
            responseData.forEach{
                data.add(it.toTourismPlace())
            }

//            val endOfPaginationReached = data.isEmpty()

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    Log.i("refresh", "TourismPlaceSearchedRemoteMediator deleteRemoteKeys....")
                    db.tourismPlaceSearchedRemoteKeysDao().deleteRemoteKeys()
                }

                val newInteractionData = mutableListOf<TourismPlaceInteraction>()
                for (j in data){
                    newInteractionData.add(
                        TourismPlaceInteraction(
                        placeId = j.placeId,
                        isFavorited = false,
                        isRecommended = false,
                        clickCount = 0
                        )
                    )
                }
                db.tourismPlaceDao().insertAll(data)
                db.tourismPlaceInteractionDao().insertAll(newInteractionData)

                val prevKey = if (page == 1) null else page - 1
                val nextKey = null
                val keys = mutableListOf<TourismPlaceSearchedRemoteKeys>()
                for (i in 0 .. responseData.size-1) {
                    val newData = TourismPlaceSearchedRemoteKeys(orderr = i, id = responseData[i].id, prevKey = prevKey, nextKey = nextKey )
                    keys.add(newData)
                }
                db.tourismPlaceSearchedRemoteKeysDao().insertAll(keys)
            }
            return MediatorResult.Success(endOfPaginationReached = true)
        } catch (exception: Exception) {
            Log.i("dataResponse", "TourismPlaceSearched exception: $exception")
            return MediatorResult.Error(exception)
        }

    }

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, TourismPlaceItem>): TourismPlaceSearchedRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { data ->
            db.tourismPlaceSearchedRemoteKeysDao().getRemoteKeysId(data.placeId)
        }
    }
    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, TourismPlaceItem>): TourismPlaceSearchedRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { data ->
            db.tourismPlaceSearchedRemoteKeysDao().getRemoteKeysId(data.placeId)
        }


    }
    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, TourismPlaceItem>): TourismPlaceSearchedRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.placeId?.let { id ->
                db.tourismPlaceSearchedRemoteKeysDao().getRemoteKeysId(id)
            }
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1

    }

}