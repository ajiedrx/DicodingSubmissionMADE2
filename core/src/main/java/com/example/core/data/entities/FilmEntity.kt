package com.example.dicodingsubmission2made.core.injection.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "favfilms")
data class FilmEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "film_id")
        var film_id: Int? = 0,
    @ColumnInfo(name = "type")
        var type: String? = "",
    @ColumnInfo(name = "name")
        var name: String? = "",
    @ColumnInfo(name = "genre")
        var genre: String? = "",
    @ColumnInfo(name = "poster")
        var poster: String? = "",
    @ColumnInfo(name = "duration")
        var duration: String? = "",
    @ColumnInfo(name = "rating")
        var rating: String? = "",
    @ColumnInfo(name = "overview")
        var overview: String? = "",
    @ColumnInfo(name = "isfavorite")
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