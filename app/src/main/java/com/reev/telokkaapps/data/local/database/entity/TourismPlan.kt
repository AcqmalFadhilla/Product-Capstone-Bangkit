package com.reev.telokkaapps.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tourism_plan")
@Parcelize
data class TourismPlan(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "planId")
    var planId : Int = 0,

    @ColumnInfo(name = "planTitle")
    var planTitle : String = "",

    @ColumnInfo(name = "planDescription")
    var planDescription : String,

    @ColumnInfo(name = "planDate")
    var planDate : Long,

    @ColumnInfo(name = "status")
    var status : Boolean,

    @ColumnInfo(name = "idPlace")
    var idPlace : Int,

    ): Parcelable