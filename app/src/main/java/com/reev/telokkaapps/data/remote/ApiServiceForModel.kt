package com.reev.telokkaapps.data.remote


import com.reev.telokkaapps.data.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface ApiServiceForModel {

    @GET("recommend")
    suspend fun search(
        @Query("activity") query : String,
        @Query("Page") page: Int,
        @Query("Data") data: Int,
    ) : List<DetailTourismPlaceResponse>



}