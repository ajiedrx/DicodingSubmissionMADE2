package com.example.dicodingsubmission2made.core.injection.data.local

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val roomDatabase : AppDatabase) : ILocalDataSource{

    override fun getFavoriteMovies() : Flow<List<FilmEntity>> {
        return roomDatabase.getDao().getFavoriteMovies()
    }

    override fun getFavoriteTvShows() : Flow<List<FilmEntity>> {
        return roomDatabase.getDao().getFavoriteTvShows()
    }

    override fun getAllFavorite() : List<FilmEntity>{
        return roomDatabase.getDao().getAll()
    }

    override fun getFilmCount(filmId : Int) : Int{
        return roomDatabase.getDao().getFilmCount(filmId)
    }

    override fun insertFavorite(data : FilmEntity){
        roomDatabase.getDao().insert(data)
    }

    override fun getPagedFavoriteMovies() : LiveData<PagingData<FilmEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { FavoriteMoviePagingSource(roomDatabase.getDao()) }
        ).liveData
    }

    override fun getPagedFavoriteTvShow() : LiveData<PagingData<FilmEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { FavoriteTvShowPagingSource(roomDatabase.getDao()) }
        ).liveData
    }

    override fun deleteFavorite(filmId : Int){
        val res = roomDatabase.getDao().deleteByFilmId(filmId)
    }
}