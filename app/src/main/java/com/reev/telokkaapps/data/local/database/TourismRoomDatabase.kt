package com.reev.telokkaapps.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reev.telokkaapps.data.local.database.dao.*
import com.reev.telokkaapps.data.local.database.entity.*


@Database(
    entities = [
        TourismCategory::class,
        TourismPlan::class,
        TourismPlace::class,
        TourismPlaceInteraction::class,
        TourismPlaceNearestRemoteKeys::class,
        TourismPlaceSearchedRemoteKeys::class,
        TourismPlaceWithCategoryRemoteKeys::class ],
    version = 1
)
abstract class TourismRoomDatabase : RoomDatabase() {
    abstract fun tourismCategoryDao(): TourismCategoryDao
    abstract fun tourismPlanDao(): TourismPlanDao
    abstract fun tourismPlaceDao(): TourismPlaceDao
    abstract fun tourismPlaceInteractionDao(): TourismPlaceInteractionDao
    abstract fun tourismPlaceNearestRemoteKeysDao(): TourismPlaceNearestRemoteKeysDao
    abstract fun tourismPlaceSearchedRemoteKeysDao(): TourismPlaceSearchedRemoteKeysDao
    abstract fun tourismPlaceWithCategoryRemoteKeysDao(): TourismPlaceWithCategoryRemoteKeysDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): TourismRoomDatabase {
            if (INSTANCE == null) {
                synchronized(TourismRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        TourismRoomDatabase::class.java, "tourism")
                        .build()
                }
            }
            return INSTANCE as TourismRoomDatabase
        }
    }
}