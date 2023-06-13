package com.reev.telokkaapps.ui.dashboard.fragment.explore

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.reev.telokkaapps.data.remote.response.ListPlaceItem
import com.reev.telokkaapps.data.repository.TourismRepository

class ExploreViewModel(app : Application) : ViewModel() {
    private val mTourismRepository: TourismRepository = TourismRepository(app)
    fun getPlaceTourismAndCategory() = mTourismRepository.getPlaceTourismAndCategory()

    fun getNewTourismPlaceSearched(query : String, category: String, city : String, orderRating: Boolean) : LiveData<PagingData<ListPlaceItem>> {
        return mTourismRepository.getNewTourismPlaceSearched( query = query,category = category, city = city,orderRating = orderRating)
    }

}