package com.reev.telokkaapps.data.local.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.reev.telokkaapps.data.local.database.dao.LocationHistoryDao
import com.reev.telokkaapps.data.local.database.entity.LocationHistory
import com.reev.telokkaapps.helper.InitialDataSource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LocationRepository(application: Application) {
    private val mLocationHistoryDao : LocationHistoryDao

    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = LocationRoomDatabase.getDatabase(application)
        mLocationHistoryDao = db.locationHistoryDao()
    }

    fun insertAllData() {
//        mLocationHistoryDao.insertAll(InitialDataSource.getLocationHistory())
    }

    fun getAllLocationHistory() : LiveData<List<LocationHistory>> = mLocationHistoryDao.getAllLocationHistory()

    fun getLocationHistoryWithId(id: Int) = mLocationHistoryDao.getLocationHistoryWithId(id)
    fun getLatestLocation() = mLocationHistoryDao.getLatestLocation()

    fun insertLocationHistory(locationHistory: LocationHistory){
        executorService.execute{
            mLocationHistoryDao.insert(locationHistory)
        }
    }

    fun updateLocationHistory(locationHistory: LocationHistory){
        executorService.execute{
            mLocationHistoryDao.update(locationHistory)
        }
    }

    fun deleteLocationHistory(locationHistory: LocationHistory){
        executorService.execute{
            mLocationHistoryDao.delete(locationHistory)
        }
    }
}