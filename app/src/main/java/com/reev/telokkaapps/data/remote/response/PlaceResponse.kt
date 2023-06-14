package com.reev.telokkaapps.data.remote.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.reev.telokkaapps.data.local.database.entity.TourismPlace

@Parcelize
data class PlaceResponse(

	@field:SerializedName("data")
	val data: List<TourismPlaceResponse>,

	@field:SerializedName("succes")
	val succes: Boolean
) : Parcelable

@Entity(tableName = "detail_place")

@Parcelize
data class TourismPlaceResponse(

	@field:SerializedName("Category")
	val category: String,

	@field:SerializedName("Description")
	val description: String,

	@field:SerializedName("Address")
	val address: String,

	@field:SerializedName("Rating")
	val rating: Double,

	@field:SerializedName("Website")
	val website: String,

	@field:SerializedName("Latitude")
	val latitude: Double,

	@field:SerializedName("Review")
	val review: String,

	@field:SerializedName("Longitude")
	val longitude: Double,

	@field:SerializedName("Name")
	val name: String,

	@field:SerializedName("Detail_URL")
	val detailURL: String,

	@field:SerializedName("Kota")
	val kota: String,

	@field:SerializedName("Phone")
	val phone: String,

	@PrimaryKey
	@field:SerializedName("ID")
	val id: Int,

	@field:SerializedName("Header_image")
	val headerImage: String,

	@field:SerializedName("Tags")
	val tags: String
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
			placePhotoUrl  = headerImage,
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
		)
	}
}
