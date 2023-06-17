package com.reev.telokkaapps.ui.dashboard.fragment.planning

import android.app.Application
import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.data.repository.LocationRepository
import com.reev.telokkaapps.data.repository.TourismRepository

class PlanningViewModel(app: Application) : ViewModel() {
    private val mTourismRepository: TourismRepository = TourismRepository(app)

    fun getAllPlanWithPlaceAndTourismCategory() =
        mTourismRepository.getAllPlanWithPlaceAndTourismCategory()

    fun deleteTourismPlanWithId(id: Int) = mTourismRepository.deleteTourismPlanWithId(id)
}