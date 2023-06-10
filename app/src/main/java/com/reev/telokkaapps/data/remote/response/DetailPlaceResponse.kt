package com.reev.telokkaapps.data.remote.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Parcelize
data class DetailPlaceResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("succes")
	val succes: Boolean? = null
) : Parcelable

@Entity(tableName = "detail_place")

@Parcelize
data class DataItem(

	@field:SerializedName("Category")
	val category: String? = null,

	@field:SerializedName("Description")
	val description: String? = null,

	@field:SerializedName("Address")
	val address: String? = null,

	@field:SerializedName("Rating")
	val rating: Double? = null,

	@field:SerializedName("Website")
	val website: String? = null,

	@field:SerializedName("Latitude")
	val latitude: Double? = null,

	@field:SerializedName("Review")
	val review: String? = null,

	@field:SerializedName("Longitude")
	val longitude: Double? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("Detail_URL")
	val detailURL: String? = null,

	@field:SerializedName("Kota")
	val kota: String? = null,

	@field:SerializedName("Phone")
	val phone: String? = null,

	@PrimaryKey
	@field:SerializedName("ID")
	val id: Int? = null,

	@field:SerializedName("Header_image")
	val headerImage: String? = null,

	@field:SerializedName("Tags")
	val tags: String? = null
) : Parcelable
