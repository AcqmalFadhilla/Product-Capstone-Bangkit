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

    @Delete
    fun delete(interaction: TourismPlaceInteraction)

}