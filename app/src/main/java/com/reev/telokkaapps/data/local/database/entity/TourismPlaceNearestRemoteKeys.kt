package com.reev.telokkaapps.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "place_nearest_remote_keys")
data class TourismPlaceNearestRemoteKeys(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int,

    @ColumnInfo(name = "prevKey")
    val prevKey : Int?,

    @ColumnInfo(name = "nextKey")
    val nextKey : Int?
)