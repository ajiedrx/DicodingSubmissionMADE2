package com.example.dicodingsubmission2made.core.injection.data.entities.topRatedTvShowResponse

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResultsItem(

	@field:SerializedName("first_air_date")
	val firstAirDate: String? = "",

	@field:SerializedName("overview")
	val overview: String? = "",

	@field:SerializedName("original_language")
	val originalLanguage: String? = "",

	@field:SerializedName("genre_ids")
	val genreIds: List<Int?>? = emptyList(),

	@field:SerializedName("poster_path")
	val posterPath: String? = "",

	@field:SerializedName("origin_country")
	val originCountry: List<String?>? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = "",

	@field:SerializedName("original_name")
	val originalName: String? = "",

	@field:SerializedName("popularity")
	val popularity: Double? = 0.toDouble(),

	@field:SerializedName("vote_average")
	val voteAverage: Double? = 0.toDouble(),

	@field:SerializedName("name")
	var name: String? = "",

	@field:SerializedName("id")
    var id: Int? = 0,

	@field:SerializedName("vote_count")
	val voteCount: Int? = 0
) : Parcelable