package com.reev.telokkaapps.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tourism_category")
@Parcelize
data class TourismCategory(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "categoryId")
    var categoryId: Int = 0,

    @ColumnInfo(name = "categoryName")
    var categoryName : String = "",

    @ColumnInfo(name = "isFavorited")
    var isFavotited : Boolean = false
) : Parcelable


