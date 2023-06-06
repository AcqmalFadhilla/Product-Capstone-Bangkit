package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.relation.PlaceAndTourismCategory
import com.reev.telokkaapps.data.local.database.model.TourismPlaceDetail
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem

@Dao
interface TourismPlaceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tourismPlace: TourismPlace)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(tourismPlaces: List<TourismPlace>)

    @Update
    fun update(tourismPlace: TourismPlace)

    @Query("UPDATE tourism_place SET isFavorited = :isFavorited WHERE placeId = :id")
    fun updateFavoriteStatusOfTourismPlace(id: Int, isFavorited : Boolean)

    @Delete
    fun delete(tourismPlace: TourismPlace)

    @Query("SELECT * from tourism_place ORDER BY placeId ASC")
    fun getAllTourismPlace() : LiveData<List<TourismPlace>>

    @Query("SELECT * from tourism_place WHERE placeId = :id")
    fun getTourismPlaceWithId(id: Int) : LiveData<TourismPlace>

    @Transaction
    @Query("SELECT * from tourism_place ORDER BY placeId ASC")
    fun getPlaceTourismAndCategory() : LiveData<List<PlaceAndTourismCategory>>

    @Transaction
    @Query("SELECT placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl  from tourism_place LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_category.isFavorited = 1 ORDER BY tourism_place.placeName ASC")
    fun getPlaceTourismAndFavoriteCategory() : LiveData<List<TourismPlaceItem>>

    @Transaction
    @Query("SELECT placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeRating as placeRating, tourism_place.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl  from tourism_place LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE tourism_place.isFavorited = 1 ORDER BY tourism_place.placeName ASC")
    fun getFavoritedTourismPlace() : LiveData<List<TourismPlaceItem>>

    @Transaction
    @Query("SELECT placeId as placeId, tourism_place.placeName as placeName, tourism_category.categoryName as placeCategory, placeDescription as placeDescription, placeRating as placeRating, placeTags as placeTags, placeAddress as placeAddress, placeWebsite as placeWebsite, placePhone as placePhone,  tourism_place.isFavorited as isFavoritedPlace, placePhotoUrl as placePhotoUrl, placeMapUrl as placeMapUrl from tourism_place LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId WHERE placeId = :id")
    fun getDetailTourismPlaceWithId(id: Int) : LiveData<List<TourismPlaceDetail>>












}