package com.example.dicodingsubmission2made.core.injection.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import com.example.dicodingsubmission2made.core.injection.domain.model.Film
import com.example.dicodingsubmission2made.core.injection.domain.repository.IFilmRepository
import kotlinx.coroutines.flow.Flow

class FilmInteractor(private val filmRepository: IFilmRepository) : FilmUseCase {
    override fun getMovieDetail(id: Int): Flow<Film> {
        return filmRepository.getMovieDetail(id)
    }

    override fun getTvShowDetail(id: Int): Flow<Film> {
        return filmRepository.getTvShowDetail(id)
    }

    override fun insertFavorite(data: Film) {
        filmRepository.insertFavorite(data)
    }

    override fun deleteFavorite(filmId: Int) {
        filmRepository.deleteFavorite(filmId)
    }

    override fun getFilmCount(filmId: Int): Int {
        return filmRepository.getFilmCount(filmId)
    }

    override fun getAllFavorite(): List<Film> {
        return filmRepository.getAllFavorite()
    }

    override fun getTopRatedMovies(): Flow<List<Film>> {
        return filmRepository.getTopRatedMovies()
    }

    override fun getTopRatedTvShows(): Flow<List<Film>> {
        return filmRepository.getTopRatedTvShows()
    }

    override fun getFavoriteMovies(): Flow<List<Film>> {
       return filmRepository.getFavoriteMovies()
    }

    override fun getFavoriteTvShows(): Flow<List<Film>> {
        return filmRepository.getFavoriteTvShows()
    }

    override fun getPagedTopRatedMovies(): LiveData<PagingData<FilmEntity>> {
        return filmRepository.getPagedTopRatedMovies()
    }

    override fun getPagedTopRatedTvShows(): LiveData<PagingData<FilmEntity>> {
        return filmRepository.getPagedTopRatedTvShows()
    }

    override fun getPagedFavoriteMovies(): LiveData<PagingData<FilmEntity>> {
        return filmRepository.getPagedFavoriteMovies()
    }

    override fun getPagedFavoriteTvShow(): LiveData<PagingData<FilmEntity>> {
        return filmRepository.getPagedFavoriteTvShow()
    }
}