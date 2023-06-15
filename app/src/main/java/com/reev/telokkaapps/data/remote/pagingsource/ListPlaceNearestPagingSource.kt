package com.reev.telokkaapps.data.remote.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem
import com.reev.telokkaapps.data.remote.ApiService
import com.reev.telokkaapps.data.remote.response.ListPlaceItem
import okio.IOException
import retrofit2.HttpException
//
//class ListPlaceNearestPagingSource(
//    private val apiService : ApiService,
//    private val longitude: Double,
//    private val latitide: Double
//    ) : PagingSource<Int, TourismPlaceItem>() {
//
//    private companion object{
//        const val INITIAL_PAGE_INDEX = 1
//    }
//    override fun getRefreshKey(state: PagingState<Int, TourismPlaceItem>): Int? {
//        return state.anchorPosition?.let { anchorPosition->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TourismPlaceItem> {
//        return try{
//            val position = params.key ?: ListPlaceNearestPagingSource.INITIAL_PAGE_INDEX
//            val responseData = apiService.getPlaceNearest(page = position, data = params.loadSize, latitude = latitide , longitude = longitude )
//
//            LoadResult.Page(
//                data = responseData.data,
//                prevKey = if (position == ListPlaceNearestPagingSource.INITIAL_PAGE_INDEX) null else position - 1,
//                nextKey = if (responseData.data.isNullOrEmpty()) null else position + 1
//            )
//        }  catch (e: IOException) {
//            return LoadResult.Error(e)
//        } catch (e: HttpException) {
//            return LoadResult.Error(e)
//        }
//        catch (exception: Exception){
//            return LoadResult.Error(exception)
//        }
//    }
//}