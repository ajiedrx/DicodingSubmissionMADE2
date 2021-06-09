package com.example.dicodingsubmission2made.core.injection.data.entities.topRatedTvShowResponse

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopRatedTvResponse(

    @field:SerializedName("page")
	val page: Int? = 0,

    @field:SerializedName("total_pages")
	val totalPages: Int? = 0,

    @field:SerializedName("results")
	val results: List<TvResultsItem> = emptyList(),

    @field:SerializedName("total_results")
	val totalResults: Int? = 0
) : Parcelable