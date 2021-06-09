package com.example.dicodingsubmission2made.core.injection.data.local

import androidx.room.*
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteFilmDao {
    @Query("SELECT * from favfilms")
    fun getAll(): List<FilmEntity>

    @Query("SELECT * FROM favfilms WHERE type = 'MOVIE'")
    fun getFavoriteMovies() : Flow<List<FilmEntity>>

    @Query("SELECT * FROM favfilms WHERE type = 'TV_SHOW'")
    fun getFavoriteTvShows() : Flow<List<FilmEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(film: FilmEntity) : Long

    @Update
    fun update(data: FilmEntity) : Int

    @Query("SELECT * FROM favfilms WHERE type = 'MOVIE' LIMIT :size OFFSET (:pageNumber-1)*:size")
    fun getPagedFavoriteMovies(size: Int, pageNumber : Int): List<FilmEntity>

    @Query("SELECT * FROM favfilms WHERE type = 'TV_SHOW' LIMIT :size OFFSET (:pageNumber-1)*:size")
    fun getPagedFavoriteTvShow(size: Int, pageNumber : Int): List<FilmEntity>

    @Delete
    fun delete(data: FilmEntity)

    @Query("DELETE FROM favfilms")
    fun nukeTable()

    @Query("SELECT COUNT(film_id) FROM favfilms WHERE film_id = :filmId")
    fun getFilmCount(filmId: Int) : Int

    @Query("DELETE FROM favfilms WHERE film_id = :filmId")
    fun deleteByFilmId(filmId : Int) : Int
}
