package com.reev.telokkaapps.data.remote.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Parcelize
//data class QuoteResponses(
//
//	@field:SerializedName("QuoteResponses")
//	val quoteResponses: List<QuoteResponsesItem?>? = null
//) : Parcelable

@Parcelize
@Entity(tableName = "quote")
data class QuoteResponseItem(
	@PrimaryKey
	@field:SerializedName("id")
	var id: String = "0",

	@field:SerializedName("sr")
	var sr: String? = null,

	@field:SerializedName("en")
	var en: String? = null,

	@field:SerializedName("author")
	var author: String? = null,

	@field:SerializedName("rating")
	var rating: Double? = null,

) : Parcelable
