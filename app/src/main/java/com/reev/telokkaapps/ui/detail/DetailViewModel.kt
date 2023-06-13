package com.reev.telokkaapps.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import com.reev.telokkaapps.data.repository.PlaceRepository
import com.reev.telokkaapps.data.repository.TourismRepository

class DetailViewModel (
    private val app: Application
) : ViewModel() {

    private val mTourismRepository: TourismRepository = TourismRepository(app)

    fun getNewDetailTourismPlace(id : Int)= mTourismRepository.getNewDetailTourismPlace(id)



}