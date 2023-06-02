package com.reev.telokkaapps.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tempat_wisata")
@Parcelize
data class TempatWisata(

    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id : String = "",

    @ColumnInfo(name = "nama")
    var nama : String = "",

    @ColumnInfo(name = "idKategori")
    var idKategori : Int = 0,

    @ColumnInfo(name = "urlGambar")
    var urlGambar : String = "",

    @ColumnInfo(name = "kota")
    var kota : String = "",

    @ColumnInfo(name = "alamat")
    var alamat : String = "",

    @ColumnInfo(name = "urlMaps")
    var urlMaps : String = "",

    @ColumnInfo(name = "latitude")
    var latitude : Double = 0.0,

    @ColumnInfo(name = "longitude")
    var longitude : Double = 0.0,

    @ColumnInfo(name = "rating")
    var rating : Double = 0.0,

    @ColumnInfo(name = "nRating")
    var nRating : Int = 0,

    @ColumnInfo(name = "tag")
    var tag : String = "",

    @ColumnInfo(name = "website")
    var website : String = "",

    @ColumnInfo(name = "jamBuka")
    var jamBuka : String = "",

    @ColumnInfo(name = "noTelepon")
    var noTelepon : String = "",

    @ColumnInfo(name = "statusSuka")
    var statusSuka : Boolean = false,

    @ColumnInfo(name = "nKlik")
    var nKlik : Int = 0
) : Parcelable