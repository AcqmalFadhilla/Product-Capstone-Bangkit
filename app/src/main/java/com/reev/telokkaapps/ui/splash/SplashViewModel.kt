package com.reev.telokkaapps.ui.splash

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.repository.LocationRepository
import com.reev.telokkaapps.data.repository.TourismRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(app: Application) : ViewModel(){
    private val mTourismRepository: TourismRepository = TourismRepository(app)
    private val mLocationRepository: LocationRepository = LocationRepository(app)

    init {
        insertAllData()
    }

    private fun insertAllData() = viewModelScope.launch(Dispatchers.IO) {
        mTourismRepository.insertAllData()
        mLocationRepository.insertAllData()
    }

    fun getAllTourismCategoryFavorited() : LiveData<TourismCategory> = mTourismRepository.getTourismCategoriesFavorited()

}