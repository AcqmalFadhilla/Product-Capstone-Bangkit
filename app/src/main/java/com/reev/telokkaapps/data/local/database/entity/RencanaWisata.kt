package com.reev.telokkaapps.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "rencana_wisata")
@Parcelize
class RencanaWisata(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idRencana")
    var idRencana : Int = 0,

    @ColumnInfo(name = "judul")
    var judul : String = "",

    @ColumnInfo(name = "deskripsi")
    var deskripsi : String,

    @ColumnInfo(name = "tanggal")
    var tanggal : Long,

    @ColumnInfo(name = "jam")
    var jam : Long,
    @ColumnInfo(name = "status")
    var status : Boolean,

    @ColumnInfo(name = "tempatId")
    var tempatId : Int,

): Parcelable