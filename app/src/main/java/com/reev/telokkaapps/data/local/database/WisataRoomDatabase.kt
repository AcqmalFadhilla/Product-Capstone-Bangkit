package com.reev.telokkaapps.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reev.telokkaapps.data.local.database.dao.KategoriWisataDao
import com.reev.telokkaapps.data.local.database.dao.RencanaWisataDao
import com.reev.telokkaapps.data.local.database.dao.TempatWisataDao
import com.reev.telokkaapps.data.local.database.entity.KategoriWisata
import com.reev.telokkaapps.data.local.database.entity.RencanaWisata
import com.reev.telokkaapps.data.local.database.entity.TempatWisata


@Database(entities = [KategoriWisata::class, RencanaWisata::class, TempatWisata::class], version = 1)
abstract class WisataRoomDatabase : RoomDatabase() {
    abstract fun kategoriWisataDao(): KategoriWisataDao
    abstract fun rencanaWisataDao(): RencanaWisataDao
    abstract fun tempatWisataDao(): TempatWisataDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): WisataRoomDatabase {
            if (INSTANCE == null) {
                synchronized(WisataRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        WisataRoomDatabase::class.java, "wisata_database")
                        .build()
                }
            }
            return INSTANCE as WisataRoomDatabase
        }
    }
}