package com.reev.telokkaapps.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "location_history")
@Parcelize
data class LocationHistory(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "historyId")
    var historyId : Int = 0,

    @ColumnInfo(name = "latitude")
    var latitude : Double = 0.0,

    @ColumnInfo(name = "longitude")
    var longitude : Double = 0.0

) : Parcelable