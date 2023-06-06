package com.reev.telokkaapps.data.local.database.model

data class TourismPlaceItem(
    val placeId: Int,
    val placeName: String,
    val placeCategory: String,
    val placeRating: Double,
    val isFavoritedPlace: Boolean,
    val placePhotoUrl: String,
)