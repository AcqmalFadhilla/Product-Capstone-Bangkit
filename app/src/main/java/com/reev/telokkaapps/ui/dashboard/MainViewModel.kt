package com.reev.telokkaapps.ui.dashboard

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.repository.LocationRepository
import com.reev.telokkaapps.data.repository.TourismRepository
import com.reev.telokkaapps.data.local.database.entity.LocationHistory
import com.reev.telokkaapps.data.local.database.entity.TourismCategory

class MainViewModel(app : Application) : ViewModel() {

    private val mTourismRepository: TourismRepository = TourismRepository(app)
    private val mLocationRepository: LocationRepository = LocationRepository(app)


    fun getAllTourismCategories() : LiveData<List<TourismCategory>> = mTourismRepository.getAllTourismCategories()
    fun getPlaceTourismAndCategory() = mTourismRepository.getPlaceTourismAndCategory()
    fun getLatestLocation() = mLocationRepository.getLatestLocation()
    fun insertNewLocationHistory(locationHistory: LocationHistory) = mLocationRepository.insertLocationHistory(locationHistory)


}