package com.reev.telokkaapps.ui.testing

import android.content.Context
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.reev.telokkaapps.data.remote.response.QuoteResponseItem
import com.reev.telokkaapps.data.repository.QuoteRepository
import com.reev.telokkaapps.di.Injection

class TestViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    val quote: LiveData<PagingData<QuoteResponseItem>> =
        quoteRepository.getQuote().cachedIn(viewModelScope)
}
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TestViewModel(Injection.provideRepository(context)) as T
        }else if (modelClass.isAssignableFrom(ExploreViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ExploreViewModel(Injection.providePlaceRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}