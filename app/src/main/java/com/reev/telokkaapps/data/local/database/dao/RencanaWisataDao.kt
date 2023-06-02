package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata

@Dao
interface RencanaWisataDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(kategori : RencanaWisata)

    @Update
    fun update(kategori: RencanaWisata)

    @Delete
    fun delete(rencanaWisata: RencanaWisata)

    @Query("SELECT * from rencana_wisata WHERE id = :id")
    fun getRencanaWisataWithId(id: Int) : LiveData<RencanaWisata>

    @Query("SELECT * from rencana_wisata ORDER BY id ASC")
    fun getAllRencanaWisata() : LiveData<List<RencanaWisata>>

}