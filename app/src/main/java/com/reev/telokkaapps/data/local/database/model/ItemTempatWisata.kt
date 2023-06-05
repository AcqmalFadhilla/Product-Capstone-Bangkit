package com.reev.telokkaapps.data.local.database.model

data class ItemTempatWisata(
    val id: Int,
    val nama: String,
    val kategori: String,
    val rating: Double,
    val statusFavorite: Boolean,
    val urlGambar: String,
)