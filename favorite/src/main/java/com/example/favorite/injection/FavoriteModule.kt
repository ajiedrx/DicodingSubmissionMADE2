package com.example.favorite.favorite

import com.example.favorite.movie.FavoriteMovieListViewModel
import com.example.favorite.tvshow.FavoriteTvShowListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteMovieListViewModel(get()) }
    viewModel { FavoriteTvShowListViewModel(get()) }
}