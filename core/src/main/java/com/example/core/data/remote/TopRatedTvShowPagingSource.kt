package com.example.dicodingsubmission2made.core.injection.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedTvShowResponse.TvResultsItem
import com.example.dicodingsubmission2made.core.injection.data.remote.api.ApiService

class TopRatedTvShowPagingSource (private val apiService: ApiService) :
    PagingSource<Int, FilmEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmEntity> {
        val position = params.key ?: 1
        var nextKey : Int? = null
        val movie = apiService.getPagedTopRatedTvShow(position).body()?.results!!

        val domainItems = movie.map { tvResultsItem: TvResultsItem ->
            FilmEntity(
                film_id = tvResultsItem.id,
                name = tvResultsItem.name,
                poster = tvResultsItem.posterPath,
                rating = tvResultsItem.voteAverage.toString(),
                type = FilmEntity.TV_SHOW
            )
        }
        nextKey = if (domainItems.isEmpty()) {
            null
        } else {
            position + 1
        }
        return LoadResult.Page(data = domainItems ,prevKey = if (position == 1) null else position - 1, nextKey = nextKey)
    }

    override fun getRefreshKey(state: PagingState<Int, FilmEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}