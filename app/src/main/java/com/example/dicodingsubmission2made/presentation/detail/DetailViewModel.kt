package com.example.dicodingsubmission2made.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import com.example.dicodingsubmission2made.core.injection.domain.model.Film
import com.example.dicodingsubmission2made.core.injection.domain.usecase.FilmUseCase

class DetailViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {
    fun getFilmDetail(data: Film) : LiveData<Film> {
        return if(data.type == FilmEntity.MOVIE){
            filmUseCase.getMovieDetail(data.film_id!!).asLiveData()
        }
        else{
            filmUseCase.getTvShowDetail(data.film_id!!).asLiveData()
        }
    }

    fun addFavoriteFilm(data: Film){
        val allFavorites = filmUseCase.getAllFavorite()
        if (!isDuplicate(allFavorites, data)) {
            filmUseCase.insertFavorite(data)
        }
    }

    fun removeFavoriteFilm(data: Film){
        Log.d("DELETE FAV VIEWMOD", data.film_id.toString())
        filmUseCase.deleteFavorite(data.film_id!!)
    }

    fun isFavorite(filmId : Int) : Boolean {
        return filmUseCase.getFilmCount(filmId) != 0
    }

    private fun isDuplicate(list : List<Film>, obj : Film):Boolean{
        list.forEach { film: Film ->
            if(film.film_id == obj.film_id){
                return true
            }
        }
        return false
    }
}