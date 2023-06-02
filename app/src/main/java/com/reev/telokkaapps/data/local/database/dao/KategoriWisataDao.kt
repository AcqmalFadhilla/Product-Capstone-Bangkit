package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata


@Dao
interface KategoriWisataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(kategori : KategoriWisata)

    @Update
    fun update(kategori: KategoriWisata)

    @Delete
    fun delete(kategori: KategoriWisata)

    @Query("SELECT * from kategori_wisata ORDER BY id ASC")
    fun getAllKategori() : LiveData<List<KategoriWisata>>

    @Query("SELECT * from kategori_wisata WHERE id = :id")
    fun getKategoriWisataWithId(id: Int) : LiveData<KategoriWisata>

}