package com.reev.telokkaapps

import android.app.Application
import androidx.lifecycle.LiveData
import com.reev.telokkaapps.data.local.database.LokasiRepository
import com.reev.telokkaapps.data.local.database.WisataRepository
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi
import com.reev.telokkaapps.data.local.database.entity.TempatWisata

class OneViewModel(application: Application){
    private val mWisataRepository: WisataRepository = WisataRepository(application)
    private val mLokasiRepository: LokasiRepository = LokasiRepository(application)



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
    // Riwayat Lokasi

    fun getAllRiwayatLokasi() : LiveData<List<RiwayatLokasi>> = mLokasiRepository.getAllRiwayatLokasi()

    fun getRiwayatLokasiWithId(idRiwayatLokasi: Int) = mLokasiRepository.getRiwayatLokasiWithId(idRiwayatLokasi)

    fun insertRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        mLokasiRepository.insertRiwayatLokasi(riwayatLokasi)
    }

    fun updateRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        mLokasiRepository.updateRiwayatLokasi(riwayatLokasi)
    }

    fun deleteRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        mLokasiRepository.deleteRiwayatLokasi(riwayatLokasi)
    }

}