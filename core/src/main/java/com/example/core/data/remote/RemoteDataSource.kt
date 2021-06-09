package com.example.dicodingsubmission2made.core.injection.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import com.example.dicodingsubmission2made.core.injection.data.entities.movieDetailResponse.MovieDetailResponse
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedMoviesResponse.MovieResultsItem
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedTvShowResponse.TvResultsItem
import com.example.dicodingsubmission2made.core.injection.data.entities.tvShowDetailResponse.TvShowDetailResponse
import com.example.dicodingsubmission2made.core.injection.data.remote.api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(private val apiService: ApiService) : IRemoteDataSource{

    override fun getPagedTopRatedMovies() : LiveData<PagingData<FilmEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TopRatedMoviePagingSource(apiService) }
        ).liveData
    }

    override fun getPagedTopRatedTvShows(): LiveData<PagingData<FilmEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TopRatedTvShowPagingSource(apiService) }
        ).liveData
    }

    override fun getTopRatedMovies(): Flow<List<MovieResultsItem>> {
        return flow {
            try {
                val response = apiService.getTopRatedMovies()
                emit(response.results)
            } catch (e : Exception){
                Log.e("RemoteDataSource", e.toString())
            }
        }
    }

    override fun getTopRatedTvShows(): Flow<List<TvResultsItem>> {

        return flow {
            try {
                val response = apiService.getTopRatedTvShows()
                emit(response.results)
            } catch (e : Exception){
                Log.e("RemoteDataSource", e.toString())
            }
        }
    }

    override fun getMovieDetail(id: Int): Flow<MovieDetailResponse> {
        return flow {
            try {
                val response = apiService.getMovieDetail(id)
                emit(response)
            } catch (e : Exception){
                Log.e("RemoteDataSource", e.toString())
            }
        }
    }

    override fun getTvShowDetail(id : Int): Flow<TvShowDetailResponse> {
        return flow {
            try {
                val response = apiService.getTvShowDetail(id)
                emit(response)
            } catch (e : Exception){
                Log.e("RemoteDataSource", e.toString())
            }
        }
    }
}