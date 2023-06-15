package com.reev.telokkaapps.data.local.database.dao

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.data.local.database.model.TourismPlanDetail
import com.reev.telokkaapps.data.local.database.model.TourismPlanItem

@Dao
interface TourismPlanDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(plan : TourismPlan)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(plan : List<TourismPlan>)

    @Update
    fun update(plan: TourismPlan)

    @Query("UPDATE tourism_plan SET planStatus = :isDone WHERE planId = :id")
    fun updateDoneStatusOfTourismPlan(id: Int, isDone: Boolean)

    @Delete
    fun delete(plan: TourismPlan)

    @Query("DELETE FROM tourism_plan")
    fun deleteAllTourismPlan()

    @Query("SELECT * from tourism_plan WHERE planId = :id")
    fun getTourismPlanWithId(id: Int) : LiveData<TourismPlan>

    @Query("SELECT * from tourism_plan ORDER BY planId ASC")
    fun getAllTourismPlan() : LiveData<List<TourismPlan>>

    @Transaction
    @Query("SELECT tourism_plan.planId as planId, tourism_plan.planTitle as planTitle, tourism_place.placeName as placeName, tourism_category.categoryName as tourismCategory, tourism_plan.planDate as planDate, tourism_place.placePhotoUrl as placePhotoUrl, tourism_place.placeId as placeId FROM tourism_plan " +
            "LEFT JOIN tourism_place ON tourism_plan.idPlace = tourism_place.placeId \n" +
            "LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId")
    fun getAllPlanWithPlaceAndTourismCategory() : LiveData<List<TourismPlanItem>>

    @Transaction
    @Query("SELECT tourism_plan.planId as planId, tourism_plan.planTitle as planTitle, tourism_plan.planDescription as planDescription, tourism_place.placeName as placeName,tourism_place.placePhotoUrl as placePhotoUrl, tourism_place.placeRating as placeRating, tourism_place.placeTags as placeTags, tourism_place.placeAddress as placeAddress, tourism_place.placeWebsite as placeWebiste, tourism_place.placePhone as placePhone, tourism_place.placeDescription as placeDescription, tourism_place.placeMapUrl as placeMapUrl,tourism_category.categoryName as tourismCategory, tourism_plan.planDate as planDate, tourism_plan.planStatus as planStatus FROM tourism_plan " +
            "LEFT JOIN tourism_place ON tourism_plan.idPlace = tourism_place.placeId " +
            "LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId " +
            "WHERE planId = :id")
    fun getDetailTourismPlanWithId(id: Int) : LiveData<TourismPlanDetail>

}

class DeleteAllTourismPlansAsyncTask(dao: TourismPlanDao) : AsyncTask<Void, Void, Void>() {
    private val mAsyncTaskDao: TourismPlanDao

    init {
        mAsyncTaskDao = dao
    }

    override fun doInBackground(vararg voids: Void): Void? {
        mAsyncTaskDao.deleteAllTourismPlan()
        return null
    }
}