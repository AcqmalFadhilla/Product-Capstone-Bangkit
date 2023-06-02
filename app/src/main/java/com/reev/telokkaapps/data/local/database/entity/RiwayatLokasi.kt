package com.reev.telokkaapps.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "riwayat_lokasi")
@Parcelize
data class RiwayatLokasi(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0,

    @ColumnInfo(name = "latitude")
    var latitude : Double = 0.0,

    @ColumnInfo(name = "longitude")
    var longitude : Double = 0.0,

    @ColumnInfo(name = "tanggal")
    var tanggal : Long,

    @ColumnInfo(name = "waktu")
    var waktu : Long,

    ) : Parcelable