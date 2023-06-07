package com.reev.telokkaapps.data.local.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.reev.telokkaapps.data.local.database.dao.DeleteAllTourismPlansAsyncTask
import com.reev.telokkaapps.data.local.database.dao.TourismCategoryDao
import com.reev.telokkaapps.data.local.database.dao.TourismPlanDao
import com.reev.telokkaapps.data.local.database.dao.TourismPlaceDao
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.helper.InitialDataSource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class TourismRepository(application: Application) {
    private val mTourismCategoryDao : TourismCategoryDao
    private val mTourismPlanDao : TourismPlanDao
    private val mTourismPlaceDao : TourismPlaceDao

    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = TourismRoomDatabase.getDatabase(application)
        mTourismCategoryDao = db.tourismCategoryDao()
        mTourismPlanDao = db.tourismPlanDao()
        mTourismPlaceDao = db.tourismPlaceDao()
    }

    fun insertAllData() {
        mTourismPlaceDao.insertAll(InitialDataSource.getTourismPlace())
        mTourismCategoryDao.insertAll(InitialDataSource.getTourismCategory())
        mTourismPlanDao.insertAll(InitialDataSource.getTourismPlan())
    }

    fun getAllTourismCategories() : LiveData<List<TourismCategory>> = mTourismCategoryDao.getAllTourismCategories()

    fun getTourismCategoryWithId(categoryId: Int) = mTourismCategoryDao.getTourismCategoryWithId(categoryId)

    fun insertTourismCategory(tourismCategory: TourismCategory){
        executorService.execute{
            mTourismCategoryDao.insert(tourismCategory)
        }
    }
    fun insertAllTourismCategories(listTourismCategory: List<TourismCategory>){
        executorService.execute{
            mTourismCategoryDao.insertAll(listTourismCategory)
        }
    }

    fun updateTourismCategory(tourismCategory: TourismCategory){
        executorService.execute{
            mTourismCategoryDao.update(tourismCategory)
        }
    }
    fun updateFavoriteStatusOfTourismCategory(id: Int, isFavorited : Boolean){
        executorService.execute{
            mTourismCategoryDao.updateFavoriteStatusOfTourismCategory(id, isFavorited)
        }
    }


    fun deleteTourismCategory(tourismCategory: TourismCategory){
        executorService.execute{
            mTourismCategoryDao.delete(tourismCategory)
        }
    }

    // Tempat Wisata

    fun getAllTourismPlace() : LiveData<List<TourismPlace>> = mTourismPlaceDao.getAllTourismPlace()

    fun getTourismPlaceWithId(idTempatWisata: Int) = mTourismPlaceDao.getTourismPlaceWithId(idTempatWisata)

    fun insertTourismPlace(tourismPlace: TourismPlace){
        executorService.execute{
            mTourismPlaceDao.insert(tourismPlace)
        }
    }

    fun insertAllTourismPlace(listTourismPlace: List<TourismPlace>){
        executorService.execute{
            mTourismPlaceDao.insertAll(listTourismPlace)
        }
    }

    fun updateTourismPlace(tourismPlace: TourismPlace){
        executorService.execute{
            mTourismPlaceDao.update(tourismPlace)
        }
    }

    fun updateFavoriteStatusOfTourismPlace(id: Int, statusFavorite: Boolean){
        executorService.execute {
            mTourismPlaceDao.updateFavoriteStatusOfTourismPlace(id, statusFavorite)
        }
    }

    fun deleteTourismPlace(tourismPlace: TourismPlace){
        executorService.execute{
            mTourismPlaceDao.delete(tourismPlace)
        }
    }

    // Rencana Wisata

    fun getAllTourismPlan() : LiveData<List<TourismPlan>> = mTourismPlanDao.getAllTourismPlan()

    fun getTourismPlanWithId(idRencanaWisata: Int) = mTourismPlanDao.getTourismPlanWithId(idRencanaWisata)

    fun insertTourismPlan(rencanaWisata: TourismPlan){
        executorService.execute{
            mTourismPlanDao.insert(rencanaWisata)
        }
    }

    fun updateTourismPlan(plan: TourismPlan){
        executorService.execute{
            mTourismPlanDao.update(plan)
        }
    }
    fun updateDoneStatusOfTourismPlan(id: Int, isDone: Boolean){
        executorService.execute{
            mTourismPlanDao.updateDoneStatusOfTourismPlan(id, isDone)
        }
    }

    fun deleteTourismPlan(plan: TourismPlan){
        executorService.execute{
            mTourismPlanDao.delete(plan)
        }
    }

    fun deleteAllTourismPlan(){
        DeleteAllTourismPlansAsyncTask(mTourismPlanDao).execute()
    }

    // Relasi Many To One - Tempat dan Kategori Wisata

    fun getPlaceTourismAndCategory() = mTourismPlaceDao.getPlaceTourismAndCategory()
    fun getPlaceTourismAndFavoriteCategory() = mTourismPlaceDao.getPlaceTourismAndFavoriteCategory()
    fun getFavoritedTourismPlace() = mTourismPlaceDao.getFavoritedTourismPlace()
    fun getDetailTourismPlaceWithId(id : Int) = mTourismPlaceDao.getDetailTourismPlaceWithId(id)




    // Relasi One To Many - Kategori dan Tempat Wisata
    fun getCategoryAndTourismPlace() = mTourismCategoryDao.getCategoryAndTourismPlace()


    // Relasi Many To One - Rencana dan Tempat Kategori Wisata
    fun getAllPlanWithPlaceAndTourismCategory() = mTourismPlanDao.getAllPlanWithPlaceAndTourismCategory()
    fun getDetailTourismPlanWithId(id : Int) = mTourismPlanDao.getDetailTourismPlanWithId(id)




}