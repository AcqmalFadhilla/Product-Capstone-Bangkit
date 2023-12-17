package com.reev.telokkaapps.data.local.database.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TourismPlaceItem(
    val placeId: Int,
    val placeName: String,
    val placeCategory: String,
    val placeRating: Double,
    val isFavoritedPlace: Boolean,
    val placePhotoUrl: String,
    val placeDistance: Double?,
): Parcelable