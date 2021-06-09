package com.example.dicodingsubmission2made.core.injection.data

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import com.example.dicodingsubmission2made.core.injection.data.local.LocalDataSource
import com.example.dicodingsubmission2made.core.injection.data.remote.RemoteDataSource
import com.example.dicodingsubmission2made.core.injection.domain.model.Film
import com.example.dicodingsubmission2made.core.injection.domain.repository.IFilmRepository
import com.example.dicodingsubmission2made.core.injection.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FilmRepository(private val remoteDataSource : RemoteDataSource
, private val localDataSource: LocalDataSource
) : IFilmRepository
{

    override fun getPagedTopRatedMovies() : LiveData<PagingData<FilmEntity>> {
        return remoteDataSource.getPagedTopRatedMovies()
    }

    override fun getPagedTopRatedTvShows() : LiveData<PagingData<FilmEntity>> {
        return remoteDataSource.getPagedTopRatedTvShows()
    }

    override fun getPagedFavoriteMovies(): LiveData<PagingData<FilmEntity>> {
        return localDataSource.getPagedFavoriteMovies()
    }

    override fun getPagedFavoriteTvShow(): LiveData<PagingData<FilmEntity>> {
        return localDataSource.getPagedFavoriteTvShow()
    }

    override fun getFavoriteMovies(): Flow<List<Film>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapListEntitiesToDomain(it)
        }
    }

    override fun getFavoriteTvShows(): Flow<List<Film>> {
        return localDataSource.getFavoriteTvShows().map {
            DataMapper.mapListEntitiesToDomain(it)
        }
    }

    override fun getMovieDetail(id: Int): Flow<Film> {
        return remoteDataSource.getMovieDetail(id).map {
            DataMapper.mapMovieDetailResponseToDomain(it)
        }
    }

    override fun getTvShowDetail(id: Int): Flow<Film> {
        return remoteDataSource.getTvShowDetail(id).map {
             DataMapper.mapTvShowDetailResponseToDomain(it)
        }
    }

    override fun getTopRatedMovies() : Flow<List<Film>> {
        return remoteDataSource.getTopRatedMovies().map {
            DataMapper.mapListEntitiesToDomain(DataMapper.mapMovieListResponsesToEntities(it))
        }
    }

    override fun getTopRatedTvShows(): Flow<List<Film>> {
        return remoteDataSource.getTopRatedTvShows().map {
            DataMapper.mapListEntitiesToDomain(DataMapper.mapTvShowListResponsesToEntities(it))
        }
    }

    override fun insertFavorite(data: Film) {
        localDataSource.insertFavorite(DataMapper.mapDomainToEntity(data))
    }

    override fun deleteFavorite(filmId : Int) {
        localDataSource.deleteFavorite(filmId)
    }

    override fun getFilmCount(filmId: Int): Int {
        return localDataSource.getFilmCount(filmId)
    }

    override fun getAllFavorite(): List<Film> {
        return DataMapper.mapListEntitiesToDomain(localDataSource.getAllFavorite())
    }
}