package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi
import com.reev.telokkaapps.data.local.database.entity.TempatWisata
@Dao
interface TempatWisataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tempatWisata: TempatWisata)

    @Update
    fun update(tempatWisata: TempatWisata)

    @Delete
    fun delete(tempatWisata: TempatWisata)

    @Query("SELECT * from tempat_wisata ORDER BY id ASC")
    fun getAllTempatWisata() : LiveData<List<TempatWisata>>

    @Query("SELECT * from tempat_wisata WHERE id = :id")
    fun getTempatWisataWithId(id: Int) : LiveData<TempatWisata>
}