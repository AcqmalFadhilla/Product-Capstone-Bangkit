package com.reev.telokkaapps.data.local.database.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.TempatWisata

data class TempatDanKategoriWisata(
    @Embedded
    val tempatWisata : TempatWisata,

    @Relation(
        parentColumn = "kategoriId",
        entityColumn = "idKategori"
    )
    val kategori : KategoriWisata? = null
)