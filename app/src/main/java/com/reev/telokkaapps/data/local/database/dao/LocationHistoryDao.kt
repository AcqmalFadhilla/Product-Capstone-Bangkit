package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.LocationHistory

@Dao
interface LocationHistoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(locationHistory: LocationHistory)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(locationHistory: List<LocationHistory>)

    @Update
    fun update(locationHistory: LocationHistory)

    @Delete
    fun delete(locationHistory: LocationHistory)

    @Query("SELECT * from location_history ORDER BY historyId ASC")
    fun getAllLocationHistory() : LiveData<List<LocationHistory>>

    @Query("SELECT * from location_history WHERE historyId = :id")
    fun getLocationHistoryWithId(id: Int) : LiveData<LocationHistory>

    @Query("SELECT * FROM location_history ORDER BY historyId DESC LIMIT 1")
    fun getLatestLocation() : LiveData<LocationHistory>


}