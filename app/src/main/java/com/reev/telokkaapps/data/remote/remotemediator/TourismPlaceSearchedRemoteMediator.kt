package com.reev.telokkaapps.data.remote.remotemediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.reev.telokkaapps.data.local.database.TourismRoomDatabase
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceInteraction
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceNearestRemoteKeys
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceSearchedRemoteKeys
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem
import com.reev.telokkaapps.data.remote.ApiService

@OptIn(ExperimentalPagingApi::class)
class TourismPlaceSearchedRemoteMediator(
    private val db: TourismRoomDatabase,
    private val apiService: ApiService,
    private val query: String
) : RemoteMediator<Int, TourismPlaceItem>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TourismPlaceItem>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH ->{
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
            val responseData = apiService.search(page = page, data = state.config.pageSize, query = query).data
            responseData.forEach{
                data.add(it.toTourismPlace())
            }

            val endOfPaginationReached = data.isEmpty()

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.tourismPlaceSearchedRemoteKeysDao().deleteRemoteKeys()
                    db.tourismPlaceInteractionDao().unSearchAllTourismPlace()
                }

                val newInteractionData = mutableListOf<TourismPlaceInteraction>()
                for (j in data){
                    newInteractionData.add(
                        TourismPlaceInteraction(
                        placeId = j.placeId,
                        isFavorited = false,
                        isRecommended = false,
                        isSearched = true,
                        clickCount = 0
                        )
                    )
                }
                db.tourismPlaceInteractionDao().insertAll(newInteractionData)

                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (endOfPaginationReached) null else page + 1
                val keys = responseData.map {
                    TourismPlaceSearchedRemoteKeys(id = it.id, prevKey = prevKey, nextKey = nextKey)
                }
                db.tourismPlaceSearchedRemoteKeysDao().insertAll(keys)
                db.tourismPlaceDao().insertAll(data)
                data.forEach {
                    db.tourismPlaceInteractionDao().searchTourismPlace(it.placeId)
                }
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: Exception) {
            return MediatorResult.Error(exception)
        }

    }

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, TourismPlaceItem>): TourismPlaceNearestRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { data ->
            db.tourismPlaceNearestRemoteKeysDao().getRemoteKeysId(data.placeId)
        }
    }
    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, TourismPlaceItem>): TourismPlaceNearestRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { data ->
            db.tourismPlaceNearestRemoteKeysDao().getRemoteKeysId(data.placeId)
        }


    }
    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, TourismPlaceItem>): TourismPlaceNearestRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.placeId?.let { id ->
                db.tourismPlaceNearestRemoteKeysDao().getRemoteKeysId(id)
            }
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1

    }

}