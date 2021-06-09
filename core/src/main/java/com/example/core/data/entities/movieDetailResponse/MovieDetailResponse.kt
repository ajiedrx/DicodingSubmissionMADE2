package com.example.dicodingsubmission2made.core.injection.data.entities.movieDetailResponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDetailResponse(
    val originalLanguage: String? = null,
    val imdbId: String? = null,
    val video: Boolean? = null,
    val title: String? = null,
    val backdropPath: String? = null,
    val revenue: Int? = null,
    val genres: List<GenresItem?>? = null,
    val popularity: Double? = null,
    val productionCountries: List<ProductionCountriesItem?>? = null,
    val id: Int? = null,
    val voteCount: Int? = null,
    val budget: Int? = null,
    val overview: String? = null,
    val originalTitle: String? = null,
    val runtime: Int? = null,
    val posterPath: String? = null,
    val spokenLanguages: List<SpokenLanguagesItem?>? = null,
    val productionCompanies: List<ProductionCompaniesItem?>? = null,
    val releaseDate: String? = null,
    val voteAverage: Double? = null,
    val belongsToCollection: BelongsToCollection? = null,
    val tagline: String? = null,
    val adult: Boolean? = null,
    val homepage: String? = null,
    val status: String? = null
) : Parcelable