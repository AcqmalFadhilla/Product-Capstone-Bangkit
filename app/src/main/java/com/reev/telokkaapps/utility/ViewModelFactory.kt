package com.reev.telokkaapps.utility

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reev.telokkaapps.data.repository.PlaceRepository
import com.reev.telokkaapps.ui.dashboard.fragment.home.HomeViewModel
import com.reev.telokkaapps.ui.dashboard.fragment.planning.PlanningViewModel
import com.reev.telokkaapps.ui.detail.DetailViewModel
import com.reev.telokkaapps.ui.formplanning.FormPlanningViewModel

class ViewModelFactory(private val repository: PlaceRepository)
    : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        else if (modelClass.isAssignableFrom(PlanningViewModel::class.java)) {
            return PlanningViewModel(repository) as T
        }
        else if (modelClass.isAssignableFrom(FormPlanningViewModel::class.java)) {
            return FormPlanningViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}