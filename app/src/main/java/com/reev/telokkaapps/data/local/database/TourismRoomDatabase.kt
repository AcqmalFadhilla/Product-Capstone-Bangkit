package com.reev.telokkaapps.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reev.telokkaapps.data.local.database.dao.TourismCategoryDao
import com.reev.telokkaapps.data.local.database.dao.TourismPlanDao
import com.reev.telokkaapps.data.local.database.dao.TourismPlaceDao
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.TourismPlan


@Database(entities = [TourismCategory::class, TourismPlan::class, TourismPlace::class], version = 1)
abstract class TourismRoomDatabase : RoomDatabase() {
    abstract fun tourismCategoryDao(): TourismCategoryDao
    abstract fun tourismPlanDao(): TourismPlanDao
    abstract fun tourismPlaceDao(): TourismPlaceDao
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