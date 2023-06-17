package com.reev.telokkaapps.data.remote.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.reev.telokkaapps.data.local.database.entity.TourismPlace

@Parcelize
data class DetailPlaceResponse(

	@field:SerializedName("data")
	val data: List<TourismPlaceResponse>,

	@field:SerializedName("succes")
	val succes: Boolean
) : Parcelable

@Entity(tableName = "detail_place")

@Parcelize
data class DetailTourismPlaceResponse(
	@PrimaryKey
	@field:SerializedName("ID")
	val id: Int,

	@field:SerializedName("Name")
	val name: String,

	@field:SerializedName("Category")
	val category: String,

	@field:SerializedName("Deskripsi")
	val description: String? = null,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("Kota")
	val kota: String? = null,

	@field:SerializedName("Address")
	val address: String,

	@field:SerializedName("Detail_URL")
	val detailURL: String,

	@field:SerializedName("Latitude")
	val latitude: Double,

	@field:SerializedName("Longitude")
	val longitude: Double,

	@field:SerializedName("Rating")
	val rating: Double,

	@field:SerializedName("Tags")
	val tags: String? = null,

	@field:SerializedName("Review")
	val review: String? = null,

	@field:SerializedName("Website")
	val website: String? = null,

	@field:SerializedName("Phone")
	val phone: String? = null
) : Parcelable {

	fun toTourismPlace() : TourismPlace{
		var categoryId : Int = 0
		var listCategory= listOf<String>(
			"taman",
			"air terjun",
			"museum",
			"pantai",
			"permandian",
			"religi",
			"danau",
			"alam",
		)
		for (i in 0..7){
			if (category.equals(listCategory[i])){
				categoryId = i + 1
			}
		}
		return TourismPlace(
			placeId = id,
			placeName = name,
			idCategory = categoryId,
			placeDescription = description,
			placePhotoUrl  = image,
			city = kota ,
			placeAddress = address,
			placeMapUrl  = detailURL,
			latitude = latitude,
			longitude = longitude,
			placeRating  = rating,
			placeTags = tags,
			placeReview = review,
			placeWebsite = website,
			placePhone = phone,
			placeDistance = null
		)
	}
}
