package com.example.dicodingsubmission2made.core.injection.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import com.example.dicodingsubmission2made.core.injection.data.entities.movieDetailResponse.MovieDetailResponse
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedMoviesResponse.MovieResultsItem
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedTvShowResponse.TvResultsItem
import com.example.dicodingsubmission2made.core.injection.data.entities.tvShowDetailResponse.TvShowDetailResponse
import kotlinx.coroutines.flow.Flow


interface IRemoteDataSource {
    fun getPagedTopRatedMovies() : LiveData<PagingData<FilmEntity>>

    fun getPagedTopRatedTvShows(): LiveData<PagingData<FilmEntity>>

    fun getTopRatedMovies() : Flow<List<MovieResultsItem>>

    fun getTopRatedTvShows() : Flow<List<TvResultsItem>>

    fun getMovieDetail(id: Int) : Flow<MovieDetailResponse>

    fun getTvShowDetail(id : Int) : Flow<TvShowDetailResponse>
}