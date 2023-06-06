package com.reev.telokkaapps.data.local.database.dao

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.*
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.data.local.database.model.TourismPlanItem

@Dao
interface TourismPlanDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(plan : TourismPlan)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(plan : List<TourismPlan>)

    @Update
    fun update(plan: TourismPlan)

    @Delete
    fun delete(plan: TourismPlan)

    @Query("DELETE FROM tourism_plan")
    fun deleteAllTourismPlan()

    @Query("SELECT * from tourism_plan WHERE planId = :id")
    fun getTourismPlanWithId(id: Int) : LiveData<TourismPlan>

    @Query("SELECT * from tourism_plan ORDER BY planId ASC")
    fun getAllTourismPlan() : LiveData<List<TourismPlan>>

    @Transaction
    @Query("SELECT tourism_plan.planId as idRencana, tourism_plan.planTitle as judul, tourism_place.placeName as namaTempat, tourism_category.categoryName as kategori   FROM tourism_plan \n" +
            "LEFT JOIN tourism_place ON tourism_plan.idPlace = tourism_place.placeId \n" +
            "LEFT JOIN tourism_category ON tourism_place.idCategory = tourism_category.categoryId")
    fun getAllPlanWithPlaceAndTourismCategory() : LiveData<List<TourismPlanItem>>

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