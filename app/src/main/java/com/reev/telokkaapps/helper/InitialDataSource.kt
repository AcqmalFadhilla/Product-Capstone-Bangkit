package com.reev.telokkaapps.helper

import com.reev.telokkaapps.data.local.database.entity.*

object InitialDataSource {
    fun getTourismCategory(): List<TourismCategory>{
        return listOf(
            TourismCategory(1, "pantai", false),
            TourismCategory(2, "air terjun", false),
            TourismCategory(3, "museum", false),
        )
    }
    fun getTourismPlace() : List<TourismPlace>{
        return listOf(
            TourismPlace(
                placeId = "1",
                placeName = "anjungan pantai losari",
                idCategory = 1,
                placeDescription = "-",
                placePhotoUrl = "",
                city = "Makassar",
                placeAddress = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                placeMapUrl = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                placeRating = 4.5,
                placeTags = "wisata di makassar yg patut didatangi",
                placeReview = "-",
                placeWebsite = "http://lensamandalika.com/",
                placePhone = "-",
                isFavorited = false,
                clickCount = 0,
            ),
            TourismPlace(
                placeId = "2",
                placeName = "pantai bara Bulukumba",
                idCategory = 1,
                placeDescription = "-",
                placePhotoUrl = "",
                city = "Makassar",
                placeAddress = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                placeMapUrl = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                placeRating = 4.5,
                placeTags = "wisata di makassar yg patut didatangi",
                placeReview = "-",
                placeWebsite = "http://lensamandalika.com/",
                placePhone = "-",
                isFavorited = false,
                clickCount = 0,
            ),
            TourismPlace(
                placeId = "3",
                placeName = "pantai marina Bulukumba",
                idCategory = 1,
                placeDescription = "-",
                placePhotoUrl = "",
                city = "Makassar",
                placeAddress = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                placeMapUrl = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                placeRating = 4.5,
                placeTags = "wisata di makassar yg patut didatangi",
                placeReview = "-",
                placeWebsite = "http://lensamandalika.com/",
                placePhone = "-",
                isFavorited = false,
                clickCount = 0,
            ),
            TourismPlace(
                placeId = "4",
                placeName = "air terjun parangloe",
                idCategory = 2,
                placeDescription = "-",
                placePhotoUrl = "",
                city = "Makassar",
                placeAddress = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                placeMapUrl = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                placeRating = 4.5,
                placeTags = "wisata di makassar yg patut didatangi",
                placeReview = "-",
                placeWebsite = "http://lensamandalika.com/",
                placePhone = "-",
                isFavorited = false,
                clickCount = 0,
            ),
            TourismPlace(
                placeId = "5",
                placeName = "air terjun celebes canyon",
                idCategory = 2,
                placeDescription = "-",
                placePhotoUrl = "",
                city = "Makassar",
                placeAddress = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                placeMapUrl = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                placeRating = 4.5,
                placeTags = "wisata di makassar yg patut didatangi",
                placeReview = "-",
                placeWebsite = "http://lensamandalika.com/",
                placePhone = "-",
                isFavorited = false,
                clickCount = 0,
            )
        )
    }
    fun getTourismPlan() : List<TourismPlan>{
        return listOf(
            TourismPlan(
                planId = 1,
                planTitle = "Libur Semester Ganjil",
                planDescription = "-",
                planDate = 10L,
                status = false,
                idPlace = 2
            ),
            TourismPlan(
                planId = 2,
                planTitle = "Refreshingg",
                planDescription = "-",
                planDate = 10L,
                status = false,
                idPlace = 4
            )
        )
    }

    fun getLocationHistory(): List<LocationHistory>{
        return listOf(
            LocationHistory(1, 0.0, longitude = 0.0),
            LocationHistory(2, 0.1, longitude = 1.2),
            LocationHistory(3, 0.2, longitude = 2.4)
        )

    }
}