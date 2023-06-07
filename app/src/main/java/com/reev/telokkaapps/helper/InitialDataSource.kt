package com.reev.telokkaapps.helper

import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.entity.*

object InitialDataSource {
    fun getTourismCategory(): List<TourismCategory>{
        return listOf(
            TourismCategory(1, "Taman", R.drawable.img_1_taman,false),
            TourismCategory(2, "Air Terjun", R.drawable.img_2_air_terjun, false),
            TourismCategory(3, "Museum", R.drawable.img_3_museum ,false),
            TourismCategory(4, "Pantai",R.drawable.img_4_pantai,  false, ),
            TourismCategory(5, "Permandian", R.drawable.img_5_permandian, false),
            TourismCategory(6, "Religi", R.drawable.img_6_religi,false),
            TourismCategory(7, "Hotel", R.drawable.img_7_hotel,false),
            TourismCategory(8, "Danau", R.drawable.img_8_danau,false),
            TourismCategory(9, "Belanja", R.drawable.img_9_tempat_perbelanjaan, false),
            TourismCategory(10, "Alam", R.drawable.img_10_alam,false),
        )
    }
    fun getTourismPlace() : List<TourismPlace>{
        return listOf(
            TourismPlace(
                placeId = 1,
                placeName = "Anjungan Pantai Losari",
                idCategory = 4,
                placeDescription = "Anjungan Pantai Losari adalah sebuah tempat wisata yang terletak di Makassar, Sulawesi Selatan. Anjungan ini merupakan ikon kota Makassar dan menjadi pusat perhatian para pengunjung. Dengan letaknya yang berada di tepi Pantai Losari, anjungan ini menawarkan pemandangan laut yang indah dan panorama kota yang memukau. Pengunjung dapat berjalan-jalan di sepanjang dermaga, menikmati angin laut yang segar, dan menikmati kuliner khas Makassar yang tersedia di sekitar area ini.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipPo3847T-hK93SxeNvYXdLuUkCQDQOKxYFJoX5-=w408-h306-k-no",
                city = "Makassar",
                placeAddress = "Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                placeMapUrl = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1\n",
                latitude = -5.145985,
                longitude = 119.4081239,
                placeRating = 4.5,
                placeTags = "Tempat destinasi wisata rekomendasi di makassar",
                placeReview = "sunset,foto,pemandangan,malam,masjid,sampah,kebersihan,orang,laut,daerah",
                placeWebsite = "-",
                placePhone = "-",
                isFavorited = false,
                clickCount = 0,
            ),
            TourismPlace(
                placeId = 2,
                placeName = "benteng somba opu",
                idCategory = 3,
                placeDescription = "Benteng Somba Opu adalah sebuah benteng sejarah yang terletak di Gowa, Sulawesi Selatan. Benteng ini memiliki nilai sejarah yang tinggi dan menjadi saksi bisu dari masa kejayaan Kerajaan Gowa-Tallo. Pengunjung dapat menjelajahi kompleks benteng ini yang terdiri dari tembok pertahanan, bangunan bersejarah, dan area museum yang memamerkan koleksi benda-benda bersejarah. Selain menikmati keindahan arsitektur dan melihat-lihat artefak bersejarah, pengunjung juga dapat menikmati pemandangan yang indah dari atas benteng.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipMrcNDH8ivov_O-AxnFbPAdRKfEcGJRVZRl0NlR=w408-h306-k-no",
                city = "Makassar",
                placeAddress = "Benteng sombaopu, Gusung Sarombe Sapiria, Benteng Somba Opu, Kec. Barombong, Kota Makassar, Sulawesi Selatan 90224",
                placeMapUrl = "https://www.google.com/maps/place/Benteng+Somba+Opu/data=!4m7!3m6!1s0x2dbee2741fb157a5:0x72ecff64bd8005da!8m2!3d-5.189921!4d119.4015934!16s%2Fg%2F1n3dw4yq8!19sChIJpVexH3Tivi0R2gWAvWT_7HI?authuser=0&hl=id&rclk=1",
                latitude = -5.189921,
                longitude = 119.4015934,
                placeRating = 4.3,
                placeTags = "wisata di makassar yg patut didatangi",
                placeReview = "-",
                placeWebsite = "http://lensamandalika.com/",
                placePhone = "-",
                isFavorited = false,
                clickCount = 0,
            ),
            TourismPlace(
                placeId = 3,
                placeName = "Masjid 99 kubah cpi makassar",
                idCategory = 6,
                placeDescription = "Masjid 99 Kubah CPI Makassar adalah sebuah masjid yang terletak di Makassar, Sulawesi Selatan. Masjid ini memiliki ciri khas yang unik dengan atapnya yang dihiasi oleh 99 kubah yang indah. Arsitektur masjid ini mencerminkan keindahan dan kemegahan Islam, menciptakan suasana yang khusyuk dan menarik bagi para pengunjung. Masjid 99 Kubah CPI Makassar juga merupakan tempat ibadah yang ramai dikunjungi oleh umat Muslim, baik untuk beribadah maupun untuk mengagumi keindahan arsitektur masjid ini.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipMsKVKIhrIfCY8MJliox6bY1lTGIdkL6CbXbn7t=w408-h306-k-no",
                city = "Makassar",
                placeAddress = "Kawasan CPI, Makassar City, 90111",
                placeMapUrl = "https://www.google.com/maps/place/Masjid+99+Kubah+CPI+Makassar/data=!4m7!3m6!1s0x2dbf1d4d6ad24f79:0x9f982d45f386a9fe!8m2!3d-5.1438118!4d119.4039966!16s%2Fg%2F11hcvvs6q0!19sChIJeU_Sak0dvy0R_qmG80UtmJ8?authuser=0&hl=id&rclk=1",
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
                placeId = 4,
                placeName = "Pantai Tanjung Barat Barombong",
                idCategory = 4,
                placeDescription = "-",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipPGiaJOkdS71jJu15uIUqSP4qckrjoHJavxlNw6=w408-h272-k-no",
                city = "Makassar",
                placeAddress = "Barombong, Kec. Tamalate, Kota Makassar, Sulawesi Selatan 90225",
                placeMapUrl = "https://www.google.com/maps/place/Pantai+Tanjung+Barat+Barombong/data=!4m7!3m6!1s0x2dbf1db12b6bbe8d:0xed67f96754afb18d!8m2!3d-5.1951068!4d119.3799117!16s%2Fg%2F11g7z7kytb!19sChIJjb5rK7Edvy0RjbGvVGf5Z-0?authuser=0&hl=id&rclk=1",
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
                placeId = 5,
                placeName = "Monumen Mandala Pembebasan Irian Barat",
                idCategory = 3,
                placeDescription = "Monumen Mandala Pembebasan Irian Barat adalah sebuah monumen yang terletak di Sulawesi Selatan. Monumen ini didirikan untuk mengenang perjuangan rakyat Indonesia dalam memperoleh kemerdekaan Irian Barat. Monumen ini menjadi simbol penting dalam sejarah Indonesia dan menggambarkan semangat perjuangan yang gigih. Pengunjung dapat mengunjungi monumen ini untuk mempelajari sejarah dan nilai-nilai patriotisme yang terkait dengan perjuangan pembebasan Irian Barat.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipNsWFcFJrZYxZYe7AW8xeIqeIDzRWg5bHgjNy3q=w408-h544-k-no",
                city = "Makassar",
                placeAddress = "Jl. Jend. Sudirman, Sawerigading, Kec. Ujung Pandang, Kota Makassar, Sulawesi Selatan 90115",
                placeMapUrl = "https://www.google.com/maps/place/Monumen+Mandala+Pembebasan+Irian+Barat/data=!4m7!3m6!1s0x2dbf02a96796aee9:0xfb9b9bd5f1cbd913!8m2!3d-5.1376499!4d119.4137133!16s%2Fg%2F1hm367g9c!19sChIJ6a6WZ6kCvy0RE9nL8dWbm_s?authuser=0&hl=id&rclk=1",
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
            LocationHistory(1, 0.0, longitude = 119.4081239),
            LocationHistory(2, 0.1, longitude = 119.4087593),
            LocationHistory(3, 0.2, longitude = 119.5281239)
        )
    }
}