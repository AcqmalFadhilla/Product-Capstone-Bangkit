package com.reev.telokkaapps

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reev.telokkaapps.data.repository.LocationRepository
import com.reev.telokkaapps.data.repository.TourismRepository
import com.reev.telokkaapps.data.local.database.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OneViewModel(application: Application) : ViewModel(){
    private val mTourismRepository: TourismRepository = TourismRepository(application)
    private val mLocationRepository: LocationRepository = LocationRepository(application)


    init {
        insertAllData()
    }

    private fun insertAllData() = viewModelScope.launch(Dispatchers.IO) {
        mTourismRepository.insertAllData()
        mLocationRepository.insertAllData()
    }


    fun getAllTourismCategories() : LiveData<List<TourismCategory>> = mTourismRepository.getAllTourismCategories()

    fun getTourismCategoryWithId(categoryId: Int) = mTourismRepository.getTourismCategoryWithId(categoryId)

    fun insertTourismCategory(tourismCategory: TourismCategory){
        mTourismRepository.insertTourismCategory(tourismCategory)
    }

    fun updateTourismCategory(tourismCategory: TourismCategory){
        mTourismRepository.updateTourismCategory(tourismCategory)
    }
    fun updateFavoriteStatusOfTourismCategory(id: Int, isFavorited: Boolean){
        mTourismRepository.updateFavoriteStatusOfTourismCategory(id, isFavorited)
    }

    fun deleteTourismCategory(tourismCategory: TourismCategory){
        mTourismRepository.deleteTourismCategory(tourismCategory)
    }

    // Tempat Wisata

    fun getAllTourismPlace() : LiveData<List<TourismPlace>> = mTourismRepository.getAllTourismPlace()

    fun getTourismPlaceWithId(idTempatWisata: Int) = mTourismRepository.getTourismPlaceWithId(idTempatWisata)

    fun insertTourismPlace(tourismPlace: TourismPlace){
        mTourismRepository.insertTourismPlace(tourismPlace)
    }

    fun updateTourismPlace(tourismPlace: TourismPlace){
        mTourismRepository.updateTourismPlace(tourismPlace)
    }

    fun updateFavoriteStatusOfTourismPlace(id: Int, statusFavorite: Boolean){
        mTourismRepository.updateFavoriteStatusOfTourismPlace(id, statusFavorite)
    }

    fun deleteTourismPlace(tourismPlace: TourismPlace){
        mTourismRepository.deleteTourismPlace(tourismPlace)
    }

    // Rencana Wisata

    fun getAllTourismPlan() : LiveData<List<TourismPlan>> = mTourismRepository.getAllTourismPlan()

    fun getTourismPlanWithId(id: Int) = mTourismRepository.getTourismPlanWithId(id)

    fun insertTourismPlan(plan: TourismPlan){
        mTourismRepository.insertTourismPlan(plan)
    }

    fun updateTourismPlan(plan: TourismPlan){
        mTourismRepository.updateTourismPlan(plan)
    }
    fun updateDoneStatusOfTourismPlan(id: Int, isDone: Boolean){
        mTourismRepository.updateDoneStatusOfTourismPlan(id, isDone)
    }

    fun deleteTourismPlan(rencanaWisata: TourismPlan){
        mTourismRepository.deleteTourismPlan(rencanaWisata)
    }
    fun deleteAllTourismPlan(){
        mTourismRepository.deleteAllTourismPlan()
    }
    // Riwayat Lokasi

    fun getAllLocationHistory() : LiveData<List<LocationHistory>> = mLocationRepository.getAllLocationHistory()

    fun getLocationHistoryWithId(idRiwayatLokasi: Int) = mLocationRepository.getLocationHistoryWithId(idRiwayatLokasi)
    fun getLatestLocation() = mLocationRepository.getLatestLocation()

    fun insertLocationHistory(locationHistory: LocationHistory){
        mLocationRepository.insertLocationHistory(locationHistory)
    }

    fun updateLocationHistory(locationHistory: LocationHistory){
        mLocationRepository.updateLocationHistory(locationHistory)
    }

    fun deleteLocationHistory(locationHistory: LocationHistory){
        mLocationRepository.deleteLocationHistory(locationHistory)
    }



    // Relasi Many To One - Tempat dan Kategori Wisata
    fun getPlaceTourismAndCategory() = mTourismRepository.getPlaceTourismAndCategory()
    fun getPlaceTourismAndFavoriteCategory() = mTourismRepository.getPlaceTourismAndFavoriteCategory()
    fun getFavoritedTourismPlace() = mTourismRepository.getFavoritedTourismPlace()
    fun getDetailTourismPlaceWithId(id : Int) = mTourismRepository.getDetailTourismPlaceWithId(id)

    // Relasi One To Many - Kategori dan Tempat Wisata
    fun getCategoryAndTourismPlace() = mTourismRepository.getCategoryAndTourismPlace()

    // Relasi Many To One - Rencana dan Tempat Kategori Wisata
    fun getAllPlanWithPlaceAndTourismCategory() = mTourismRepository.getAllPlanWithPlaceAndTourismCategory()



}