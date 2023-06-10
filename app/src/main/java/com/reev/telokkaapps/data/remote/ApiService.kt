package com.reev.telokkaapps.data.remote


import com.reev.telokkaapps.data.remote.response.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
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
    ) :  ListPlaceResponse

}