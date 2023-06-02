package com.reev.telokkaapps.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reev.telokkaapps.data.local.database.dao.RiwayatLokasiDao
import com.reev.telokkaapps.data.local.database.entity.RiwayatLokasi

@Database(entities = [RiwayatLokasi::class], version = 1)
abstract class LokasiRoomDatabase : RoomDatabase() {
    abstract fun riwayatLokasiDao(): RiwayatLokasiDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): LokasiRoomDatabase {
            if (INSTANCE == null) {
                synchronized(LokasiRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        LokasiRoomDatabase::class.java, "lokasi_database")
                        .build()
                }
            }
            return INSTANCE as LokasiRoomDatabase
        }
    }



}