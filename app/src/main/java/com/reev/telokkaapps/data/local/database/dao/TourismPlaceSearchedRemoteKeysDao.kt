package com.reev.telokkaapps.data.local.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceSearchedRemoteKeys
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem

@Dao
interface TourismPlaceSearchedRemoteKeysDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(remoteKey: List<TourismPlaceSearchedRemoteKeys>)

    @Query("SELECT * FROM place_searched_remote_keys WHERE id = :id")
    suspend fun getRemoteKeysId(id: Int): TourismPlaceSearchedRemoteKeys?

    @Query("DELETE FROM place_searched_remote_keys")
    suspend fun deleteRemoteKeys()

    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId ORDER BY place_searched_remote_keys.orderr ASC")
    fun getTourismPlaceSearched() : PagingSource<Int, TourismPlaceItem>

    // category, city, order rating
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.idCategory = :categoryId  AND tourism_place.city = :city ORDER BY tourism_place.placeRating ASC")
    fun getTourismPlaceSearchedWithOrderRatingASC(categoryId: Int, city: String) : PagingSource<Int, TourismPlaceItem>

    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.idCategory = :categoryId  AND tourism_place.city = :city ORDER BY tourism_place.placeRating DESC")
    fun getTourismPlaceSearchedWithOrderRatingDESC(categoryId: Int, city: String) : PagingSource<Int, TourismPlaceItem>

    // category, city
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.idCategory = :categoryId  AND tourism_place.city = :city ORDER BY place_searched_remote_keys.orderr ASC")
    fun getTourismPlaceSearched(categoryId: Int, city: String) : PagingSource<Int, TourismPlaceItem>

    // category, order rating
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.idCategory = :categoryId ORDER BY tourism_place.placeRating ASC")
    fun getTourismPlaceSearchedWithOrderRatingASC(categoryId: Int) : PagingSource<Int, TourismPlaceItem>
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.idCategory = :categoryId ORDER BY tourism_place.placeRating DESC")
    fun getTourismPlaceSearchedWithOrderRatingDESC(categoryId: Int) : PagingSource<Int, TourismPlaceItem>

    // city, order rating
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.city = :city ORDER BY tourism_place.placeRating ASC")
    fun getTourismPlaceSearchedWithOrderRatingASC(city: String) : PagingSource<Int, TourismPlaceItem>
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.city = :city ORDER BY tourism_place.placeRating DESC")
    fun getTourismPlaceSearchedWithOrderRatingDESC(city: String) : PagingSource<Int, TourismPlaceItem>

    // category
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.idCategory = :categoryId ORDER BY place_searched_remote_keys.orderr ASC")
    fun getTourismPlaceSearched(categoryId: Int) : PagingSource<Int, TourismPlaceItem>

    // city
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.city = :city ORDER BY place_searched_remote_keys.orderr ASC")
    fun getTourismPlaceSearched(city: String) : PagingSource<Int, TourismPlaceItem>

    //order rating
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId ORDER BY tourism_place.placeRating ASC")
    fun getTourismPlaceSearchedWithOrderRatingASC() : PagingSource<Int, TourismPlaceItem>
    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl,tourism_place.placeDistance as placeDistance  from place_searched_remote_keys LEFT JOIN tourism_place ON place_searched_remote_keys.id = tourism_place.placeId LEFT JOIN tourism_place_interaction ON place_searched_remote_keys.id = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId ORDER BY tourism_place.placeRating DESC")
    fun getTourismPlaceSearchedWithOrderRatingDESC() : PagingSource<Int, TourismPlaceItem>





}