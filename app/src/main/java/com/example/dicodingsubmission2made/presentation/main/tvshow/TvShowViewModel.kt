package com.example.dicodingsubmission2made.presentation.main.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dicodingsubmission2made.core.injection.domain.model.Film
import com.example.dicodingsubmission2made.core.injection.domain.usecase.FilmUseCase

class TvShowViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {
    fun getTopRatedTvShow() : LiveData<ArrayList<Film>> = filmUseCase.getTopRatedTvShows().asLiveData() as LiveData<ArrayList<Film>>
}