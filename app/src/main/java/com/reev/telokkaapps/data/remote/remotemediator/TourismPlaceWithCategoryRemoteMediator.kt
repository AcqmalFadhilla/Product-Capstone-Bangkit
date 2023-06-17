package com.reev.telokkaapps.data.remote.remotemediator

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.reev.telokkaapps.data.local.database.TourismRoomDatabase
import com.reev.telokkaapps.data.local.database.entity.*
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem
import com.reev.telokkaapps.data.remote.ApiService

@OptIn(ExperimentalPagingApi::class)
class TourismPlaceWithCategoryRemoteMediator(
    private val db: TourismRoomDatabase,
    private val apiService: ApiService,
    private val category: String,
    private val categoryId: Int
) : RemoteMediator<Int, TourismPlaceItem>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TourismPlaceItem>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH ->{
                Log.i("dataResponse1", "Ini LoadType.REFRESH dieksekusi")
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: INITIAL_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                Log.i("dataResponse2", "Ini LoadType.PREPEND dieksekusi")

                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                prevKey
            }
            LoadType.APPEND -> {
                Log.i("dataResponse", "Ini LoadType.APPEND dieksekusi")
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                Log.i("dataResponse", "next key = $nextKey")
                nextKey
            }
        }

        try {
            val data = mutableListOf<TourismPlace>()
            val responseData = apiService.getPlaceWithCategory(page = page, data = state.config.pageSize, category = category).data
            responseData.forEach{
                data.add(it.toTourismPlace())
            }

            val endOfPaginationReached = responseData.isEmpty()

            db.withTransaction {
                Log.i("dataResponse", "masuk ke db.withTransaction")
                if (loadType == LoadType.REFRESH) {
                    db.tourismPlaceWithCategoryRemoteKeysDao().deleteRemoteKeys()
                    db.tourismPlaceDao().deleteTourismPlaceWithCategoryId(categoryId)
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
                if (page == 1){
                    db.tourismPlaceDao().deleteTourismPlaceWithCategoryId(categoryId)
                }
                db.tourismPlaceDao().insertAll(data)
                db.tourismPlaceInteractionDao().insertAll(newInteractionData)

                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (endOfPaginationReached) null else page + 1
                val keys = responseData.map {
                    TourismPlaceWithCategoryRemoteKeys(id = it.id, prevKey = prevKey, nextKey = nextKey)
                }
                db.tourismPlaceWithCategoryRemoteKeysDao().insertAll(keys)
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: Exception) {
            Log.i("dataResponse", "exception : ${exception.message}")
            return MediatorResult.Error(exception)
        }

    }

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, TourismPlaceItem>): TourismPlaceWithCategoryRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { data ->
            Log.i("dataResponse", "TourismPlaceWithCategoryRK : lastData = ${data.placeId}")
            var remoteKeyForLastItem =  db.tourismPlaceWithCategoryRemoteKeysDao().getRemoteKeysId(data.placeId)
            Log.i("dataResponse", "TourismPlaceWithCategoryRK : getRemoteKeyForLastItem() = ${remoteKeyForLastItem?.nextKey}")
            remoteKeyForLastItem
        }
    }
    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, TourismPlaceItem>): TourismPlaceWithCategoryRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { data ->
            db.tourismPlaceWithCategoryRemoteKeysDao().getRemoteKeysId(data.placeId)
        }
    }
    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, TourismPlaceItem>): TourismPlaceWithCategoryRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.placeId?.let { id ->
                db.tourismPlaceWithCategoryRemoteKeysDao().getRemoteKeysId(id)
            }
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1

    }

}