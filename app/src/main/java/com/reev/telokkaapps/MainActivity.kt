package com.reev.telokkaapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.reev.telokkaapps.data.local.database.entity.LocationHistory
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.databinding.ActivityMainBinding
import java.sql.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: OneViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = OneViewModel(application)

//        binding.buttonDelete.setOnClickListener {
//            viewModel.deleteAllTourismPlan()
//        }


//        Testing Query
//        viewModel.getCategoryAndTourismPlace().observe(this, {
//            Log.i("printDB", "Tabel Kategori")
//            it.forEach{ kategoriWisata ->
//                Log.i("printDB", kategoriWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//
//        })

//        viewModel.updateFavoriteStatusOfTourismPlace(3, true)
//        viewModel.updateFavoriteStatusOfTourismPlace(2, true)
////
//        viewModel.getFavoritedTourismPlace().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata Favorite")
//            it.forEach{ tempatWisata->
//                Log.i("printDB", tempatWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//
//        })
//
//        viewModel.getPlaceTourismAndCategory().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata dan Kategori")
//            it.forEach{ tempatKategoriWisata->
//                Log.i("printDB", tempatKategoriWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })

//        viewModel.getCategoryAndTourismPlace().observe(this, {
//            Log.i("printDB", "Tabel Kategori dan Tempat Wisata")
//            it.forEach{ kategoriTempatWisata->
//                Log.i("printDB", kategoriTempatWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
//
//        viewModel.updateKategoriWisata(KategoriWisata(1, "pantai", true))
//
//        viewModel.getTempatWithKategoriFavorite().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata dengan Kategori Favorite")
//            it.forEach{ tempatWithKategoriFavorite->
//                Log.i("printDB", tempatWithKategoriFavorite.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
//
//
//        viewModel.getTempatWisataWithId(1).observe(this, {
//            viewModel.updateTempatWisata(it.copy(statusSuka = true))
//        })
//
//        viewModel.getTempatWithKategoriFavorite().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata dengan Kategori Favorite")
//            it.forEach{ tempatWithKategoriFavorite->
//                Log.i("printDB", tempatWithKategoriFavorite.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
//
//
//
//        viewModel.getPlaceTourismAndFavoriteCategory().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata dengan Kategori Favorite")
//            it.forEach{ tempatWithKategoriFavorite->
//                Log.i("printDB", tempatWithKategoriFavorite.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
////
//        viewModel.getDetailTourismPlaceWithId(1).observe(this, {
//            Log.i("printDB", "Tabel Detail Tempat Wisata ")
//            it.forEach{ detailTempatWisata->
//                Log.i("printDB", detailTempatWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
////
//        viewModel.getAllPlanWithPlaceAndTourismCategory().observe(this, {
//            Log.i("printDB", "Tabel Rencana, Tempat, Kategori Wisata")
//            it.forEach{ rencanaTempatKategoriWisata->
//                Log.i("printDB", rencanaTempatKategoriWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
//
//
//        viewModel.getAllPlanWithPlaceAndTourismCategory().observe(this, {
//            Log.i("printDB", "Tabel Rencana, Tempat, Kategori Wisata part 2")
//            it.forEach{ rencanaTempatKategoriWisata->
//                Log.i("printDB", rencanaTempatKategoriWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
////
//        viewModel.getAllLocationHistory().observe(this, {
//            Log.i("printDB", "Tabel Riwayat Lokasi")
//            it.forEach{ riwayatLokasi->
//                Log.i("printDB", riwayatLokasi.toString())
//            }
//        })
//        viewModel.getLatestLocation().observe(this, {
//            Log.i("printDB", "Lokasi Terbaru")
//            Log.i("printDB", it.toString())
//        })

    }

}

//class MainActivity : AppCompatActivity() {
//    private lateinit var binding : ActivityMainBinding
//    private lateinit var viewModel: OneViewModel
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        supportActionBar?.hide()
//
//        viewModel = OneViewModel(application)
//
//        binding.buttonInsert.setOnClickListener {
//            viewModel.insertTourismCategory(TourismCategory(10, "Pantai", false ))
//            viewModel.getAllTourismCategories().observe(this, { listKategori ->
//                var listKategoriWisata = ""
//                for( i in listKategori){
//                    listKategoriWisata += i
//                    listKategoriWisata += "\n"
//                }
//                binding.insertKategoriWisata.text = listKategoriWisata
//            })
//
//
//            viewModel.insertTourismPlace(
//                TourismPlace("10", "Pantai Ammani", 10, "", "Makassar", "", "", "", 0.0, 0.0, 0.0,"", "", "", "", false, 6)
//            )
//            viewModel.getAllTourismPlace().observe(this, { listTempat ->
//                var listtempatWisata = ""
//                for( i in listTempat){
//                    listtempatWisata += i
//                    listtempatWisata += "\n"
//                }
//                binding.insertTempatWisata.text = listtempatWisata
//            })
//
//
//            viewModel.insertTourismPlan(
//                TourismPlan(10, "Pantai Ammani", "Pantaiiii",  Date.UTC(2023, 6, 2, 0, 0, 1), false, 10)
//            )
//            viewModel.getAllTourismPlan().observe(this, { listRencana ->
//                var listRencanaWisata = ""
//                for( i in listRencana){
//                    listRencanaWisata += i
//                    listRencanaWisata += "\n"
//                }
//                binding.insertRencanaWisata.text = listRencanaWisata
//            })
//
//            viewModel.insertLocationHistory(LocationHistory(10, 0.0, 2.0))
//            viewModel.getAllLocationHistory().observe(this, { listRiwayat ->
//                var listRiwayatLokasi = ""
//                for( i in listRiwayat){
//                    listRiwayatLokasi += i
//                    listRiwayatLokasi += "\n"
//                }
//                binding.insertRiwayatLokasi.text = listRiwayatLokasi
//            })
//        }
//
//        binding.buttonUpdate.setOnClickListener {
//
//            viewModel.updateTourismCategory(TourismCategory(10, "Beach", false ))
//            viewModel.getAllTourismCategories().observe(this, { listKategori ->
//                var listKategoriWisata = ""
//                for( i in listKategori){
//                    listKategoriWisata += i
//                    listKategoriWisata += "\n"
//                }
//                binding.insertKategoriWisata.text = listKategoriWisata
//            })
//
//
//            viewModel.updateTourismPlace(
//                TourismPlace("10", "Pantai Ammani", 1, "", "Pinrang", "", "", "",0.0, 0.0, 0.0, "", "", "", "", false, 6)
//            )
//            viewModel.getAllTourismPlace().observe(this, { listTempat ->
//                var listtempatWisata = ""
//                for( i in listTempat){
//                    listtempatWisata += i
//                    listtempatWisata += "\n"
//                }
//                binding.insertTempatWisata.text = listtempatWisata
//            })
//
//            viewModel.updateTourismPlan(
//                TourismPlan(10, "Pantai Ammanii", "Pantaiiii",  Date.UTC(2023, 6, 2, 0, 0, 1), false, 10)
//            )
//            viewModel.getAllTourismPlan().observe(this, { listRencana ->
//                var listRencanaWisata = ""
//                for( i in listRencana){
//                    listRencanaWisata += i
//                    listRencanaWisata += "\n"
//                }
//                binding.insertRencanaWisata.text = listRencanaWisata
//            })
//
//
//            viewModel.updateLocationHistory(LocationHistory(10, 1.0, 2.0))
//            viewModel.getAllLocationHistory().observe(this, { listRiwayat ->
//                var listRiwayatLokasi = ""
//                for( i in listRiwayat){
//                    listRiwayatLokasi += i
//                    listRiwayatLokasi += "\n"
//                }
//                binding.insertRiwayatLokasi.text = listRiwayatLokasi
//            })
//        }
//
////        binding.buttonDelete.setOnClickListener {
//viewModel.deleteAllTourismPlan()

//            viewModel.updateTourismCategory(TourismCategory(10, "Beach", false ))
//
//            viewModel.deleteTourismCategory(TourismCategory(10, "Beach", false ))
//            viewModel.getAllTourismCategories().observe(this, { listKategori ->
//                var listKategoriWisata = ""
//                for( i in listKategori){
//                    listKategoriWisata += i
//                    listKategoriWisata += "\n"
//                }
//                binding.insertKategoriWisata.text = listKategoriWisata
//            })
//
//            viewModel.deleteTourismPlace(
//                TourismPlace("10", "Pantai Ammani", 10, "", "Pinrang", "", "", "",0.0, 0.0, 0.0, "", "", "", "", false, 6)
//            )
//            viewModel.getAllTourismPlan().observe(this, { listTempat ->
//                var listtempatWisata = ""
//                for( i in listTempat){
//                    listtempatWisata += i
//                    listtempatWisata += "\n"
//                }
//                binding.insertTempatWisata.text = listtempatWisata
//            })
//
//
//            viewModel.deleteTourismPlan(
//                TourismPlan(10, "Pantai Ammani guys", "Pantaiiii",  Date.UTC(2023, 6, 2, 0, 0, 1), false, 10)
//            )
//
//            viewModel.getAllTourismPlan().observe(this, { listRencana ->
//                var listRencanaWisata = ""
//                for( i in listRencana){
//                    listRencanaWisata += i
//                    listRencanaWisata += "\n"
//                }
//                binding.insertRencanaWisata.text = listRencanaWisata
//            })
//
//
//            viewModel.deleteLocationHistory(LocationHistory(10, 1.0, 2.0))
//            viewModel.getAllLocationHistory().observe(this, { listRiwayat ->
//                var listRiwayatLokasi = ""
//                for( i in listRiwayat){
//                    listRiwayatLokasi += i
//                    listRiwayatLokasi += "\n"
//                }
//                binding.insertRiwayatLokasi.text = listRiwayatLokasi
//            })
//        }
//    }
//
//}