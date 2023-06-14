package com.reev.telokkaapps.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceNearestRemoteKeys

@Dao
interface TourismPlaceNearestRemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(remoteKey: List<TourismPlaceNearestRemoteKeys>)

    @Query("SELECT * FROM place_nearest_remote_keys WHERE id = :id")
    suspend fun getRemoteKeysId(id: Int): TourismPlaceNearestRemoteKeys?

    @Query("DELETE FROM place_nearest_remote_keys")
    suspend fun deleteRemoteKeys()

}