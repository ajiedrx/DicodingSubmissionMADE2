package com.example.dicodingsubmission2made.core.injection.data.local

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {
    fun getAllFavorite() : List<FilmEntity>

    fun getFilmCount(filmId : Int) : Int

    fun insertFavorite(data : FilmEntity)

    fun getFavoriteMovies() : Flow<List<FilmEntity>>

    fun getFavoriteTvShows() : Flow<List<FilmEntity>>

    fun getPagedFavoriteMovies() : LiveData<PagingData<FilmEntity>>

    fun getPagedFavoriteTvShow() : LiveData<PagingData<FilmEntity>>

    fun deleteFavorite(filmId : Int)
}