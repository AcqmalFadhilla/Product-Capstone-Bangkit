package com.reev.telokkaapps.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.reev.telokkaapps.data.local.database.QuoteDatabase
import com.reev.telokkaapps.data.remote.ApiService
import com.reev.telokkaapps.data.remote.pagingsource.QuotePagingSource
import com.reev.telokkaapps.data.remote.response.QuoteResponseItem

class QuoteRepository(private val quoteDatabase: QuoteDatabase, private val apiService: ApiService) {
    fun getQuote(): LiveData<PagingData<QuoteResponseItem>> {


        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                QuotePagingSource(apiService)
            }
        ).liveData
    }
}