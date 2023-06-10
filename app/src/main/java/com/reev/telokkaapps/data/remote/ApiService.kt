package com.reev.telokkaapps.data.remote


import com.reev.telokkaapps.data.remote.response.*
import retrofit2.http.*

interface ApiService {
    @GET("list")
    suspend fun getQuote(
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : List<QuoteResponseItem>

    @GET("place/placeCategory/{category}")
    suspend fun getPlaceWithCategory(
        @Path("category") category : String,
        @Query("Page") page: Int,
        @Query("Data") data: Int,
    ) : ListPlaceResponse

    @GET("place/placeId/id")
    suspend fun getPlaceWithId(
        @Path("id") id : Int,
    ) : DetailPlaceResponse

    @GET("place/placeNearest")
    suspend fun getPlaceNearest(
        @Query("Page") page: Int,
        @Query("Data") data: Int,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
    ) :  ListPlaceNearestResponse

}