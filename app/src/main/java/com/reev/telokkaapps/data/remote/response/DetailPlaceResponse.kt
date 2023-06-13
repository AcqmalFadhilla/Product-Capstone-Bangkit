package com.reev.telokkaapps.data.remote.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Parcelize
data class DetailPlaceResponse(

	@field:SerializedName("data")
	val data: List<DetailTourismPlace>,

	@field:SerializedName("succes")
	val succes: Boolean
) : Parcelable

@Entity(tableName = "detail_place")

@Parcelize
data class DetailTourismPlace(

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
) : Parcelable
