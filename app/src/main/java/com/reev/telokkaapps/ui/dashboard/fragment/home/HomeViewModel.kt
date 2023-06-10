package com.reev.telokkaapps.ui.dashboard.fragment.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.reev.telokkaapps.data.local.database.entity.LocationHistory
import com.reev.telokkaapps.data.repository.LocationRepository
import com.reev.telokkaapps.data.repository.TourismRepository
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.remote.response.ListPlaceItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel(app : Application) : ViewModel() {

    private val mTourismRepository: TourismRepository = TourismRepository(app)
    private val mLocationRepository: LocationRepository = LocationRepository(app)

    init {
        insertAllData()
    }

    private fun insertAllData() = viewModelScope.launch(Dispatchers.IO) {
        mTourismRepository.insertAllData()
        mLocationRepository.insertAllData()
    }
    fun getAllTourismCategories() : LiveData<List<TourismCategory>> = mTourismRepository.getAllTourismCategories()
    fun getPlaceTourismAndCategory() = mTourismRepository.getPlaceTourismAndCategory()

    fun getLatestLocation() = mLocationRepository.getLatestLocation()
    fun insertNewLocationHistory(locationHistory: LocationHistory) = mLocationRepository.insertLocationHistory(locationHistory)

//    fun getNewTourismPlaceRecomended(latitude: Double, longitude: Double)=  mTourismRepository.getNewTourismPlaceRecomended(latitude = latitude, longitude = longitude)
    fun getNewTourismPlaceRecomended(latitude: Double, longitude: Double) : LiveData<PagingData<ListPlaceItem>> {
        Log.i("dataResponse", "Masuk ke view Model")
        return mTourismRepository.getNewTourismPlaceRecomended(latitude = latitude, longitude = longitude)
    }

    fun getNewTourismPlaceWithCategory(category: String) : LiveData<PagingData<ListPlaceItem>>{
        return mTourismRepository.getNewTourismPlaceWithCategory(category = category)
    }
    fun getTourismPlaceRecomended()=  mTourismRepository.getTourismPlaceRecomended()

    fun getTourismCategoriesFavorited() = mTourismRepository.getTourismCategoriesFavorited()



}