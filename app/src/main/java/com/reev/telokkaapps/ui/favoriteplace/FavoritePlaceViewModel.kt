package com.reev.telokkaapps.ui.favoriteplace

import android.app.Application
import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.repository.TourismRepository

class FavoritePlaceViewModel(app : Application) : ViewModel() {
    private val mTourismRepository: TourismRepository = TourismRepository(app)

    fun getAllTourismPlaceFavorited() = mTourismRepository.getFavoritedTourismPlace()


}