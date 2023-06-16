package com.reev.telokkaapps.ui.dashboard.fragment.explore

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem
import com.reev.telokkaapps.data.remote.response.ListPlaceItem
import com.reev.telokkaapps.data.remote.response.TourismPlaceResponse
import com.reev.telokkaapps.data.repository.TourismRepository

class ExploreViewModel(app : Application) : ViewModel() {
    private val mTourismRepository: TourismRepository = TourismRepository(app)
    fun getPlaceTourismAndCategory() = mTourismRepository.getPlaceTourismAndCategory()

    fun getNewTourismPlaceSearched(query : String, idCategory: Int?, city : String?, orderRating: Boolean?) : LiveData<PagingData<TourismPlaceItem>> {
        return mTourismRepository.getNewTourismPlaceSearched( query = query, idCategory = idCategory, city = city, orderRating =  orderRating)
    }

}