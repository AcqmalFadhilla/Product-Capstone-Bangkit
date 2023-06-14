package com.reev.telokkaapps.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.reev.telokkaapps.data.local.database.dao.TourismPlaceDao
import com.reev.telokkaapps.data.local.database.dao.TourismPlaceNearestRemoteKeysDao
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceNearestRemoteKeys

@OptIn(ExperimentalPagingApi::class)
class TourismPlaceNearestRemoteMediator(
    private val tourismPlaceDao : TourismPlaceDao,
    private val tourismPlaceNearestRemoteKeysDao: TourismPlaceNearestRemoteKeysDao,
    private val apiService: ApiService
) : RemoteMediator<Int, TourismPlace>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TourismPlace>
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
            val responseData = apiService.getPlaceNearest(page = page, data = state.config.pageSize, latitude = 0.0, longitude = 0.0).data
            val endOfPaginationReached = responseData.isEmpty()
            tourismPlaceDao.insertAll(responseData)
//            database.withTransaction {
////                if (loadType == LoadType.REFRESH) {
//                      database. database.remoteKeysDao().deleteRemoteKeys()
////                    database.tourismPlaceDao().deleteAll()
////                }
//            val prevKey = if (page == 1) null else page - 1
//            val nextKey = if (endOfPaginationReached) null else page + 1
//            val keys = responseData.map {
//                RemoteKeys(id = it.id, prevKey = prevKey, nextKey = nextKey)
//            }
//            database.remoteKeysDao().insertAll(keys)
//                database.tourismPlaceDao().insertAll(responseData)
//            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: Exception) {
            return MediatorResult.Error(exception)
        }

    }

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, TourismPlace>): TourismPlaceNearestRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { data ->
            tourismPlaceNearestRemoteKeysDao.getRemoteKeysId(data.placeId.toString())
        }
    }
    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, TourismPlace>): TourismPlaceNearestRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { data ->
            tourismPlaceNearestRemoteKeysDao.getRemoteKeysId(data.placeId.toString())
        }
    }
    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, TourismPlace>): TourismPlaceNearestRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.placeId?.let { id ->
                tourismPlaceNearestRemoteKeysDao.getRemoteKeysId(id.toString())
            }
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1

    }

}