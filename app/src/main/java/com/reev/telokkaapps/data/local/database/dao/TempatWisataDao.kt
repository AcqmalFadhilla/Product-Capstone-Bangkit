package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.TempatWisata
import com.reev.telokkaapps.data.local.database.entity.relation.TempatDanKategoriWisata
import com.reev.telokkaapps.data.local.database.model.ItemDetailtempatWisata
import com.reev.telokkaapps.data.local.database.model.ItemTempatWisata

@Dao
interface TempatWisataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tempatWisata: TempatWisata)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(listTempatWisata: List<TempatWisata>)

    @Update
    fun update(tempatWisata: TempatWisata)

    @Query("UPDATE tempat_wisata SET statusSuka = :statusFavorite WHERE idTempat = :id")
    fun updateStatusFavoriteTempatWisata(id: Int, statusFavorite : Boolean)

    @Delete
    fun delete(tempatWisata: TempatWisata)

    @Query("SELECT * from tempat_wisata ORDER BY idTempat ASC")
    fun getAllTempatWisata() : LiveData<List<TempatWisata>>

    @Query("SELECT * from tempat_wisata WHERE idTempat = :id")
    fun getTempatWisataWithId(id: Int) : LiveData<TempatWisata>

    @Transaction
    @Query("SELECT * from tempat_wisata ORDER BY idTempat ASC")
    fun getAllTempatDanKategori() : LiveData<List<TempatDanKategoriWisata>>

    @Transaction
    @Query("SELECT idTempat as id, tempat_wisata.nama as nama, kategori_wisata.nama as kategori, rating as rating, tempat_wisata.statusSuka as statusFavorite, urlGambar as urlGambar  from tempat_wisata LEFT JOIN kategori_wisata ON tempat_wisata.kategoriId = kategori_wisata.idKategori WHERE kategori_wisata.status = 1 ORDER BY tempat_wisata.nama ASC")
    fun getTempatWisataWithKategoriFavorite() : LiveData<List<ItemTempatWisata>>

    @Transaction
    @Query("SELECT idTempat as id, tempat_wisata.nama as nama, kategori_wisata.nama as kategori, rating as rating, tempat_wisata.statusSuka as statusFavorite, urlGambar as urlGambar  from tempat_wisata LEFT JOIN kategori_wisata ON tempat_wisata.kategoriId = kategori_wisata.idKategori WHERE tempat_wisata.statusSuka = 1 ORDER BY tempat_wisata.nama ASC")
    fun getTempatWisataFavorite() : LiveData<List<ItemTempatWisata>>

    @Transaction
    @Query("SELECT idTempat as id, tempat_wisata.nama as nama, kategori_wisata.nama as kategori, deskripsi as deskripsi, rating as rating, nRating as jumlahRating, tempat_wisata.jamBuka as jamBuka, tag as tag, alamat as alamat, website as website, noTelepon as noTelepon,  tempat_wisata.statusSuka as statusFavorite, urlGambar as urlGambar, urlMaps as urlMaps from tempat_wisata LEFT JOIN kategori_wisata ON tempat_wisata.kategoriId = kategori_wisata.idKategori WHERE idTempat = :id")
    fun getDetailTempatWisataWithId(id: Int) : LiveData<List<ItemDetailtempatWisata>>












}