package com.example.dicodingsubmission2made.presentation.main.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dicodingsubmission2made.core.injection.domain.model.Film
import com.example.dicodingsubmission2made.core.injection.domain.usecase.FilmUseCase

class MovieListViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {
    fun getTopRatedMovies() : LiveData<ArrayList<Film>> = filmUseCase.getTopRatedMovies().asLiveData() as LiveData<ArrayList<Film>>
}