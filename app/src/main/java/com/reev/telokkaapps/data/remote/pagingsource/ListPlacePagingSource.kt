package com.reev.telokkaapps.data.remote.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reev.telokkaapps.data.remote.ApiService
import com.reev.telokkaapps.data.remote.response.ListPlaceItem

//class ListPlacePagingSource(private val apiService : ApiService, private val category: String) : PagingSource<Int, ListPlaceItem>() {
//
//    private companion object{
//        const val INITIAL_PAGE_INDEX = 1
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, ListPlaceItem>): Int? {
//        return state.anchorPosition?.let { anchorPosition->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListPlaceItem> {
//        return try{
//            val position = params.key ?: ListPlacePagingSource.INITIAL_PAGE_INDEX
//            val responseData = apiService.getPlaceWithCategory( category = category, page = position, data = params.loadSize)
//
//            Log.i("dataResponse", "Dataaaa : $responseData")
//            LoadResult.Page(
//                data = responseData.data  ?: listOf<ListPlaceItem>(),
//                prevKey = if (position == ListPlacePagingSource.INITIAL_PAGE_INDEX) null else position - 1,
//                nextKey = if (responseData.data.isNullOrEmpty()) null else position + 1
//            )
//        } catch (exception: Exception){
//            return LoadResult.Error(exception)
//        }
//    }
//}