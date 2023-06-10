package com.reev.telokkaapps.data.local.database.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TourismPlanItem(
    val planId : Int,
    val planTitle: String,
    val placeName : String,
    val tourismCategory: String,
    val planDate : String,
    val placePhotoUrl : String
) : Parcelable