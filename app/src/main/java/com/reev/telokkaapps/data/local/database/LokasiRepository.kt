package com.reev.telokkaapps.data.local.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.reev.telokkaapps.data.local.database.dao.KategoriWisataDao
import com.reev.telokkaapps.data.local.database.dao.RencanaWisataDao
import com.reev.telokkaapps.data.local.database.dao.RiwayatLokasiDao
import com.reev.telokkaapps.data.local.database.dao.TempatWisataDao
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi
import com.reev.telokkaapps.data.local.database.entity.TempatWisata
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LokasiRepository(application: Application) {
    private val mRiwayatLokasiDao : RiwayatLokasiDao

    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = LokasiRoomDatabase.getDatabase(application)
        mRiwayatLokasiDao = db.riwayatLokasiDao()
    }

    fun getAllRiwayatLokasi() : LiveData<List<RiwayatLokasi>> = mRiwayatLokasiDao.getAllRiwayatLokasi()

    fun getRiwayatLokasiWithId(idRiwayatLokasi: Int) = mRiwayatLokasiDao.getRiwayatLokasiWithId(idRiwayatLokasi)

    fun insertRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        executorService.execute{
            mRiwayatLokasiDao.insert(riwayatLokasi)
        }
    }

    fun updateRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        executorService.execute{
            mRiwayatLokasiDao.update(riwayatLokasi)
        }
    }

    fun deleteRiwayatLokasi(riwayatLokasi: RiwayatLokasi){
        executorService.execute{
            mRiwayatLokasiDao.delete(riwayatLokasi)
        }
    }
}