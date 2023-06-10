package com.reev.telokkaapps.data.remote.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reev.telokkaapps.data.remote.ApiService
import com.reev.telokkaapps.data.remote.response.ListPlaceNearestItem
import com.reev.telokkaapps.data.remote.response.QuoteResponseItem

class ListPlaceNearestPagingSource(
    private val apiService : ApiService,
    private val longitude: Double,
    private val latitide: Double
    ) : PagingSource<Int, ListPlaceNearestItem>() {

    private companion object{
        const val INITIAL_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, ListPlaceNearestItem>): Int? {
        return state.anchorPosition?.let { anchorPosition->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListPlaceNearestItem> {
        return try{
            val position = params.key ?: ListPlaceNearestPagingSource.INITIAL_PAGE_INDEX
            val responseData = apiService.getPlaceNearest(page = position, data = params.loadSize, latitude = latitide , longitude = longitude )

            Log.i("dataResponse", "Dataaaa : $responseData")
            LoadResult.Page(
                data = responseData.data ?: listOf<ListPlaceNearestItem>(),
                prevKey = if (position == ListPlaceNearestPagingSource.INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (responseData.data.isNullOrEmpty()) null else position + 1
            )
        } catch (exception: Exception){
            Log.i("dataResponse", "Exception sih : $exception")

            return LoadResult.Error(exception)
        }
    }
}