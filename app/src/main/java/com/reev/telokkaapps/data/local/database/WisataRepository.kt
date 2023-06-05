package com.reev.telokkaapps.data.local.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.reev.telokkaapps.data.local.database.dao.DeleteAllWordsAsyncTask
import com.reev.telokkaapps.data.local.database.dao.KategoriWisataDao
import com.reev.telokkaapps.data.local.database.dao.RencanaWisataDao
import com.reev.telokkaapps.data.local.database.dao.TempatWisataDao
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata
import com.reev.telokkaapps.data.local.database.entity.TempatWisata
import com.reev.telokkaapps.helper.InitialDataSource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class WisataRepository(application: Application) {
    private val mKategoriWisataDao : KategoriWisataDao
    private val mRencanaWisataDao : RencanaWisataDao
    private val mTempatWisataDao : TempatWisataDao

    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = WisataRoomDatabase.getDatabase(application)
        mKategoriWisataDao = db.kategoriWisataDao()
        mRencanaWisataDao = db.rencanaWisataDao()
        mTempatWisataDao = db.tempatWisataDao()
    }

    fun insertAllData() {
        mTempatWisataDao.insertAll(InitialDataSource.getTempatWisata())
        mKategoriWisataDao.insertAll(InitialDataSource.getKategoriWisata())
        mRencanaWisataDao.insertAll(InitialDataSource.getRencanaWisata())
    }

    fun getAllKategoriWisata() : LiveData<List<KategoriWisata>> = mKategoriWisataDao.getAllKategori()

    fun getKategoriWisataWithId(idKategoriWisata: Int) = mKategoriWisataDao.getKategoriWisataWithId(idKategoriWisata)

    fun insertKategoriWisata(kategoriWisata: KategoriWisata){
        executorService.execute{
            mKategoriWisataDao.insert(kategoriWisata)
        }
    }
    fun insertAllKategoriWisata(listKategoriWisata: List<KategoriWisata>){
        executorService.execute{
            mKategoriWisataDao.insertAll(listKategoriWisata)
        }
    }

    fun updateKategoriWisata(kategoriWisata: KategoriWisata){
        executorService.execute{
            mKategoriWisataDao.update(kategoriWisata)
        }
    }

    fun deleteKategoriWisata(kategoriWisata: KategoriWisata){
        executorService.execute{
            mKategoriWisataDao.delete(kategoriWisata)
        }
    }

    // Tempat Wisata

    fun getAllTempatWisata() : LiveData<List<TempatWisata>> = mTempatWisataDao.getAllTempatWisata()

    fun getTempatWisataWithId(idTempatWisata: Int) = mTempatWisataDao.getTempatWisataWithId(idTempatWisata)

    fun insertTempatWisata(tempatWisata: TempatWisata){
        executorService.execute{
            mTempatWisataDao.insert(tempatWisata)
        }
    }

    fun insertAllTempatWisata(listTempatWisata: List<TempatWisata>){
        executorService.execute{
            mTempatWisataDao.insertAll(listTempatWisata)
        }
    }

    fun updateTempatWisata(tempatWisata: TempatWisata){
        executorService.execute{
            mTempatWisataDao.update(tempatWisata)
        }
    }

    fun updateStatusFavoriteTempatWisata(id: Int, statusFavorite: Boolean){
        executorService.execute {
            mTempatWisataDao.updateStatusFavoriteTempatWisata(id, statusFavorite)
        }
    }

    fun deleteTempatWisata(tempatWisata: TempatWisata){
        executorService.execute{
            mTempatWisataDao.delete(tempatWisata)
        }
    }

    // Rencana Wisata

    fun getAllRencanaWisata() : LiveData<List<RencanaWisata>> = mRencanaWisataDao.getAllRencanaWisata()

    fun getRencanaWisataWithId(idRencanaWisata: Int) = mRencanaWisataDao.getRencanaWisataWithId(idRencanaWisata)

    fun insertRencanaWisata(rencanaWisata: RencanaWisata){
        executorService.execute{
            mRencanaWisataDao.insert(rencanaWisata)
        }
    }

    fun updateRencanaWisata(rencanaWisata: RencanaWisata){
        executorService.execute{
            mRencanaWisataDao.update(rencanaWisata)
        }
    }

    fun deleteRencanaWisata(rencanaWisata: RencanaWisata){
        executorService.execute{
            mRencanaWisataDao.delete(rencanaWisata)
        }
    }

    fun deleteAllRencanaWisata(){
        DeleteAllWordsAsyncTask(mRencanaWisataDao).execute()
    }

    // Relasi Many To One - Tempat dan Kategori Wisata
    fun getAllTempatDanKategori() = mTempatWisataDao.getAllTempatDanKategori()
    fun getTempatWithKategoriFavorite() = mTempatWisataDao.getTempatWisataWithKategoriFavorite()
    fun getTempatWisataFavorite() = mTempatWisataDao.getTempatWisataFavorite()
    fun getDetailTempatWisataWithId(id : Int) = mTempatWisataDao.getDetailTempatWisataWithId(id)




    // Relasi One To Many - Kategori dan Tempat Wisata
    fun getAllKategoriDanTempatWisata() = mKategoriWisataDao.getKategoriDanTempatWisata()


    // Relasi Many To One - Rencana dan Tempat Kategori Wisata
    fun getAllRencanaWithTempatDanKategoriWisata() = mRencanaWisataDao.getAllRencanaWithTempatDanKategoriWisata()




}