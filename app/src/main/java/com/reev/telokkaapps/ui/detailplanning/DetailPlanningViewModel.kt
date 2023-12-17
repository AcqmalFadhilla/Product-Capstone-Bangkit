package com.reev.telokkaapps.ui.detailplanning

import android.app.Application
import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.repository.TourismRepository

class DetailPlanningViewModel(app: Application) : ViewModel() {
    private val mTourismRepository: TourismRepository = TourismRepository(app)

    fun getDetailTourismPlanWithId(id : Int) = mTourismRepository.getDetailTourismPlanWithId(id)

    fun updateDoneStatusOfTourismPlan(id: Int, isDone: Boolean){
        mTourismRepository.updateDoneStatusOfTourismPlan(id, isDone)
    }


}