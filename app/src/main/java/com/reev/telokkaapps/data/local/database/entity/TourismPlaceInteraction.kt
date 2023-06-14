package com.reev.telokkaapps.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tourism_place_interaction")
@Parcelize
data class TourismPlaceInteraction(

    @PrimaryKey
    @ColumnInfo(name = "placeId")
    var placeId : Int = 0,

    @ColumnInfo(name = "isFavorited")
    var isFavorited : Boolean = false,

    @ColumnInfo(name = "isRecommended")
    var isRecommended : Boolean,

    @ColumnInfo(name = "isSearched")
    var isSearched : Boolean,

    @ColumnInfo(name = "clickCount")
    var clickCount : Int = 0
) : Parcelable