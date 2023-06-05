package com.reev.telokkaapps.data.local.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.reev.telokkaapps.data.local.database.dao.RiwayatLokasiDao
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi
import com.reev.telokkaapps.helper.InitialDataSource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LokasiRepository(application: Application) {
    private val mRiwayatLokasiDao : RiwayatLokasiDao

    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = LokasiRoomDatabase.getDatabase(application)
        mRiwayatLokasiDao = db.riwayatLokasiDao()
    }

    fun insertAllData() {
        mRiwayatLokasiDao.insertAll(InitialDataSource.getRiwayatLokasi())
    }

    fun getAllRiwayatLokasi() : LiveData<List<RiwayatLokasi>> = mRiwayatLokasiDao.getAllRiwayatLokasi()

    fun getRiwayatLokasiWithId(idRiwayatLokasi: Int) = mRiwayatLokasiDao.getRiwayatLokasiWithId(idRiwayatLokasi)
    fun getLokasiTerbaru() = mRiwayatLokasiDao.getLokasiTerbaru()

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