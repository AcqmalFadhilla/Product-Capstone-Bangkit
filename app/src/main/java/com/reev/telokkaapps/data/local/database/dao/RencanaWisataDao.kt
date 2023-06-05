package com.reev.telokkaapps.data.local.database.dao

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata
import com.reev.telokkaapps.data.local.database.entity.relation.RencanaDenganTempatDanKategoriWisata

@Dao
interface RencanaWisataDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(rencanaWisata : RencanaWisata)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(rencanaWisata : List<RencanaWisata>)

    @Update
    fun update(rencanaWisata: RencanaWisata)

    @Delete
    fun delete(rencanaWisata: RencanaWisata)

    @Query("DELETE FROM rencana_wisata")
    fun deleteAllRencanaWisata()

    @Query("SELECT * from rencana_wisata WHERE idRencana = :id")
    fun getRencanaWisataWithId(id: Int) : LiveData<RencanaWisata>

    @Query("SELECT * from rencana_wisata ORDER BY idRencana ASC")
    fun getAllRencanaWisata() : LiveData<List<RencanaWisata>>

    @Transaction
    @Query("SELECT rencana_wisata.idRencana as idRencana, rencana_wisata.judul as judul, tempat_wisata.nama as namaTempat, kategori_wisata.nama as kategori   FROM rencana_wisata \n" +
            "LEFT JOIN tempat_wisata ON rencana_wisata.tempatId = tempat_wisata.idTempat \n" +
            "LEFT JOIN kategori_wisata ON tempat_wisata.kategoriId = kategori_wisata.idKategori")
    fun getAllRencanaWithTempatDanKategoriWisata() : LiveData<List<RencanaDenganTempatDanKategoriWisata>>

}

class DeleteAllWordsAsyncTask(dao: RencanaWisataDao) : AsyncTask<Void, Void, Void>() {
    private val mAsyncTaskDao: RencanaWisataDao

    init {
        mAsyncTaskDao = dao
    }

    override fun doInBackground(vararg voids: Void): Void? {
        mAsyncTaskDao.deleteAllRencanaWisata()
        return null
    }
}