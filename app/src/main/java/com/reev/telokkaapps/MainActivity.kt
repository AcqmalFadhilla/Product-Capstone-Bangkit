package com.reev.telokkaapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reev.telokkaapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: OneViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = OneViewModel(application)


//        Testing Query
//        viewModel.getAllKategoriWisata().observe(this, {
//            Log.i("printDB", "Tabel Kategori")
//            it.forEach{ kategoriWisata ->
//                Log.i("printDB", kategoriWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//
//        })

//        viewModel.updateStatusFavoriteTempatWisata(3, true)
//        viewModel.updateStatusFavoriteTempatWisata(2, false)
//
//        viewModel.getTempatWisataFavorite().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata Favorite")
//            it.forEach{ tempatWisata->
//                Log.i("printDB", tempatWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//
//        })

//        viewModel.getAllTempatDanKategori().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata dan Kategori")
//            it.forEach{ tempatKategoriWisata->
//                Log.i("printDB", tempatKategoriWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
//        viewModel.getAllKategoriDanTempatWisata().observe(this, {
//            Log.i("printDB", "Tabel Kategori dan Tempat Wisata")
//            it.forEach{ kategoriTempatWisata->
//                Log.i("printDB", kategoriTempatWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })

//        viewModel.updateKategoriWisata(KategoriWisata(1, "pantai", true))

//        viewModel.getTempatWithKategoriFavorite().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata dengan Kategori Favorite")
//            it.forEach{ tempatWithKategoriFavorite->
//                Log.i("printDB", tempatWithKategoriFavorite.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
    //

//        viewModel.getTempatWisataWithId(1).observe(this, {
//            viewModel.updateTempatWisata(it.copy(statusSuka = true))
//        })

//        viewModel.getTempatWithKategoriFavorite().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata dengan Kategori Favorite")
//            it.forEach{ tempatWithKategoriFavorite->
//                Log.i("printDB", tempatWithKategoriFavorite.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })



//        viewModel.getTempatWithKategoriFavorite().observe(this, {
//            Log.i("printDB", "Tabel Tempat Wisata dengan Kategori Favorite")
//            it.forEach{ tempatWithKategoriFavorite->
//                Log.i("printDB", tempatWithKategoriFavorite.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })

//        viewModel.getDetailTempatWisataWithId(1).observe(this, {
//            Log.i("printDB", "Tabel Detail Tempat Wisata ")
//            it.forEach{ detailTempatWisata->
//                Log.i("printDB", detailTempatWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })

//        viewModel.getAllRencanaWithTempatDanKategoriWisata().observe(this, {
//            Log.i("printDB", "Tabel Rencana, Tempat, Kategori Wisata")
//            it.forEach{ rencanaTempatKategoriWisata->
//                Log.i("printDB", rencanaTempatKategoriWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
//
//        viewModel.deleteAllRencanaWisata()
//
//        viewModel.getAllRencanaWithTempatDanKategoriWisata().observe(this, {
//            Log.i("printDB", "Tabel Rencana, Tempat, Kategori Wisata part 2")
//            it.forEach{ rencanaTempatKategoriWisata->
//                Log.i("printDB", rencanaTempatKategoriWisata.toString())
//            }
//            Log.i("printDB", "-------------------------------------------------------------------")
//        })
//
//        viewModel.getAllRiwayatLokasi().observe(this, {
//            Log.i("printDB", "Tabel Riwayat Lokasi")
//            it.forEach{ riwayatLokasi->
//                Log.i("printDB", riwayatLokasi.toString())
//            }
//        })
//        viewModel.getLokasiTerbaru().observe(this, {
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
//            viewModel.insertKategoriWisata(KategoriWisata(1, "Pantai", false ))
//            viewModel.getAllKategoriWisata().observe(this, { listKategori ->
//                var listKategoriWisata = ""
//                for( i in listKategori){
//                    listKategoriWisata += i
//                    listKategoriWisata += "\n"
//                }
//                binding.insertKategoriWisata.text = listKategoriWisata
//            })
//
//
//            viewModel.insertTempatWisata(
//                TempatWisata("1", "Pantai Ammani", 1, "", "Makassar", "", "", 0.0, 0.0, 0.0, 0, "", "", "", "", false, 6)
//            )
//            viewModel.getAllTempatWisata().observe(this, { listTempat ->
//                var listtempatWisata = ""
//                for( i in listTempat){
//                    listtempatWisata += i
//                    listtempatWisata += "\n"
//                }
//                binding.insertTempatWisata.text = listtempatWisata
//            })
//
//
//            viewModel.insertRencanaWisata(
//                RencanaWisata(1, "Pantai Ammani", "Pantaiiii",  Date.UTC(2023, 6, 2, 0, 0, 1), Time.UTC(2023, 6, 2, 0, 0, 1), false)
//            )
//            viewModel.getAllRencanaWisata().observe(this, { listRencana ->
//                var listRencanaWisata = ""
//                for( i in listRencana){
//                    listRencanaWisata += i
//                    listRencanaWisata += "\n"
//                }
//                binding.insertRencanaWisata.text = listRencanaWisata
//            })
//
//            viewModel.insertRiwayatLokasi(RiwayatLokasi(1, 0.0, 2.0, 4L, 9L))
//            viewModel.getAllRiwayatLokasi().observe(this, { listRiwayat ->
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
//            viewModel.updateKategoriWisata(KategoriWisata(1, "Beach", false ))
//            viewModel.getAllKategoriWisata().observe(this, { listKategori ->
//                var listKategoriWisata = ""
//                for( i in listKategori){
//                    listKategoriWisata += i
//                    listKategoriWisata += "\n"
//                }
//                binding.insertKategoriWisata.text = listKategoriWisata
//            })
//
//
//            viewModel.updateTempatWisata(
//                TempatWisata("1", "Pantai Ammani", 1, "", "Pinrang", "", "", 0.0, 0.0, 0.0, 0, "", "", "", "", false, 6)
//            )
//            viewModel.getAllTempatWisata().observe(this, { listTempat ->
//                var listtempatWisata = ""
//                for( i in listTempat){
//                    listtempatWisata += i
//                    listtempatWisata += "\n"
//                }
//                binding.insertTempatWisata.text = listtempatWisata
//            })
//
//            viewModel.updateRencanaWisata(
//                RencanaWisata(1, "Pantai Ammanii", "Pantaiiii",  Date.UTC(2023, 6, 2, 0, 0, 1), Time.UTC(2023, 6, 2, 0, 0, 1), false)
//            )
//            viewModel.getAllRencanaWisata().observe(this, { listRencana ->
//                var listRencanaWisata = ""
//                for( i in listRencana){
//                    listRencanaWisata += i
//                    listRencanaWisata += "\n"
//                }
//                binding.insertRencanaWisata.text = listRencanaWisata
//            })
//
//
//            viewModel.updateRiwayatLokasi(RiwayatLokasi(1, 1.0, 2.0, 4L, 9L))
//            viewModel.getAllRiwayatLokasi().observe(this, { listRiwayat ->
//                var listRiwayatLokasi = ""
//                for( i in listRiwayat){
//                    listRiwayatLokasi += i
//                    listRiwayatLokasi += "\n"
//                }
//                binding.insertRiwayatLokasi.text = listRiwayatLokasi
//            })
//        }
//
//        binding.buttonDelete.setOnClickListener {
//            viewModel.deleteKategoriWisata(KategoriWisata(1, "Beach", false ))
//            viewModel.getAllKategoriWisata().observe(this, { listKategori ->
//                var listKategoriWisata = ""
//                for( i in listKategori){
//                    listKategoriWisata += i
//                    listKategoriWisata += "\n"
//                }
//                binding.insertKategoriWisata.text = listKategoriWisata
//            })
//
//            viewModel.deleteTempatWisata(
//                TempatWisata("1", "Pantai Ammani", 1, "", "Pinrang", "", "", 0.0, 0.0, 0.0, 0, "", "", "", "", false, 6)
//            )
//            viewModel.getAllTempatWisata().observe(this, { listTempat ->
//                var listtempatWisata = ""
//                for( i in listTempat){
//                    listtempatWisata += i
//                    listtempatWisata += "\n"
//                }
//                binding.insertTempatWisata.text = listtempatWisata
//            })
//
//
//            viewModel.deleteRencanaWisata(
//                RencanaWisata(1, "Pantai Ammani guys", "Pantaiiii",  Date.UTC(2023, 6, 2, 0, 0, 1), Time.UTC(2023, 6, 2, 0, 0, 1), false)
//            )
//
//            viewModel.getAllRencanaWisata().observe(this, { listRencana ->
//                var listRencanaWisata = ""
//                for( i in listRencana){
//                    listRencanaWisata += i
//                    listRencanaWisata += "\n"
//                }
//                binding.insertRencanaWisata.text = listRencanaWisata
//            })
//
//
//            viewModel.deleteRiwayatLokasi(RiwayatLokasi(1, 1.0, 2.0, 4L, 9L))
//            viewModel.getAllRiwayatLokasi().observe(this, { listRiwayat ->
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