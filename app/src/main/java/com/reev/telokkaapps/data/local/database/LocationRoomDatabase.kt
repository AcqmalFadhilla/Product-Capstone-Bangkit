package com.reev.telokkaapps.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reev.telokkaapps.data.local.database.dao.LocationHistoryDao
import com.reev.telokkaapps.data.local.database.entity.LocationHistory

@Database(entities = [LocationHistory::class], version = 1)
abstract class LocationRoomDatabase : RoomDatabase() {
    abstract fun locationHistoryDao(): LocationHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): LocationRoomDatabase {
            if (INSTANCE == null) {
                synchronized(LocationRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        LocationRoomDatabase::class.java, "location_database")
                        .build()
                }
            }
            return INSTANCE as LocationRoomDatabase
        }
    }



}