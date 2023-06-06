package com.reev.telokkaapps.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.reev.telokkaapps.data.local.database.entity.TourismCategory
import com.reev.telokkaapps.data.local.database.entity.relation.CategoryAndTourismPlace


@Dao
interface TourismCategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(category : TourismCategory)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(categories : List<TourismCategory>)

    @Update
    fun update(category: TourismCategory)

    @Delete
    fun delete(category: TourismCategory)

    @Query("SELECT * from tourism_category ORDER BY categoryId ASC")
    fun getAllTourismCategories() : LiveData<List<TourismCategory>>

    @Query("SELECT * from tourism_category WHERE categoryId = :categoryId")
    fun getTourismCategoryWithId(categoryId: Int) : LiveData<TourismCategory>

    @Transaction
    @Query("SELECT * from tourism_category ORDER BY categoryId ASC")
    fun getCategoryAndTourismPlace(): LiveData<List<CategoryAndTourismPlace>>


}