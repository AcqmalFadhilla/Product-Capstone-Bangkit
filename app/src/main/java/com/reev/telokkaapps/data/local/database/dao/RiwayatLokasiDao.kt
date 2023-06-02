package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi

@Dao
interface RiwayatLokasiDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(riwayatLokasi: RiwayatLokasi)

    @Update
    fun update(riwayatLokasi: RiwayatLokasi)

    @Delete
    fun delete(riwayatLokasi: RiwayatLokasi)

    @Query("SELECT * from riwayat_lokasi ORDER BY id ASC")
    fun getAllRiwayatLokasi() : LiveData<List<RiwayatLokasi>>

    @Query("SELECT * from riwayat_lokasi WHERE id = :id")
    fun getRiwayatLokasiWithId(id: Int) : LiveData<RiwayatLokasi>
}