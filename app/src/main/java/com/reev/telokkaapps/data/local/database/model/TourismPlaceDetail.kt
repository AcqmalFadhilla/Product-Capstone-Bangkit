package com.reev.telokkaapps.data.local.database.model

data class TourismPlaceDetail(
    val placeId : Int,
    val placeName: String,
    val placeCategory: String,
    val placeDescription: String,
    val placeRating : Double,
    val placeTags: String,
    val placeAddress : String,
    val placeWebsite: String,
    val placePhone : String,
    val isFavoritedPlace: Boolean,
    val placePhotoUrl: String,
    val placeMapUrl : String,
)