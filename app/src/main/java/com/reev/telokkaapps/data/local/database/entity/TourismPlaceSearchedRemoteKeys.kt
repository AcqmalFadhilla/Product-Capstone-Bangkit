package com.reev.telokkaapps.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "place_searched_remote_keys")
data class TourismPlaceSearchedRemoteKeys(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int,

    @ColumnInfo(name = "prevKey")
    val prevKey : Int?,

    @ColumnInfo(name = "nextKey")
    val nextKey : Int?
)