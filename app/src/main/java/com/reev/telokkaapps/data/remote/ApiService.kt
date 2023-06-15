package com.reev.telokkaapps.data.remote


import com.reev.telokkaapps.data.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface ApiService {
    @GET("place/placeCategory/{category}")
    suspend fun getPlaceWithCategory(
        @Path("category") category : String,
        @Query("Page") page: Int,
        @Query("Data") data: Int,
    ) : PlaceResponse

    @GET("place/placeId/{id}")
    fun getPlaceWithId(
        @Path("id") id : Int,
    ) : DetailPlaceResponse

    @GET("place/placeNearest")
    suspend fun getPlaceNearest(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("Page") page: Int,
        @Query("Data") data: Int,
    ) :  PlaceResponse

    @GET("place/filter")
    suspend fun search(
        @Query("query") query : String,
        @Query("Page") page: Int,
        @Query("Data") data: Int,
    ) : PlaceResponse



}