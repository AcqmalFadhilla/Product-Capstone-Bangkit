package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi

@Dao
interface RiwayatLokasiDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(riwayatLokasi: RiwayatLokasi)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(riwayatLokasi: List<RiwayatLokasi>)

    @Update
    fun update(riwayatLokasi: RiwayatLokasi)

    @Delete
    fun delete(riwayatLokasi: RiwayatLokasi)

    @Query("SELECT * from riwayat_lokasi ORDER BY idRiwayat ASC")
    fun getAllRiwayatLokasi() : LiveData<List<RiwayatLokasi>>

    @Query("SELECT * from riwayat_lokasi WHERE idRiwayat = :id")
    fun getRiwayatLokasiWithId(id: Int) : LiveData<RiwayatLokasi>

    @Query("SELECT * FROM riwayat_lokasi ORDER BY idRiwayat DESC LIMIT 1")
    fun getLokasiTerbaru() : LiveData<RiwayatLokasi>


}