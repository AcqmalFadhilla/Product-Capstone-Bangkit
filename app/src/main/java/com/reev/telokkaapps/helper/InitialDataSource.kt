package com.reev.telokkaapps.helper

import com.reev.telokkaapps.R
import com.reev.telokkaapps.data.local.database.entity.*

object InitialDataSource {
    fun getTourismCategoryNames(): List<String> {
        val tourismCategories = getTourismCategory()
        return tourismCategories.map { it.categoryName }
    }
    fun getTourismPlaceNames(): List<String> {
        val tourismPlaceNames = getTourismPlace()
        return tourismPlaceNames.map { it.placeName }
    }
    fun getTourismCategory(): List<TourismCategory>{
        return listOf(
            TourismCategory(1, "taman", R.drawable.img_1_taman,false),
            TourismCategory(2, "air terjun", R.drawable.img_2_air_terjun, false),
            TourismCategory(3, "museum", R.drawable.img_3_museum ,false),
            TourismCategory(4, "pantai",R.drawable.img_4_pantai,  false, ),
            TourismCategory(5, "permandian", R.drawable.img_5_permandian, false),
            TourismCategory(6, "religi", R.drawable.img_6_religi,false),
            TourismCategory(7, "danau", R.drawable.img_8_danau,false),
            TourismCategory(8, "alam", R.drawable.img_10_alam,false),
        )
    }
    fun getTourismPlace() : List<TourismPlace>{
        return listOf(
            TourismPlace(
                placeId = 5,
                placeName = "taman cekkeng bulukumba",
                idCategory = 1,
                placeDescription = "Taman di Bulukumba ini menawarkan lingkungan yang damai dengan tanaman hijau yang rimbun dan taman yang terawat dengan baik. Ini adalah tempat yang ideal untuk berjalan-jalan santai dan piknik.",
                placePhotoUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fbulukumbakab.go.id%2Frubrik%2Ftaman-cekkeng&psig=AOvVaw2m3tqcfFrp9zKREAdJyio6&ust=1685158844562000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCJCMp4mIkv8CFQAAAAAdAAAAABAE",
                city = "bulukumba",
                placeAddress = "Taman Cekkeng, Ela-Ela, Kec. Ujung Bulu, Kabupaten Bulukumba, Sulawesi Selatan",
                placeMapUrl = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1\n",
                latitude = -5.553486,
                longitude = 120.2036459,
                placeRating = 4.2,
                placeTags = "Baik buat wisata keluarga, anak anak",
                placeReview = "pasar,keluarga,sore,kebersihan,sejuk,pantai,pagi,jogging",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 9,
                placeName = "hutan kota bulukumba",
                idCategory = 1,
                placeDescription = "Taman di Bulukumba ini menawarkan lingkungan yang damai dengan tanaman hijau yang rimbun dan taman yang terawat dengan baik. Ini adalah tempat yang ideal untuk berjalan-jalan santai dan piknik.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipPSfv12l_BZhZ9YlUoRYjUvzPJ9IIduknpsjaSt=w426-h240-k-no",
                city = "bulukumba",
                placeAddress = "Terang-Terang, Kec. Ujung Bulu, Kabupaten Bulukumba, Sulawesi Selatan",
                placeMapUrl = "https://www.google.com/maps/place/Hutan+Kota+Bulukumba/data=!4m7!3m6!1s0x2dbbff9be26b7049:0xd1a9f0582c3db95!8m2!3d-5.5577687!4d120.1983549!16s%2Fg%2F11b7q323g5!19sChIJSXBr4pv_uy0RldvDggWfGg0?authuser=0&hl=id&rclk=1",
                latitude = -5.5577687,
                longitude = 120.201983549,
                placeRating = 4.1,
                placeTags = "Baik buat wisata keluarga, anak anak",
                placeReview = "pasar,keluarga,sore,kebersihan,sejuk,pantai,pagi,jogging",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 27,
                placeName = "air terjun bissappua",
                idCategory = 2,
                placeDescription = "Taman di Bulukumba ini menawarkan lingkungan yang damai dengan tanaman hijau yang rimbun dan taman yang terawat dengan baik. Ini adalah tempat yang ideal untuk berjalan-jalan santai dan piknik.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipMFWmU485B41Kt6012nXDlTr-gV5iB0x2zvH02F=w408-h260-k-no",
                city = "bulukumba",
                placeAddress = "Bonto Salluang, Kec. Bissappu, Kabupaten Bantaeng, Sulawesi Selatan 92451",
                placeMapUrl = "https://www.google.com/maps/place/Air+Terjun+Bissappu/data=!4m7!3m6!1s0x2dbeb3bb112fdb19:0x425d1fd8e2031707!8m2!3d-5.5121621!4d119.9123891!16s%2Fg%2F11cjh_8vx9!19sChIJGdsvEbuzvi0RBxcD4tgfXUI?authuser=0&hl=id&rclk=1",
                latitude = -5.5121621,
                longitude = 119.123891,
                placeRating = 4.5,
                placeTags = "Tempat wisata yang lumayan tertata rapi.",
                placeReview = "sejuk,pemandangan,alam,tinggi,parkir,tiket,foto,bebatuan,hujan,anak",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 32,
                placeName = "air terjun tama'lulua",
                idCategory = 2,
                placeDescription = "Air Terjun Tama'lulua adalah sebuah air terjun yang mempesona di Sulawesi Selatan. Air terjun ini menawarkan keindahan alam yang spektakuler dengan air yang jatuh dari ketinggian dan membentuk kolam di bawahnya. Suara gemuruh air terjun dan suasana alam yang hijau dan sejuk menciptakan lingkungan yang menenangkan dan menyejukkan. Pengunjung dapat menikmati keindahan alam sekitar, berenang di kolam alami, atau sekadar bersantai di sekitar air terjun sambil menikmati keindahan alam yang alami.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipOXaVG_SpjXVVvhYn3xyaX5Wq3-BMLXmW3q3eKq=w408-h725-k-no",
                city = "bantaeng",
                placeAddress = "Bontomanai, Kec. Rumbia, Kabupaten Jeneponto, Sulawesi Selatan 92371",
                placeMapUrl = "https://www.google.com/maps/place/Air+Terjun+Tama%27lulua/data=!4m7!3m6!1s0x2dbeb42ff9a5edcf:0xfabc8cea6742e97c!8m2!3d-5.4982907!4d119.8465749!16s%2Fg%2F11c4p0j1mn!19sChIJz-2l-S-0vi0RfOlCZ-qMvPo?authuser=0&hl=id&rclk=1",
                latitude = -5.4982907,
                longitude = 119.8465749,
                placeRating = 4.5,
                placeTags = "Destinasi wisata jeneponto",
                placeReview = "pemandangan,alam,desa,bukit,daerah,parkir",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 43,
                placeName = "museum kota makassar",
                idCategory = 3,
                placeDescription = "Museum Kota Makassar adalah museum yang terletak di Kota Makassar, Sulawesi Selatan. Museum ini merupakan tempat yang penting untuk mempelajari sejarah dan budaya Kota Makassar. Di dalam museum, pengunjung dapat melihat koleksi artefak, benda bersejarah, dan benda seni yang menceritakan tentang sejarah dan kehidupan masyarakat Makassar. Museum Kota Makassar juga menyajikan informasi mengenai tradisi, kebudayaan, dan perkembangan Kota Makassar. Pengunjung dapat mendapatkan wawasan yang lebih dalam tentang sejarah dan warisan budaya Kota Makassar melalui kunjungan ke museum ini.",
                placePhotoUrl = "https://www.google.com/maps/place/Museum+Kota+Makassar/data=!4m7!3m6!1s0x2dbf02a562a0923f:0xa004e399dcd70e22!8m2!3d-5.1345968!4d119.4086261!16s%2Fg%2F11fm9rgz8n!19sChIJP5KgYqUCvy0RIg7X3JnjBKA?authuser=0&hl=id&rclk=1",
                city = "makassar",
                placeAddress = "Jl. Balaikota No.11, Baru, Kec. Ujung Pandang, Kota Makassar, Sulawesi Selatan 90171",
                placeMapUrl = "https://www.google.com/maps/place/Museum+Kota+Makassar/data=!4m7!3m6!1s0x2dbf02a562a0923f:0xa004e399dcd70e22!8m2!3d-5.1345968!4d119.4086261!16s%2Fg%2F11fm9rgz8n!19sChIJP5KgYqUCvy0RIg7X3JnjBKA?authuser=0&hl=id&rclk=1",
                latitude = -5.1345968,
                longitude = 119.4086261,
                placeRating = 4.5,
                placeTags = "Tempat wisata budaya tedekat",
                placeReview = "sejarah,lantai,foto,benda,kolonial,kantor,nama,dokumentasi,belajar,tahu",
                placeWebsite = "http://makassar.go.id/",
                placePhone = "(0411) 314077",

            ),
            TourismPlace(
                placeId = 47,
                placeName = "monumen korban 40.000 jiwa",
                idCategory = 3,
                placeDescription = "Monumen Korban 40.000 Jiwa adalah sebuah monumen yang didedikasikan untuk mengenang korban meninggal dalam peristiwa bersejarah di Sulawesi Selatan. Monumen ini memiliki makna yang mendalam dan menjadi simbol penghormatan terhadap mereka yang telah kehilangan nyawa mereka. Pengunjung dapat mengunjungi monumen ini untuk merenungkan peristiwa tersebut dan menghargai nilai-nilai perdamaian dan persatuan.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipOYcwp_yKHp_793jmQv8uRBF0nKD2Q6qcA5R5yU=w432-h240-k-no",
                city = "makassar",
                placeAddress = "Jalan Korban 40000 Jiwa, Wala-Walaya, La'latang, Kec. Tallo, Kota Makassar, Sulawesi Selatan 90214",
                placeMapUrl = "https://www.google.com/maps/place/Monumen+Korban+40.000+Jiwa/data=!4m7!3m6!1s0x2dbefd44f87e69df:0xc2bd259db6ee822d!8m2!3d-5.1298185!4d119.4324252!16s%2Fg%2F11bwn97txb!19sChIJ32l--ET9vi0RLYLutp0lvcI?authuser=0&hl=id&rclk=1",
                latitude = -5.1298185,
                longitude = 119.4324252,
                placeRating = 4.4,
                placeTags = "Tempat yg Bagus untuk mengamati dan mengingat sejarah",
                placeReview = "sejarah,rumah,belajar,museum,rakyat,tinggi,masjid,bunga,informasi",
                placeWebsite = "-",
                placePhone = "0812-8805-6050",

            ),TourismPlace(
                placeId = 48,
                placeName = "pantai bosowa tanjung",
                idCategory = 4,
                placeDescription = "Pantai Bosowa Tanjung adalah sebuah pantai yang terletak di Sulawesi Selatan. Pantai ini menawarkan pemandangan alam yang menakjubkan dengan pasir putih yang indah dan air laut yang jernih. Pengunjung dapat menikmati kegiatan seperti berjemur, berenang, atau sekadar bersantai di tepi pantai sambil menikmati pemandangan laut yang menenangkan. Pantai Bosowa Tanjung juga memiliki fasilitas seperti warung makan dan area piknik, sehingga pengunjung dapat menghabiskan waktu yang menyenangkan di pantai ini.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipMta1f9a3cLV9vIdasl8CWwT_tGaegnh1zR1RdR=w408-h306-k-no",
                city = "makassar",
                placeAddress = "Jl. Balaikota No.11, Baru, Kec. Ujung Pandang, Kota Makassar, Sulawesi Selatan 90171",
                placeMapUrl = "https://www.google.com/maps/place/Pantai+Bosowa+Tanjung/data=!4m7!3m6!1s0x2dbf1d81c547d713:0x301ceed4c8c3e44f!8m2!3d-5.1666029!4d119.3876908!16s%2Fg%2F11rxhk0v3h!19sChIJE9dHxYEdvy0RT-TDyNTuHDA?authuser=0&hl=id&rclk=1",
                latitude = -5.1666029,
                longitude = 119.3876908,
                placeRating = 4.4,
                placeTags = "Wisata Heli Pertama di Sulawesi Selatan",
                placeReview = "pantainya,sunset,tiket,kebersihan,motor,toilet,gazebo,fasilitas,weekend,tempat duduk",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 59,
                placeName = "anjungan pantai losari",
                idCategory = 4,
                placeDescription = "Anjungan Pantai Losari adalah sebuah tempat wisata yang terletak di Makassar, Sulawesi Selatan. Anjungan ini merupakan ikon kota Makassar dan menjadi pusat perhatian para pengunjung. Dengan letaknya yang berada di tepi Pantai Losari, anjungan ini menawarkan pemandangan laut yang indah dan panorama kota yang memukau. Pengunjung dapat berjalan-jalan di sepanjang dermaga, menikmati angin laut yang segar, dan menikmati kuliner khas Makassar yang tersedia di sekitar area ini.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipPo3847T-hK93SxeNvYXdLuUkCQDQOKxYFJoX5-=w408-h306-k-no",
                city = "makassar",
                placeAddress = "Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                placeMapUrl = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1\n",
                latitude = -5.145985,
                longitude = 119.4081239,
                placeRating = 4.5,
                placeTags = "Tempat destinasi wisata rekomendasi di makassar",
                placeReview = "sunset,foto,pemandangan,malam,masjid,sampah,kebersihan,orang,laut,daerah",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 7,
                placeName = "permandian alam limbua",
                idCategory = 5,
                placeDescription = "Permandian Alam Limbua adalah sebuah tempat yang terkenal dengan sumber air panas alaminya. Terletak di bulukumba, tempat ini menawarkan pengalaman menyegarkan dan relaksasi bagi para pengunjungnya. Dikelilingi oleh keindahan alam, permandian alam ini merupakan tempat yang populer bagi mereka yang mencari kesegaran dan ketenangan.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipPiPKInl4P0kCvl0imGrCu4AVS6mFKbV5miLAX6=w424-h240-k-no",
                city = "bulukumba",
                placeAddress = "Ekatiro, Kec. Bonto Tiro, Kabupaten Bulukumba, Sulawesi Selatan",
                placeMapUrl = "https://www.google.com/maps/place/Permandian+Alam+Limbua/data=!4m7!3m6!1s0x2dbc095a8f2da7af:0x743356f1a3a82533!8m2!3d-5.4674012!4d120.4267491!16s%2Fg%2F11cpkxt32r!19sChIJr6ctj1oJvC0RMyWoo_FWM3Q?authuser=0&hl=id&rclk=1",
                latitude = -5.4674012,
                longitude = 120.4267491,
                placeRating = 4.3,
                placeTags = "Permandian Alam Limbua adalah sebuah tempat yang terkenal dengan sumber air panas alaminya. Terletak di bulukumba, tempat ini menawarkan pengalaman menyegarkan dan relaksasi bagi para pengunjungnya. Dikelilingi oleh keindahan alam, permandian alam ini merupakan tempat yang populer bagi mereka yang mencari kesegaran dan ketenangan.",
                placeReview = "laut,pemandangan,keluarga,air tawar,berenang,kebersihannya,orang",
                placeWebsite = "-",
                placePhone = "0853-4257-2550",

            ),
            TourismPlace(
                placeId = 17,
                placeName = "tanah bangkala bone 1",
                idCategory = 5,
                placeDescription = "Tanah Bangkala Bone 1 adalah sebuah daerah yang memiliki nilai sejarah dan budaya yang kaya. Terletak di Bone, Sulawesi Selatan, Tanah Bangkala Bone 1 merupakan pusat kerajaan yang pernah berdiri pada masa lampau. Di sini, pengunjung dapat menemukan situs-situs arkeologi dan peninggalan sejarah yang menarik, seperti candi, batu nisan kuno, dan artefak lainnya. Tempat ini menjadi destinasi yang menarik bagi para pecinta sejarah dan budaya, yang ingin menelusuri jejak masa lalu dan mengenal lebih dalam warisan budaya di daerah tersebut.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipNOQDVTFiATvKGPyWa94Mu86KJQE2KxR7qfDbRg=w408-h306-k-no",
                city = "bone",
                placeAddress = "Watampone, Kec. Tanete Riattang, Kabupaten Bone, Sulawesi Selatan 92712",
                placeMapUrl = "https://www.google.com/maps/place/Tanah+Bangkala+Bone+1/data=!4m7!3m6!1s0x2d96099000000001:0xd602329eb1a90810!8m2!3d-4.537103!4d120.3278352!16s%2Fg%2F11gbksjk8q!19sChIJAQAAAJAJli0REAipsZ4yAtY?authuser=0&hl=id&rclk=1",
                latitude = -4.537103,
                longitude = 120.3278352,
                placeRating = 4.2,
                placeTags = "Tempat Wisata yg bagus dijadikan destinasi",
                placeReview = "kolam renang,liburan,alam,keluarga,perempuan,orang",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 42,
                placeName = "vihara girinaga",
                idCategory = 6,
                placeDescription = "-",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipOYNt_wlqFpCIiPFNQ2z_rfrmGxJcp1_2GGfqiN=w408-h544-k-no",
                city = "makassar",
                placeAddress = "Jl. G. Salahutu II No.11, Mardekaya Utara, Kec. Makassar, Kota Makassar, Sulawesi Selatan 90144",
                placeMapUrl = "https://www.google.com/maps/place/Vihara+Girinaga/data=!4m7!3m6!1s0x2dbefd54f3872515:0x11a59fcc25b0ca53!8m2!3d-5.1409996!4d119.4226574!16s%2Fg%2F1pzrws4g1!19sChIJFSWH81T9vi0RU8qwJcyfpRE?authuser=0&hl=id&rclk=1",
                latitude = -5.1409996,
                longitude = 119.4226574,
                placeRating = 4.8,
                placeTags = "Salah satu destinasi wisata religi di Kota Makassar.",
                placeReview = "umat,bangunan,agama,pagoda,tinggi,ibadah,dharma",
                placeWebsite = "https://www.viharagirinaga.com/",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 69,
                placeName = "masjid 99 kubah cpi makassar",
                idCategory = 6,
                placeDescription = "Masjid 99 Kubah CPI Makassar adalah sebuah masjid yang terletak di Makassar, Sulawesi Selatan. Masjid ini memiliki ciri khas yang unik dengan atapnya yang dihiasi oleh 99 kubah yang indah. Arsitektur masjid ini mencerminkan keindahan dan kemegahan Islam, menciptakan suasana yang khusyuk dan menarik bagi para pengunjung. Masjid 99 Kubah CPI Makassar juga merupakan tempat ibadah yang ramai dikunjungi oleh umat Muslim, baik untuk beribadah maupun untuk mengagumi keindahan arsitektur masjid ini.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipMsKVKIhrIfCY8MJliox6bY1lTGIdkL6CbXbn7t=w408-h306-k-no",
                city = "makassar",
                placeAddress = "VC43+FHH Kawasan CPI, Makassar City, 90111",
                placeMapUrl = "https://www.google.com/maps/place/Masjid+99+Kubah+CPI+Makassar/data=!4m7!3m6!1s0x2dbf1d4d6ad24f79:0x9f982d45f386a9fe!8m2!3d-5.1438118!4d119.4039966!16s%2Fg%2F11hcvvs6q0!19sChIJeU_Sak0dvy0R_qmG80UtmJ8?authuser=0&hl=id&rclk=1",
                latitude = -5.1438118,
                longitude = 119.4039966,
                placeRating = 4.7,
                placeTags = "Wisata Religi Makassar",
                placeReview = "arsitektur,desain,ridwan kamil,foto,asma'ul husna,masyarakat,tangga,ikon,karya,gelap",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 89,
                placeName = "hotel satria wisata",
                idCategory = 7,
                placeDescription = "Hotel Satria Wisata adalah sebuah hotel yang terletak di daerah tertentu. Hotel ini menawarkan akomodasi yang nyaman dan layanan yang ramah. Dengan desain yang modern dan fasilitas lengkap, Hotel Satria Wisata menjadi pilihan yang ideal bagi wisatawan yang mencari tempat menginap yang nyaman selama berlibur.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipPHhJCJy5smjlhsck6-cUpN5uype_AYXlYGbxnr=w427-h240-k-no",
                city = "parepare",
                placeAddress = "Jl. Abubakar Lambogo No.83, Bukit Indah, Kec. Soreang, Kota Parepare, Sulawesi Selatan 91131",
                placeMapUrl = "https://www.google.com/maps/place/Hotel+Satria+Wisata/data=!4m10!3m9!1s0x2d95caed8acc9a55:0x9597309c4db83490!5m2!4m1!1i2!8m2!3d-4.0054631!4d119.6362106!16s%2Fg%2F1ptzkc4cj!19sChIJVZrMiu3KlS0RkDS4TZwwl5U?authuser=0&hl=id&rclk=1",
                latitude = -4.0054631,
                longitude = 119.6362106,
                placeRating = 4.2,
                placeTags = "Kolam renang, Parkir gratis, Sarapan gratis, Wi-Fi gratis",
                placeReview = "wifi,kolam renang",
                placeWebsite = "-",
                placePhone = "0811-4197-747",

            ),
            TourismPlace(
                placeId = 92,
                placeName = "hotel pare wisata",
                idCategory = 7,
                placeDescription = "Hotel Pare Wisata adalah sebuah hotel yang terletak di Pare. Hotel ini menawarkan akomodasi yang nyaman dan fasilitas yang memadai untuk para tamu. Dengan pelayanan yang ramah dan lokasi yang strategis, Hotel Pare Wisata menjadi tempat yang ideal untuk menginap bagi para wisatawan yang berkunjung ke daerah tersebut.",
                placePhotoUrl = "https://lh3.googleusercontent.com/gps-proxy/AE4_-5Fxr-qBZPE0Q11JSOT1pFwb4kzsddhUB7AlGakrJ9AVb_R49n3tYHCjtZrZLctpY03YGOfG-qmyfP9bu6iF3ZRgWlEGVtSQwIMoSfSH9NlnrlvS0xzebDkQ7w86GNoo6pyBELwZ87k6IfUjPYQztbqqEcTziefleBGF-H_SH1DqnrBKcqBLY3oK=w408-h306-k-no",
                city = "parepare",
                placeAddress = "Jl. Sulawesi No.45, Ujung Sabbang, Kec. Ujung, Kota Parepare, Sulawesi Selatan 91114",
                placeMapUrl = "https://www.google.com/maps/place/Benteng+Somba+Opu/data=!4m7!3m6!1s0x2dbee2741fb157a5:0x72ecff64bd8005da!8m2!3d-5.189921!4d119.4015934!16s%2Fg%2F1n3dw4yq8!19sChIJpVexH3Tivi0R2gWAvWT_7HI?authuser=0&hl=id&rclk=1",
                latitude = -4.0060093,
                longitude = 119.6228991,
                placeRating = 3.9,
                placeTags = " Parkir gratis, Sarapan gratis, Wi-Fi gratis, AC",
                placeReview = "sarapan, wifi",
                placeWebsite = "http://lensamandalika.com/",
                placePhone = "(0421) 26088",

            ),
            TourismPlace(
                placeId = 171,
                placeName = "danau hijau balocci",
                idCategory = 8,
                placeDescription = "Danau Hijau Balocci adalah sebuah danau yang terletak di kabupaten pangkajene dan kepulauan. Danau ini menawarkan pemandangan yang menakjubkan dengan air yang berwarna hijau jernih dan dikelilingi oleh hamparan alam yang indah. Pengunjung dapat menikmati keindahan dan ketenangan danau, berjalan-jalan di sekitar danau, atau bahkan melakukan kegiatan seperti berperahu atau memancing.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipOoIdp99YLr0BnAnUM5nMbLtgl3uQGgQWW4nPs8=w408-h510-k-no",
                city = "kabupaten pangkajene dan kepulauan",
                placeAddress = "Balocci Baru, Kec. Balocci, Kabupaten Pangkajene Dan Kepulauan, Sulawesi Selatan 90661",
                placeMapUrl = "https://www.google.com/maps/place/Danau+Hijau+Balocci/data=!4m7!3m6!1s0x2dbe5a2eb1b7739f:0x22d9d1f98788ef8!8m2!3d-4.9057867!4d119.6432932!16s%2Fg%2F11c54cnhyn!19sChIJn3O3sS5avi0R-I54mB-dLQI?authuser=0&hl=id&rclk=1",
                latitude = -4.9057867,
                longitude = 119.6432932,
                placeRating = 4.4,
                placeTags = "Masih perlu banyak pembenahan sebagai objek wisata",
                placeReview = "camping,alami,pemandangan,tanah,sampah,bukit,karst,hujan,toilet,motor",
                placeWebsite = "-",
                placePhone = "-"
            ),
            TourismPlace(
                placeId = 184,
                placeName = "danau toakala",
                idCategory = 4,
                placeDescription = "Danau Toakala adalah sebuah danau yang terletak di maros. Danau ini menawarkan keindahan alam yang menakjubkan dengan air yang jernih dan pemandangan yang menenangkan. Pengunjung dapat menikmati keindahan danau, melakukan kegiatan seperti berperahu, atau hanya duduk bersantai di tepi danau sambil menikmati pemandangan. Danau Toakala adalah tempat yang cocok untuk melepaskan penat dan menikmati kedamaian alam.",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipMR2w9bnXkbmvM3pIwDJaMXrP1UF3nnYWR2fS1C=w408-h306-k-no",
                city = "maros",
                placeAddress = "Komplek Taman Wisata Bantimurung,, Kalabbirang, Kec. Bantimurung, Kabupaten Maros, Sulawesi Selatan 90561",
                placeMapUrl = "https://www.google.com/maps/place/Danau+Toakala/data=!4m7!3m6!1s0x2dbef66326e0e5eb:0xd4b7905ae0646c35!8m2!3d-5.0107813!4d119.68899!16s%2Fg%2F11c525r1ny!19sChIJ6-XgJmP2vi0RNWxk4FqQt9Q?authuser=0&hl=id&rclk=1",
                latitude = -5.0107813,
                longitude = 119.68899,
                placeRating = 4.6,
                placeTags = "Salah satu tempat wisata di Bantimurung, Maros yang bisa kita kunjungi.",
                placeReview = "kupu-kupu,pemandangan,batu,air terjun",
                placeWebsite = "-",
                placePhone = "-",

            ),
            TourismPlace(
                placeId = 4,
                placeName = "puncak lima jari",
                idCategory = 10,
                placeDescription = "Pattimpa, Kec. Ponre, Kabupaten Bone, Sulawesi Selatan 92772",
                placePhotoUrl = "https://lh5.googleusercontent.com/p/AF1QipO88XUXeDeUcloUBdK3kTACQhfwXCs1ci-nLYBd=w408-h306-k-no",
                city = "bone",
                placeAddress = "Pattimpa, Kec. Ponre, Kabupaten Bone, Sulawesi Selatan 92772",
                placeMapUrl = "https://www.google.com/maps/place/Puncak+Lima+Jari/data=!4m7!3m6!1s0x2dbde0e2bc98226f:0x891816dae5d729cb!8m2!3d-4.6288865!4d120.2177772!16s%2Fg%2F11f387699g!19sChIJbyKYvOLgvS0RyynX5doWGIk?authuser=0&hl=id&rclk=1",
                latitude = -4.6288865,
                longitude = 1.202177772,
                placeRating = 4.3,
                placeTags = "Tempat wisata yg cukup populer di berbagai kalangan.",
                placeReview = "pemandangan,mendaki,foto,sunrise,wc,keindahan",
                placeWebsite = "-",
                placePhone = "0822-9391-4225",

            )
        )
    }
    fun getTourismPlan() : List<TourismPlan>{
        return listOf(
            TourismPlan(
                planId = 1,
                planTitle = "Libur Semester Ganjil",
                planDescription = "-",
                planDate = "07-06-2023",
                planStatus = false,
                idPlace = 2
            ),
            TourismPlan(
                planId = 2,
                planTitle = "Refreshingg",
                planDescription = "-",
                planDate = "07-06-2023",
                planStatus = false,
                idPlace = 4
            )
        )
    }

    fun getCityNames(): List<String> {
        return listOf(
            "makassar",
            "bantaeng",
            "bone",
            "bulukumba",
            "barru",
            "enrekang",
            "gowa",
            "jeneponto",
            "kepulauan selayar",
            "luwu",
            "luwu timur",
            "luwu utara",
            "maros",
            "kabupaten pangkajene dan kepulauan",
            "pinrang",
            "sidenreng rappang",
            "sinjai",
            "soppeng",
            "takalar",
            "tana toraja",
            "toraja utara",
            "wajo",
            "palopo",
            "parepare"
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