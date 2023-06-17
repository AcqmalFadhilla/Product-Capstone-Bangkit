package com.reev.telokkaapps.data.local.database.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.TourismPlace

data class CategoryAndTourismPlace(
    @Embedded
    val category : TourismCategory,

    @Relation(
        parentColumn = "categoryId",
        entityColumn = "idCategory"
    )
    val place : List<TourismPlace>
)