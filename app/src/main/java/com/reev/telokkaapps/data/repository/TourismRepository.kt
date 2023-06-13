package com.reev.telokkaapps.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.reev.telokkaapps.data.local.database.TourismRoomDatabase
import com.reev.telokkaapps.data.local.database.dao.DeleteAllTourismPlansAsyncTask
import com.reev.telokkaapps.data.local.database.dao.TourismCategoryDao
import com.reev.telokkaapps.data.local.database.dao.TourismPlanDao
import com.reev.telokkaapps.data.local.database.dao.TourismPlaceDao
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.data.remote.ApiConfig
import com.reev.telokkaapps.data.remote.ApiService
import com.reev.telokkaapps.data.remote.pagingsource.ListPlaceNearestPagingSource
import com.reev.telokkaapps.data.remote.pagingsource.ListPlaceSearchedPagingSource
import com.reev.telokkaapps.data.remote.pagingsource.ListPlaceWithCategoryPagingSource
import com.reev.telokkaapps.data.remote.response.DetailPlaceResponse
import com.reev.telokkaapps.data.remote.response.DetailTourismPlace
import com.reev.telokkaapps.data.remote.response.ListPlaceItem
import com.reev.telokkaapps.helper.InitialDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.reev.telokkaapps.data.remote.Result

class TourismRepository(application: Application) {
    private val mTourismCategoryDao : TourismCategoryDao
    private val mTourismPlanDao : TourismPlanDao
    private val mTourismPlaceDao : TourismPlaceDao
    private val apiService : ApiService

    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = TourismRoomDatabase.getDatabase(application)
        mTourismCategoryDao = db.tourismCategoryDao()
        mTourismPlanDao = db.tourismPlanDao()
        mTourismPlaceDao = db.tourismPlaceDao()
        apiService = ApiConfig.getApiService()
    }

    fun insertAllData() {
        mTourismPlaceDao.insertAll(InitialDataSource.getTourismPlace())
        mTourismCategoryDao.insertAll(InitialDataSource.getTourismCategory())
        mTourismPlanDao.insertAll(InitialDataSource.getTourismPlan())
    }

    //////// Query ke database ////////

    //// Kategori Wisata
    // Mendapatkan semua data kategori

    fun getAllTourismCategories() : LiveData<List<TourismCategory>> = mTourismCategoryDao.getAllTourismCategories()

    // Mendapatkan data kategori tertentu berdasarkan id database
    fun getTourismCategoryWithId(categoryId: Int) = mTourismCategoryDao.getTourismCategoryWithId(categoryId)

    // Mendapatkan data kategori favorite
    fun getTourismCategoriesFavorited() = mTourismCategoryDao.getTourismCategoriesFavorited()

    // Menambahkan kategori wisata
    fun insertTourismCategory(tourismCategory: TourismCategory){
        executorService.execute{
            mTourismCategoryDao.insert(tourismCategory)
        }
    }
    // Menambahkan list kategori
    fun insertAllTourismCategories(listTourismCategory: List<TourismCategory>){
        executorService.execute{
            mTourismCategoryDao.insertAll(listTourismCategory)
        }
    }

    // Memperbarui data Kategori
    fun updateTourismCategory(tourismCategory: TourismCategory){
        executorService.execute{
            mTourismCategoryDao.update(tourismCategory)
        }
    }

    // Memperbarui status favorite pada kategori
    fun updateFavoriteStatusOfTourismCategory(id: Int, isFavorited : Boolean){
        executorService.execute{
            mTourismCategoryDao.updateFavoriteStatusOfTourismCategory(id, isFavorited)
        }
    }

    // Menghapus kategori wisata
    fun deleteTourismCategory(tourismCategory: TourismCategory){
        executorService.execute{
            mTourismCategoryDao.delete(tourismCategory)
        }
    }

    //// Tempat Wisata
    // Mendapatkan seluruh data tempat wisata
    fun getAllTourismPlace() : LiveData<List<TourismPlace>> = mTourismPlaceDao.getAllTourismPlace()

    // Mendapatkan tempat wisata dengan ID
    fun getTourismPlaceWithId(idTempatWisata: Int) = mTourismPlaceDao.getTourismPlaceWithId(idTempatWisata)

    // Mendapatkan tempat wisata yang direkomendasikan
    fun getTourismPlaceRecomended() = mTourismPlaceDao.getTourismPlaceRecomended()

    // Menambahkan tempat wisata
    fun insertTourismPlace(tourismPlace: TourismPlace){
        executorService.execute{
            mTourismPlaceDao.insert(tourismPlace)
        }
    }

    // Menambahkan daftar tempat wisata
    fun insertAllTourismPlace(listTourismPlace: List<TourismPlace>){
        executorService.execute{
            mTourismPlaceDao.insertAll(listTourismPlace)
        }
    }

    // Memperbarui tempat wisata
    fun updateTourismPlace(tourismPlace: TourismPlace){
        executorService.execute{
            mTourismPlaceDao.update(tourismPlace)
        }
    }

    // Memperbarui status favorit tempat wisata
    fun updateFavoriteStatusOfTourismPlace(id: Int, statusFavorite: Boolean){
        executorService.execute {
            mTourismPlaceDao.updateFavoriteStatusOfTourismPlace(id, statusFavorite)
        }
    }


    // Menghapus tempat wisata
    fun deleteTourismPlace(tourismPlace: TourismPlace){
        executorService.execute{
            mTourismPlaceDao.delete(tourismPlace)
        }
    }

    //// Rencana Wisata

    // Mendapatkan seluruh data rencana wisata
    fun getAllTourismPlan() : LiveData<List<TourismPlan>> = mTourismPlanDao.getAllTourismPlan()

    // Mendapatkan data rencana wisata tertentu berdasarkan id
    fun getTourismPlanWithId(idRencanaWisata: Int) = mTourismPlanDao.getTourismPlanWithId(idRencanaWisata)

    // Menambahkan data rencana wisata
    fun insertTourismPlan(rencanaWisata: TourismPlan){
        executorService.execute{
            mTourismPlanDao.insert(rencanaWisata)
        }
    }

    // Memperbarui data rencana wisata
    fun updateTourismPlan(plan: TourismPlan){
        executorService.execute{
            mTourismPlanDao.update(plan)
        }
    }

    // Memperbarui status rencana tempat wisata
    fun updateDoneStatusOfTourismPlan(id: Int, isDone: Boolean){
        executorService.execute{
            mTourismPlanDao.updateDoneStatusOfTourismPlan(id, isDone)
        }
    }

    // Menghapus data rencana wisata
    fun deleteTourismPlan(plan: TourismPlan){
        executorService.execute{
            mTourismPlanDao.delete(plan)
        }
    }

    // Menghapus seluruh data rencana wisata
    fun deleteAllTourismPlan(){
        DeleteAllTourismPlansAsyncTask(mTourismPlanDao).execute()
    }

    // Relasi Database
    // Relasi Many To One - Tempat dan Kategori Wisata
    // Mendapatkan seluruh tempat wisata beserta data kategorinya
    fun getPlaceTourismAndCategory() = mTourismPlaceDao.getPlaceTourismAndCategory()

    // Mendapatkan seluruh tempat wisata beserta kategorinya berdasarkan kategori favorite user
    fun getPlaceTourismAndFavoriteCategory() = mTourismPlaceDao.getPlaceTourismAndFavoriteCategory()

    // Mendapatkan seluruh tempat wisata berdasarkan tempat wisata favorite user
    fun getFavoritedTourismPlace() = mTourismPlaceDao.getFavoritedTourismPlace()

    // Mendapatkan detail tempat wisata tertentu berdasarkan ID
    fun getDetailTourismPlaceWithId(id : Int) = mTourismPlaceDao.getDetailTourismPlaceWithId(id)




    // Relasi One To Many - Kategori dan Tempat Wisata

    // Mendapatkan seluruh data kategori wisata dan tempat wisatanya
    fun getCategoryAndTourismPlace() = mTourismCategoryDao.getCategoryAndTourismPlace()


    // Relasi Many To One - Rencana dan Tempat Kategori Wisata

    // Mendapatkan seluruh rencana dengan tempat dan kategori wisatanya
    fun getAllPlanWithPlaceAndTourismCategory() = mTourismPlanDao.getAllPlanWithPlaceAndTourismCategory()

    // Mendapatkan detail rencana dengan tempat dan kategori wisatanya
    fun getDetailTourismPlanWithId(id : Int) = mTourismPlanDao.getDetailTourismPlanWithId(id)

    //////// Remote (API) ////////
    fun getNewTourismPlaceRecomended(latitude: Double, longitude: Double) : LiveData<PagingData<ListPlaceItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                ListPlaceNearestPagingSource(apiService = apiService, latitide = latitude, longitude = longitude)
            }
        ).liveData
    }

    fun getNewTourismPlaceWithCategory(category: String) : LiveData<PagingData<ListPlaceItem>>{
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                ListPlaceWithCategoryPagingSource(apiService = apiService, category = category)
            }
        ).liveData
    }

    fun getNewTourismPlaceSearched(query: String, category: String, city: String, orderRating : Boolean) : LiveData<PagingData<ListPlaceItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                ListPlaceSearchedPagingSource(apiService = apiService, query = query, category =  category, city = city, orderRating = orderRating)
            }
        ).liveData
    }

    private val result = MediatorLiveData<Result<List<DetailTourismPlace>>>()

    fun getNewDetailTourismPlace(id : Int) : LiveData<Result<List<DetailTourismPlace>>> {
        result.value = Result.Loading
        val client = ApiConfig.getApiService().getPlaceWithId(id)
        client.enqueue(object : Callback<DetailPlaceResponse> {
            override fun onResponse(
                call: Call<DetailPlaceResponse>,
                response: Response<DetailPlaceResponse>
            ) {
                if(response.isSuccessful){
                    result.value = Result.Success(response.body()!!.data)
                }
            }

            override fun onFailure(call: Call<DetailPlaceResponse>, t: Throwable) {
                result.value = Result.Error(t.message.toString())
            }

        })

        return result

    }



}