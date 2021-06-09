package com.example.dicodingsubmission2made.core.injection.data.entities.topRatedMoviesResponse

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResultsItem(

	@field:SerializedName("overview")
	val overview: String? = "",

	@field:SerializedName("original_language")
	val originalLanguage: String? = "",

	@field:SerializedName("original_title")
	val originalTitle: String? = "",

	@field:SerializedName("video")
	val video: Boolean? = false,

	@field:SerializedName("title")
	var title: String? = "",

	@field:SerializedName("genre_ids")
	val genreIds: List<Int?>? = emptyList(),

	@field:SerializedName("poster_path")
	val posterPath: String? = "",

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = "",

	@field:SerializedName("release_date")
	val releaseDate: String? = "",

	@field:SerializedName("popularity")
	val popularity: Double? = 0.toDouble(),

	@field:SerializedName("vote_average")
	val voteAverage: Double? = 0.toDouble(),

	@field:SerializedName("id")
    var id: Int? = 0,

	@field:SerializedName("adult")
	val adult: Boolean? = false,

	@field:SerializedName("vote_count")
	val voteCount: Int? = 0
) : Parcelable