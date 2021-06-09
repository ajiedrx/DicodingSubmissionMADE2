package com.example.dicodingsubmission2made.core.injection.data.local

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity

class FavoriteMoviePagingSource(private val favoriteFilmDao: FavoriteFilmDao) : PagingSource<Int, FilmEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmEntity> {
        val position = params.key ?: 1
        var nextKey : Int? = null

        val movies = favoriteFilmDao.getPagedFavoriteMovies(params.loadSize, position)

        nextKey = if (movies.isEmpty()) {
            null
        } else {
            position + 1
        }
        return LoadResult.Page(
            data = movies,
            prevKey = if (position == 1) null else position - 1,
            nextKey = nextKey
        )
    }

    override fun getRefreshKey(state: PagingState<Int, FilmEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}