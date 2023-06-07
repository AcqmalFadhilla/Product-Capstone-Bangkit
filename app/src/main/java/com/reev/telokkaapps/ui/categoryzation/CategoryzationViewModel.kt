package com.reev.telokkaapps.ui.categoryzation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reev.telokkaapps.data.local.database.LocationRepository
import com.reev.telokkaapps.data.local.database.TourismRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryzationViewModel(app : Application): ViewModel() {

    private val mTourismRepository: TourismRepository = TourismRepository(app)
    private val mLocationRepository: LocationRepository = LocationRepository(app)


    init {
        insertAllData()
    }

    private fun insertAllData() = viewModelScope.launch(Dispatchers.IO) {
        mTourismRepository.insertAllData()
        mLocationRepository.insertAllData()
    }

    fun getAllCategories() = mTourismRepository.getAllTourismCategories()


    fun updateFavoriteStatusOfTourismCategory(id: Int, isFavorited: Boolean){
        mTourismRepository.updateFavoriteStatusOfTourismCategory(id, isFavorited)
    }

}