package com.example.dicodingsubmission2made.core.injection.data.remote.api

import com.example.dicodingsubmission2made.core.injection.data.entities.movieDetailResponse.MovieDetailResponse
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedMoviesResponse.TopRatedMoviesResponse
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedTvShowResponse.TopRatedTvResponse
import com.example.dicodingsubmission2made.core.injection.data.entities.tvShowDetailResponse.TvShowDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("/3/movie/top_rated")
    suspend fun getPagedTopRatedMovies(@Query("page") page : Int,
                               @Query("api_key") appKey: String = "6b8bad826a2e96cd4cf127c65117b4e4"
    ): Response<TopRatedMoviesResponse>

    @GET("/3/tv/top_rated")
    suspend fun getPagedTopRatedTvShow(@Query("page") page : Int,
                               @Query("api_key") appKey: String = "6b8bad826a2e96cd4cf127c65117b4e4"
    ): Response<TopRatedTvResponse>

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") appKey : String = "6b8bad826a2e96cd4cf127c65117b4e4"
    ): TopRatedMoviesResponse

    @GET("/3/tv/top_rated")
    suspend fun getTopRatedTvShows(
        @Query("api_key") appKey : String = "6b8bad826a2e96cd4cf127c65117b4e4"
    ): TopRatedTvResponse

    @GET("/3/tv/{id}?api_key=6b8bad826a2e96cd4cf127c65117b4e4")
    suspend fun getTvShowDetail(
            @Path("id") id : Int
    ): TvShowDetailResponse

    @GET("/3/movie/{id}?api_key=6b8bad826a2e96cd4cf127c65117b4e4")
    suspend fun getMovieDetail(
            @Path("id") id : Int
    ): MovieDetailResponse
}