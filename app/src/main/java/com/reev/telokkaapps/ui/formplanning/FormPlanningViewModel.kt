package com.reev.telokkaapps.ui.formplanning

import android.app.Application
import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.local.database.LocationRepository
import com.reev.telokkaapps.data.local.database.TourismRepository
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.data.repository.PlaceRepository

class FormPlanningViewModel (app : Application) : ViewModel() {
    private val mTourismRepository: TourismRepository = TourismRepository(app)
    private val mLocationRepository: LocationRepository = LocationRepository(app)

    fun insertTourismPlan(newPlan : TourismPlan ) = mTourismRepository.insertTourismPlan(newPlan)



}