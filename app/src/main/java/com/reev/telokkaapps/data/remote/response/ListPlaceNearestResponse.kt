package com.reev.telokkaapps.data.remote.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Parcelize
data class ListPlaceNearestResponse(

	@field:SerializedName("data")
	val data: List<ListPlaceNearestItem>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
) : Parcelable

@Entity(tableName = "list_place_nearest")
@Parcelize
data class ListPlaceNearestItem(

	@field:SerializedName("Category")
	val category: String? = null,

	@field:SerializedName("ID")
	val id: Int? = null,

	@field:SerializedName("Header_image")
	val headerImage: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("jarak")
	val span: String? = null,
) : Parcelable
