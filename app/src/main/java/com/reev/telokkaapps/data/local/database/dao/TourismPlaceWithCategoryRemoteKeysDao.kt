package com.reev.telokkaapps.data.local.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceWithCategoryRemoteKeys
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem

@Dao
interface TourismPlaceWithCategoryRemoteKeysDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<TourismPlaceWithCategoryRemoteKeys>)

    @Query("SELECT * FROM place_category_remote_keys WHERE id = :id")
    suspend fun getRemoteKeysId(id: Int): TourismPlaceWithCategoryRemoteKeys?

    @Query("DELETE FROM place_category_remote_keys")
    suspend fun deleteRemoteKeys()

    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_category_remote_keys LEFT JOIN tourism_place on place_category_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_category_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.idCategory = :idCategory ORDER BY tourism_place.placeId ASC")
    fun getPlaceTourismWithCategoryPaged(idCategory: Int) : PagingSource<Int, TourismPlaceItem>
}