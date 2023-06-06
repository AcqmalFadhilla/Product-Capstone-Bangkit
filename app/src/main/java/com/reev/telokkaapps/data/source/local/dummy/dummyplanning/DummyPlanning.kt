package com.reev.telokkaapps.data.source.local.dummy.dummyplanning

import com.reev.telokkaapps.data.source.local.dummy.dummyplace.DummyPlacesData

object DummyPlanning {
    val dummyPlanning = listOf(
        PlanningPlace(
            DummyPlacesData.dummyPlaces[0],
            "Berwisata kecil kecilan",
            "Berikut ini list anggota yang akan ikut, ada beberapa",
            "01-01-2024"
        ),
        PlanningPlace(
            DummyPlacesData.dummyPlaces[2],
            "Berwisata with family",
            "Tidak usah banyak barang dibawa",
            "01-03-2024"
        ),
        PlanningPlace(
            DummyPlacesData.dummyPlaces[3],
            "Wisata with my student",
            "Berikut ini list biaya yang dibutuhkan siswa",
            "31-04-2024"
        ),
        PlanningPlace(
            DummyPlacesData.dummyPlaces[4],
            "Wisata sendirian",
            "Berikut ini list anggota yang akan ikut, ada beberapa",
            "16-06-2024"
        ),
    )
}