package com.reev.telokkaapps.helper

import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi
import com.reev.telokkaapps.data.local.database.entity.TempatWisata

object InitialDataSource {
    fun getKategoriWisata(): List<KategoriWisata>{
        return listOf(
            KategoriWisata(1, "pantai", false),
            KategoriWisata(2, "air terjun", false),
            KategoriWisata(3, "museum", false),
        )
    }
    fun getTempatWisata() : List<TempatWisata>{
        return listOf(
            TempatWisata(
                idTempat = "1",
                nama = "anjungan pantai losari",
                kategoriId = 1,
                deskripsi = "-",
                kota = "Makassar",
                alamat = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                urlMaps = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                rating = 4.5,
                nRating = 17811,
                tag = "wisata di makassar yg patut didatangi",
                website = "http://lensamandalika.com/",
                jamBuka = "Jumat,Buka 24 jam; Sabtu,Buka 24 jam; Minggu,Buka 24 jam; Senin,Buka 24 jam; Selasa,Buka 24 jam; Rabu,Buka 24 jam; Kamis,Buka 24 jam. Sembunyikan jam buka untuk seminggu",
                noTelepon = "-",
                statusSuka = false,
                nKlik = 0,
            ),
            TempatWisata(
                idTempat = "2",
                nama = "pantai bara Bulukumba",
                kategoriId = 1,
                deskripsi = "-",
                kota = "Bulukumba",
                alamat = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                urlMaps = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                rating = 4.5,
                nRating = 17811,
                tag = "wisata di makassar yg patut didatangi",
                website = "http://lensamandalika.com/",
                jamBuka = "Jumat,Buka 24 jam; Sabtu,Buka 24 jam; Minggu,Buka 24 jam; Senin,Buka 24 jam; Selasa,Buka 24 jam; Rabu,Buka 24 jam; Kamis,Buka 24 jam. Sembunyikan jam buka untuk seminggu",
                noTelepon = "-",
                statusSuka = false,
                nKlik = 0,
            ),
            TempatWisata(
                idTempat = "3",
                nama = "pantai marina Bulukumba",
                kategoriId = 1,
                deskripsi = "-",
                kota = "Bulukumba",
                alamat = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                urlMaps = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                rating = 4.5,
                nRating = 17811,
                tag = "wisata di makassar yg patut didatangi",
                website = "http://lensamandalika.com/",
                jamBuka = "Jumat,Buka 24 jam; Sabtu,Buka 24 jam; Minggu,Buka 24 jam; Senin,Buka 24 jam; Selasa,Buka 24 jam; Rabu,Buka 24 jam; Kamis,Buka 24 jam. Sembunyikan jam buka untuk seminggu",
                noTelepon = "-",
                statusSuka = false,
                nKlik = 0,
            ),
            TempatWisata(
                idTempat = "4",
                nama = "air terjun parangloe",
                kategoriId = 2,
                deskripsi = "-",
                kota = "Gowa",
                alamat = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                urlMaps = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                rating = 4.5,
                nRating = 17811,
                tag = "wisata di makassar yg patut didatangi",
                website = "http://lensamandalika.com/",
                jamBuka = "Jumat,Buka 24 jam; Sabtu,Buka 24 jam; Minggu,Buka 24 jam; Senin,Buka 24 jam; Selasa,Buka 24 jam; Rabu,Buka 24 jam; Kamis,Buka 24 jam. Sembunyikan jam buka untuk seminggu",
                noTelepon = "-",
                statusSuka = false,
                nKlik = 0,
            ),
            TempatWisata(
                idTempat = "5",
                nama = "air terjun celebes canyon",
                kategoriId = 2,
                deskripsi = "-",
                kota = "Bulukumba",
                alamat = "VC35+J65, Losari Kec. Ujung Pandang, Panambungan, Kec. Mariso, Kota Makassar, Sulawesi Selatan 90113",
                urlMaps = "https://www.google.com/maps/place/Anjungan+Pantai+Losari/data=!4m7!3m6!1s0x2dbf1d0b955e33e5:0x317901e72ec46e12!8m2!3d-5.145985!4d119.4081239!16s%2Fg%2F11g1vfhgm0!19sChIJ5TNelQsdvy0REm7ELucBeTE?authuser=0&hl=id&rclk=1",
                latitude = -5.145985,
                longitude = 119.4081239,
                rating = 4.5,
                nRating = 17811,
                tag = "wisata di makassar yg patut didatangi",
                website = "http://lensamandalika.com/",
                jamBuka = "Jumat,Buka 24 jam; Sabtu,Buka 24 jam; Minggu,Buka 24 jam; Senin,Buka 24 jam; Selasa,Buka 24 jam; Rabu,Buka 24 jam; Kamis,Buka 24 jam. Sembunyikan jam buka untuk seminggu",
                noTelepon = "-",
                statusSuka = false,
                nKlik = 0,
            )
        )
    }
    fun getRencanaWisata() : List<RencanaWisata>{
        return listOf(
            RencanaWisata(
                idRencana = 1,
                judul = "Libur Semester Ganjil",
                deskripsi = "-",
                tanggal = 10L,
                jam = 8L,
                status = false,
                tempatId = 2
            ),
            RencanaWisata(
                idRencana = 2,
                judul = "Refreshingg",
                deskripsi = "-",
                tanggal = 10L,
                jam = 8L,
                status = false,
                tempatId = 4
            )
        )
    }

    fun getRiwayatLokasi(): List<RiwayatLokasi>{
        return listOf(
            RiwayatLokasi(1, 0.0, longitude = 0.0),
            RiwayatLokasi(2, 0.1, longitude = 1.2),
            RiwayatLokasi(3, 0.2, longitude = 2.4)
        )

    }
}