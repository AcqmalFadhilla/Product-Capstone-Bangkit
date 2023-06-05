package com.reev.telokkaapps

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reev.telokkaapps.data.local.database.LokasiRepository
import com.reev.telokkaapps.data.local.database.WisataRepository
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi
import com.reev.telokkaapps.data.local.database.entity.TempatWisata
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OneViewModel(application: Application) : ViewModel(){
    private val mWisataRepository: WisataRepository = WisataRepository(application)
    private val mLokasiRepository: LokasiRepository = LokasiRepository(application)


    init {
        insertAllData()
    }

    private fun insertAllData() = viewModelScope.launch(Dispatchers.IO) {
        mWisataRepository.insertAllData()
        mLokasiRepository.insertAllData()
    }


    fun getAllKategoriWisata() : LiveData<List<KategoriWisata>> = mWisataRepository.getAllKategoriWisata()

    fun getKategoriWisataWithId(idKategoriWisata: Int) = mWisataRepository.getKategoriWisataWithId(idKategoriWisata)

    fun insertKategoriWisata(kategoriWisata: KategoriWisata){
        mWisataRepository.insertKategoriWisata(kategoriWisata)
    }

    fun updateKategoriWisata(kategoriWisata: KategoriWisata){
        mWisataRepository.updateKategoriWisata(kategoriWisata)
    }

    fun deleteKategoriWisata(kategoriWisata: KategoriWisata){
        mWisataRepository.deleteKategoriWisata(kategoriWisata)
    }

    // Tempat Wisata

    fun getAllTempatWisata() : LiveData<List<TempatWisata>> = mWisataRepository.getAllTempatWisata()

    fun getTempatWisataWithId(idTempatWisata: Int) = mWisataRepository.getTempatWisataWithId(idTempatWisata)

    fun insertTempatWisata(tempatWisata: TempatWisata){
        mWisataRepository.insertTempatWisata(tempatWisata)
    }

    fun updateTempatWisata(tempatWisata: TempatWisata){
        mWisataRepository.updateTempatWisata(tempatWisata)
    }

    fun updateStatusFavoriteTempatWisata(id: Int, statusFavorite: Boolean){
        mWisataRepository.updateStatusFavoriteTempatWisata(id, statusFavorite)
    }

    fun deleteTempatWisata(tempatWisata: TempatWisata){
        mWisataRepository.deleteTempatWisata(tempatWisata)
    }

    // Rencana Wisata

    fun getAllRencanaWisata() : LiveData<List<RencanaWisata>> = mWisataRepository.getAllRencanaWisata()

    fun getRencanaWisataWithId(idRencanaWisata: Int) = mWisataRepository.getRencanaWisataWithId(idRencanaWisata)

    fun insertRencanaWisata(rencanaWisata: RencanaWisata){
        mWisataRepository.insertRencanaWisata(rencanaWisata)
    }

    fun updateRencanaWisata(rencanaWisata: RencanaWisata){
        mWisataRepository.updateRencanaWisata(rencanaWisata)
    }

    fun deleteRencanaWisata(rencanaWisata: RencanaWisata){
        mWisataRepository.deleteRencanaWisata(rencanaWisata)
    }
    fun deleteAllRencanaWisata(){
        mWisataRepository.deleteAllRencanaWisata()
    }
    // Riwayat Lokasi

    fun getAllRiwayatLokasi() : LiveData<List<RiwayatLokasi>> = mLokasiRepository.getAllRiwayatLokasi()

    fun getRiwayatLokasiWithId(idRiwayatLokasi: Int) = mLokasiRepository.getRiwayatLokasiWithId(idRiwayatLokasi)
    fun getLokasiTerbaru() = mLokasiRepository.getLokasiTerbaru()

    fun insertRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        mLokasiRepository.insertRiwayatLokasi(riwayatLokasi)
    }

    fun updateRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        mLokasiRepository.updateRiwayatLokasi(riwayatLokasi)
    }

    fun deleteRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        mLokasiRepository.deleteRiwayatLokasi(riwayatLokasi)
    }



    // Relasi Many To One - Tempat dan Kategori Wisata
    fun getAllTempatDanKategori() = mWisataRepository.getAllTempatDanKategori()
    fun getTempatWithKategoriFavorite() = mWisataRepository.getTempatWithKategoriFavorite()
    fun getTempatWisataFavorite() = mWisataRepository.getTempatWisataFavorite()
    fun getDetailTempatWisataWithId(id : Int) = mWisataRepository.getDetailTempatWisataWithId(id)

    // Relasi One To Many - Kategori dan Tempat Wisata
    fun getAllKategoriDanTempatWisata() = mWisataRepository.getAllKategoriDanTempatWisata()

    // Relasi Many To One - Rencana dan Tempat Kategori Wisata
    fun getAllRencanaWithTempatDanKategoriWisata() = mWisataRepository.getAllRencanaWithTempatDanKategoriWisata()



}