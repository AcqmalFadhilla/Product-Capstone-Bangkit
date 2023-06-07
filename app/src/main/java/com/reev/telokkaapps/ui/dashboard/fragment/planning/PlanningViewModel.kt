package com.reev.telokkaapps.ui.dashboard.fragment.planning

import android.app.Application
import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.local.database.LocationRepository
import com.reev.telokkaapps.data.local.database.TourismRepository
import com.reev.telokkaapps.data.repository.PlaceRepository

class PlanningViewModel(app: Application) : ViewModel() {
    private val mTourismRepository: TourismRepository = TourismRepository(app)
    private val mLocationRepository: LocationRepository = LocationRepository(app)

    fun getAllPlanWithPlaceAndTourismCategory() = mTourismRepository.getAllPlanWithPlaceAndTourismCategory()

}