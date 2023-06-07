package com.reev.telokkaapps.data.local.database.model

import java.net.Inet4Address

data class TourismPlanDetail(
    val planId : Int,
    val planTitle : String,
    val planDescription : String,
    val placeName : String,
    val placeRating: Double,
    val placeTags: String,
    val placeAddress: String,
    val placeWebiste: String,
    val placePhone: String,
    val placeDescription: String,
    val placeMapUrl: String,
    val placePhotoUrl : String,
    val tourismCategory : String,
    val planDate : String,
    val planStatus : Boolean,

)