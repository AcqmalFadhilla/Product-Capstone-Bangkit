package com.reev.telokkaapps.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceNearestRemoteKeys
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceSearchedRemoteKeys

@Dao
interface TourismPlaceSearchedRemoteKeysDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(remoteKey: List<TourismPlaceSearchedRemoteKeys>)

    @Query("SELECT * FROM place_searched_remote_keys WHERE id = :id")
    suspend fun getRemoteKeysId(id: Int): TourismPlaceSearchedRemoteKeys?

    @Query("DELETE FROM place_searched_remote_keys")
    suspend fun deleteRemoteKeys()

}