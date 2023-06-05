package com.reev.telokkaapps.data.local.database.model

data class ItemDetailtempatWisata(
    val id : Int,
    val nama: String,
    val kategori: String,
    val deskripsi: String,
    val rating : Double,
    val jumlahRating: Int,
    val jamBuka: String,
    val tag: String,
    val alamat : String,
    val website: String,
    val noTelepon : String,
    val statusFavorite: Boolean,
    val urlGambar: String,
    val urlMaps : String,
)