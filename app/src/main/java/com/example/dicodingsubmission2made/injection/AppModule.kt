package com.example.dicodingsubmission2made.injection

import com.example.dicodingsubmission2made.core.injection.domain.usecase.FilmInteractor
import com.example.dicodingsubmission2made.core.injection.domain.usecase.FilmUseCase
import com.example.dicodingsubmission2made.presentation.detail.DetailViewModel
import com.example.dicodingsubmission2made.presentation.main.movie.MovieListViewModel
import com.example.dicodingsubmission2made.presentation.main.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<FilmUseCase> { FilmInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}