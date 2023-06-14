package com.reev.telokkaapps.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tourism_place")
@Parcelize
data class TourismPlace(

    @PrimaryKey
    @ColumnInfo(name = "placeId")
    var placeId : Int = 0,

    @ColumnInfo(name = "placeName")
    var placeName : String = "",

    @ColumnInfo(name = "idCategory")
    var idCategory : Int = 0,

    @ColumnInfo(name = "placeDescription")
    var placeDescription : String? = null,

    @ColumnInfo(name = "placePhotoUrl")
    var placePhotoUrl : String = "",

    @ColumnInfo(name = "city")
    var city : String? = null,

    @ColumnInfo(name = "placeAddress")
    var placeAddress : String = "",

    @ColumnInfo(name = "placeMapUrl")
    var placeMapUrl : String = "",

    @ColumnInfo(name = "latitude")
    var latitude : Double = 0.0,

    @ColumnInfo(name = "longitude")
    var longitude : Double = 0.0,

    @ColumnInfo(name = "placeRating")
    var placeRating : Double = 0.0,

    @ColumnInfo(name = "placeTags")
    var placeTags : String = "",

    @ColumnInfo(name = "placeReview")
    var placeReview : String,

    @ColumnInfo(name = "placeWebsite")
    var placeWebsite : String = "",

    @ColumnInfo(name = "placePhone")
    var placePhone : String = ""
) : Parcelable