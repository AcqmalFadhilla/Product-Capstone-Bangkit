package com.reev.telokkaapps.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "place_nearest_remote_keys")
data class TourismPlaceNearestRemoteKeys(
    @PrimaryKey val id : String,
    val prevKey : Int?,
    val nextKey : Int?
)