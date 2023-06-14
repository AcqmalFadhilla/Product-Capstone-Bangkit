package com.reev.telokkaapps.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.paging.*
import com.reev.telokkaapps.data.local.database.TourismRoomDatabase
import com.reev.telokkaapps.data.local.database.dao.*
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.TourismPlace
import com.reev.telokkaapps.data.local.database.entity.TourismPlan
import com.reev.telokkaapps.data.local.database.model.TourismPlaceItem
import com.reev.telokkaapps.data.remote.ApiConfig
import com.reev.telokkaapps.data.remote.ApiService
import com.reev.telokkaapps.data.remote.pagingsource.ListPlaceSearchedPagingSource
import com.reev.telokkaapps.data.remote.pagingsource.ListPlaceWithCategoryPagingSource
import com.reev.telokkaapps.data.remote.response.PlaceResponse
import com.reev.telokkaapps.data.remote.response.TourismPlaceResponse
import com.reev.telokkaapps.data.remote.response.ListPlaceItem
import com.reev.telokkaapps.helper.InitialDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.reev.telokkaapps.data.remote.Result
import com.reev.telokkaapps.data.remote.remotemediator.TourismPlaceNearestRemoteMediator
import com.reev.telokkaapps.data.remote.remotemediator.TourismPlaceSearchedRemoteMediator
import com.reev.telokkaapps.data.remote.remotemediator.TourismPlaceWithCategoryRemoteMediator

class TourismRepository(application: Application) {
    private val mTourismCategoryDao : TourismCategoryDao
    private val mTourismPlanDao : TourismPlanDao
    private val mTourismPlaceDao : TourismPlaceDao
    private val mTourismPlaceInteractionDao : TourismPlaceInteractionDao
    private val mTourismPlaceNearestRemoteKeysDao : TourismPlaceNearestRemoteKeysDao
    private val mTourismPlaceSearchedRemoteKeysDao : TourismPlaceSearchedRemoteKeysDao
    private val apiService : ApiService
    private val mTourismRoomDatabase : TourismRoomDatabase

    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        mTourismRoomDatabase = TourismRoomDatabase.getDatabase(application)
        mTourismCategoryDao = mTourismRoomDatabase.tourismCategoryDao()
        mTourismPlanDao = mTourismRoomDatabase.tourismPlanDao()
        mTourismPlaceDao = mTourismRoomDatabase.tourismPlaceDao()
        mTourismPlaceInteractionDao = mTourismRoomDatabase.tourismPlaceInteractionDao()
        mTourismPlaceNearestRemoteKeysDao = mTourismRoomDatabase.tourismPlaceNearestRemoteKeysDao()
        mTourismPlaceSearchedRemoteKeysDao = mTourismRoomDatabase.tourismPlaceSearchedRemoteKeysDao()
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
    fun getPlaceTourismWithCategory(idCategory : Int) = mTourismPlaceDao.getPlaceTourismWithCategory(idCategory)

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
    @OptIn(ExperimentalPagingApi::class)
    fun getNewTourismPlaceRecomended(latitude: Double, longitude: Double) : LiveData<PagingData<TourismPlaceItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = TourismPlaceNearestRemoteMediator(mTourismRoomDatabase, apiService, latitude = latitude, longitude = longitude),

            pagingSourceFactory = {
                mTourismPlaceDao.getTourismPlaceRecomended()
            }
        ).liveData
    }

    @OptIn(ExperimentalPagingApi::class)
    fun getNewTourismPlaceWithCategory(category: String, idCategory: Int) : LiveData<PagingData<TourismPlaceItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = TourismPlaceWithCategoryRemoteMediator(mTourismRoomDatabase, apiService, category),
            pagingSourceFactory = {
                mTourismPlaceDao.getPlaceTourismWithCategoryPaged(idCategory)
            }
        ).liveData
    }

    @OptIn(ExperimentalPagingApi::class)
    fun getNewTourismPlaceSearched(query: String) : LiveData<PagingData<TourismPlaceItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = TourismPlaceSearchedRemoteMediator(mTourismRoomDatabase, apiService,query),
            pagingSourceFactory = {
                mTourismPlaceDao.getTourismPlaceSearched()
            }
        ).liveData
    }

    private val result = MediatorLiveData<Result<List<TourismPlaceResponse>>>()

    fun getNewDetailTourismPlace(id : Int) : LiveData<Result<List<TourismPlaceResponse>>> {
        result.value = Result.Loading
        val client = ApiConfig.getApiService().getPlaceWithId(id)
        client.enqueue(object : Callback<PlaceResponse> {
            override fun onResponse(
                call: Call<PlaceResponse>,
                response: Response<PlaceResponse>
            ) {
                if(response.isSuccessful){
                    result.value = Result.Success(response.body()!!.data)
                }
            }

            override fun onFailure(call: Call<PlaceResponse>, t: Throwable) {
                result.value = Result.Error(t.message.toString())
            }

        })

        return result

    }




}