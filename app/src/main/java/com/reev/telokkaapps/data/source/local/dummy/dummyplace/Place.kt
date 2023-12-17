package com.reev.telokkaapps.data.source.local.dummy.dummyplace

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val placeId : Int,
    val placePhotoUrl : String,
    val placeMapUrl : String,
    val placeName : String,
    val placeCategory : String,
    val placeDescription : String,
    val placeRating : Double,
    val placeRatingCount : Int? = 0,
    val placeOperationalHour : String? = "-",
    val placeTags : String? = "-",
    val placeAddress : String? = "-",
    val placeWebsite : String? = "-",
    val placePhone : String? = "-",
) : Parcelable