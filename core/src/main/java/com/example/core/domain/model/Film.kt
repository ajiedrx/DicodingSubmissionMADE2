package com.example.dicodingsubmission2made.core.injection.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    var id: Int = 0,
        var film_id: Int? = 0,
        var type: String? = "",
        var name: String? = "",
        var genre: String? = "",
        var poster: String? = "",
        var duration: String? = "",
        var rating: String? = "",
        var overview: String? = "",
        var isFavorite: Boolean? = false
) : Parcelable {
    companion object {
        const val FILM = "FILM"
        const val FILM_ID = "FILM_ID"
        const val MOVIE = "MOVIE"
        const val TV_SHOW = "TV_SHOW"
        const val FILM_TYPE = "FILM_TYPE"
    }
}