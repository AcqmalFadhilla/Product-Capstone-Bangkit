package com.reev.telokkaapps.data.local.database.dao

import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.TourismPlaceInteraction

@Dao
interface TourismPlaceInteractionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(interaction: TourismPlaceInteraction)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(interaction: List<TourismPlaceInteraction>)

    @Update
    fun update(interaction: TourismPlaceInteraction)

    @Query("UPDATE tourism_place_interaction SET isRecommended = 0 WHERE isRecommended = 1")
    fun unRecommendAllTourismPlace()

    @Query("UPDATE tourism_place_interaction SET isRecommended = 1 WHERE placeId = :ids")
    fun recommendTourismPlace(ids : Int)

    @Query("UPDATE tourism_place_interaction SET isSearched = 0 WHERE isSearched = 1")
    fun unSearchAllTourismPlace()

    @Query("UPDATE tourism_place_interaction SET isSearched = 1 WHERE placeId = :ids")
    fun searchTourismPlace(ids : Int)

    @Delete
    fun delete(interaction: TourismPlaceInteraction)


//    @Query("SELECT * from tourism_place ORDER BY placeId ASC")
//    fun getAllTourismPlace() : LiveData<List<TourismPlace>>
//
//    @Query("SELECT * from tourism_place WHERE placeId = :id")
//    fun getTourismPlaceWithId(id: Int) : LiveData<TourismPlace>
//
//    @Transaction
//    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, tourism_place.placeRating as  placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace , tourism_place.placePhotoUrl as placePhotoUrl from tourism_place LEFT JOIN tourism_place_interaction ON tourism_place.placeId = tourism_place_interaction.placeId LEFT JOIN tourism_category ORDER BY placeId ASC")
//    fun getPlaceTourismAndCategory() : LiveData<List<TourismPlaceItem>>
//
//    @Transaction
//    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl  from tourism_place LEFT JOIN tourism_place_interaction ON tourism_place.placeId = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_category.isFavorited = 1 ORDER BY tourism_place.placeName ASC")
//    fun getPlaceTourismAndFavoriteCategory() : LiveData<List<TourismPlaceItem>>
//
//    @Transaction
//    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl  from tourism_place LEFT JOIN tourism_place_interaction ON tourism_place.placeId = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place_interaction.isRecomended = 1 ORDER BY tourism_place.placeName ASC")
//    fun getTourismPlaceRecomended() : LiveData<List<TourismPlaceItem>>
//
//    @Transaction
//    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl  from tourism_place LEFT JOIN tourism_place_interaction ON tourism_place.placeId = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place_interaction.isFavorited = 1 ORDER BY tourism_place.placeName ASC")
//    fun getFavoritedTourismPlace() : LiveData<List<TourismPlaceItem>>
//
//    @Transaction
//    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeDescription as placeDescription, placeRating as placeRating, placeTags as placeTags, placeAddress as placeAddress, placeWebsite as placeWebsite, placePhone as placePhone,  tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl, placeMapUrl as placeMapUrl from tourism_place LEFT JOIN tourism_place_interaction ON tourism_place.placeId = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.placeId = :id")
//    fun getDetailTourismPlaceWithId(id: Int) : LiveData<List<TourismPlaceDetail>>
//
//
//    @Query("SELECT tourism_place.placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place_interaction.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl  from tourism_place LEFT JOIN tourism_place_interaction ON tourism_place.placeId = tourism_place_interaction.placeId LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.idCategory = :idCategory ORDER BY tourism_place.placeName ASC")
//    fun getPlaceTourismWithCategory(idCategory: Int) : LiveData<List<TourismPlaceItem>>
















}