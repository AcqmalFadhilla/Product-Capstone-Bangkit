package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceNearestRemoteKeys
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem

@Dao
interface TourismPlaceNearestRemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(remoteKey: List<TourismPlaceNearestRemoteKeys>)

    @Query("SELECT * FROM place_nearest_remote_keys WHERE id = :id")
    suspend fun getRemoteKeysId(id: Int): TourismPlaceNearestRemoteKeys?

    @Query("DELETE FROM place_nearest_remote_keys")
    suspend fun deleteRemoteKeys()

    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_nearest_remote_keys LEFT JOIN tourism_place ON place_nearest_remote_keys.id = tourism_place.placeId  LEFT JOIN tourism_place_interaction ON place_nearest_remote_keys.id = tourism_place_interaction.placeId  LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId ORDER BY tourism_place.placeDistance ASC")
    fun getTourismPlaceNearest() : PagingSource<Int, TourismPlaceItem>

    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_nearest_remote_keys LEFT JOIN tourism_place ON place_nearest_remote_keys.id = tourism_place.placeId  LEFT JOIN tourism_place_interaction ON place_nearest_remote_keys.id = tourism_place_interaction.placeId  LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId ORDER BY tourism_place.placeDistance ASC LIMIT :limit ")
    fun getAllTourismPlaceNearestSaved(limit : Int) : LiveData<List<TourismPlaceItem>>




}