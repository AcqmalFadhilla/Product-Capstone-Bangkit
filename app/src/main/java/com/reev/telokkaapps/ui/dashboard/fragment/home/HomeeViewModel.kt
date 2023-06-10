package com.reev.telokkaapps.ui.dashboard.fragment.home

import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.repository.PlaceRepository

class HomeeViewModel(private val placeRepository: PlaceRepository) : ViewModel() {
    fun getTourismPlaceRecommended(latitude: Double, longitude: Double) = placeRepository.getPlaceNearest(latitude, longitude)
}
