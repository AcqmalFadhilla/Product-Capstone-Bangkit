package com.reev.telokkaapps.ui.dashboard

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reev.telokkaapps.data.local.database.LocationRepository
import com.reev.telokkaapps.data.local.database.TourismRepository
import com.reev.telokkaapps.data.local.database.entity.LocationHistory
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app : Application) : ViewModel() {
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


}