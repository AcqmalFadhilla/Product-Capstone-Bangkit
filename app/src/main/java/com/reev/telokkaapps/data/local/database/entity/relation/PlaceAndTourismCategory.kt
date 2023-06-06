package com.reev.telokkaapps.data.local.database.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.TourismPlace

data class PlaceAndTourismCategory(
    @Embedded
    val tourismPlace : TourismPlace,

    @Relation(
        parentColumn = "idCategory",
        entityColumn = "categoryId"
    )
    val category : TourismCategory? = null
)