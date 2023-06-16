package com.reev.telokkaapps.data.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reev.telokkaapps.data.remote.ApiService
import com.reev.telokkaapps.data.remote.response.TourismPlaceResponse
import okio.IOException
import retrofit2.HttpException

//class ListPlaceSearchedPagingSource(
//    private val apiService : ApiService,
//    private val query: String,
//    private val category : String,
//    private val city: String,
//    private val orderRating : Boolean
//) : PagingSource<Int, TourismPlaceResponse>(){
//
//    private companion object{
//        const val INITIAL_PAGE_INDEX = 1
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, TourismPlaceResponse>): Int? {
//        return state.anchorPosition?.let { anchorPosition->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TourismPlaceResponse> {
//        return try{
//            val position = params.key ?: ListPlaceSearchedPagingSource.INITIAL_PAGE_INDEX
//            val responseData = apiService.search(page = position, data = params.loadSize, query = query)
//
//            LoadResult.Page(
//                data = responseData.data,
//                prevKey = if (position == ListPlaceSearchedPagingSource.INITIAL_PAGE_INDEX) null else position - 1,
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
//
//}