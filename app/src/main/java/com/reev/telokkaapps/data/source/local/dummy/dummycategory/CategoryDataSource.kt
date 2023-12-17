package com.reev.telokkaapps.data.source.local.dummy.dummycategory

import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.entity.TourismCategory

object CategoryDataSource {
//    val dummyCategories = listOf(
//        Category(R.drawable.img_1_taman, "Taman"),
//        Category(R.drawable.img_2_air_terjun, "Air Terjun"),
//        Category(R.drawable.img_3_museum, "Museum"),
//        Category(R.drawable.img_4_pantai, "Pantai"),
//        Category(R.drawable.img_5_permandian, "Permandian"),
//        Category(R.drawable.img_6_religi, "Religi"),
//        Category(R.drawable.img_7_hotel, "Hotel"),
//        Category(R.drawable.img_8_danau, "Danau"),
//        Category(R.drawable.img_9_tempat_perbelanjaan, "Belanja"),
//        Category(R.drawable.img_10_alam, "Alam")
//    )
    val dummyCategories = listOf(
        TourismCategory(1, "Taman", R.drawable.img_1_taman,false),
        TourismCategory(2, "Air Terjun", R.drawable.img_1_taman, false),
        TourismCategory(3, "Museum", R.drawable.img_1_taman ,false),
        TourismCategory(4, "Pantai",R.drawable.img_1_taman,  false, ),
        TourismCategory(5, "Permandian", R.drawable.img_1_taman, false),
        TourismCategory(6, "Religi", R.drawable.img_1_taman,false),
        TourismCategory(7, "Hotel", R.drawable.img_1_taman,false),
        TourismCategory(8, "Danau", R.drawable.img_1_taman,false),
        TourismCategory(9, "Belanja", R.drawable.img_1_taman, false),
        TourismCategory(10, "Alam", R.drawable.img_1_taman,false),
    )
}