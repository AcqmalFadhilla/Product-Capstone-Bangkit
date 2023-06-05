package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.relation.KategoriDanTempatWisata


@Dao
interface KategoriWisataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(kategori : KategoriWisata)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(listKategori : List<KategoriWisata>)

    @Update
    fun update(kategori: KategoriWisata)

    @Delete
    fun delete(kategori: KategoriWisata)

    @Query("SELECT * from kategori_wisata ORDER BY idKategori ASC")
    fun getAllKategori() : LiveData<List<KategoriWisata>>

    @Query("SELECT * from kategori_wisata WHERE idKategori = :id")
    fun getKategoriWisataWithId(id: Int) : LiveData<KategoriWisata>

    @Transaction
    @Query("SELECT * from kategori_wisata ORDER BY idKategori ASC")
    fun getKategoriDanTempatWisata(): LiveData<List<KategoriDanTempatWisata>>


}