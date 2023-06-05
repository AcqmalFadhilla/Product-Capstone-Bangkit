package com.reev.telokkaapps.data.local.database.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.TempatWisata

data class KategoriDanTempatWisata(
    @Embedded
    val kategori : KategoriWisata,

    @Relation(
        parentColumn = "idKategori",
        entityColumn = "kategoriId"
    )
    val tempat : List<TempatWisata>
)