package com.reev.telokkaapps.data.remote.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Parcelize
data class ListPlaceResponse(

	@field:SerializedName("data")
	val data: List<ListPlaceItem>,

	@field:SerializedName("success")
	val success: Boolean?
) : Parcelable

@Entity(tableName = "list_place")
@Parcelize
data class ListPlaceItem(

	@field:SerializedName("Category")
	val category: String? = null,

	@field:SerializedName("ID")
	val id: Int? = null,

	@field:SerializedName("Header_image")
	val headerImage: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("Rating")
	val rating: Double? = null,

) : Parcelable
