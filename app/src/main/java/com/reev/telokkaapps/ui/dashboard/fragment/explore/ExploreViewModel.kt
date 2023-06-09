package com.reev.telokkaapps.ui.dashboard.fragment.explore

import android.app.Application
import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.local.database.TourismRepository

class ExploreViewModel(app : Application) : ViewModel() {
    private val mTourismRepository: TourismRepository = TourismRepository(app)
    fun getPlaceTourismAndCategory() = mTourismRepository.getPlaceTourismAndCategory()
}