package com.example.dicodingsubmission2made.core.injection.utils

import com.example.dicodingsubmission2made.core.injection.data.entities.FilmEntity
import com.example.dicodingsubmission2made.core.injection.data.entities.movieDetailResponse.GenresItem
import com.example.dicodingsubmission2made.core.injection.data.entities.movieDetailResponse.MovieDetailResponse
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedMoviesResponse.MovieResultsItem
import com.example.dicodingsubmission2made.core.injection.data.entities.topRatedTvShowResponse.TvResultsItem
import com.example.dicodingsubmission2made.core.injection.data.entities.tvShowDetailResponse.TvShowDetailResponse
import com.example.dicodingsubmission2made.core.injection.domain.model.Film


object DataMapper {
    fun mapMovieListResponsesToEntities(input: List<MovieResultsItem>): List<FilmEntity> {
        val filmList = ArrayList<FilmEntity>()
        input.map {
                val film = FilmEntity(
                    film_id = it.id,
                    name = it.title,
                    rating = it.voteAverage.toString(),
                    poster = it.posterPath,
                    type = FilmEntity.MOVIE,
                )
                filmList.add(film)
            }
        return filmList
    }

    fun mapTvShowListResponsesToEntities(input: List<TvResultsItem>): List<FilmEntity> {
        val filmList = ArrayList<FilmEntity>()
        input.map {
            val film = FilmEntity(
                film_id = it.id,
                name = it.name,
                rating = it.voteAverage.toString(),
                poster = it.posterPath,
                type = FilmEntity.TV_SHOW
            )
            filmList.add(film)
        }
        return filmList
    }

    private fun concatStringGenres(items : List<GenresItem?>) : String{
        var str = ""
        items.forEach {
            str = str.plus(it?.name + ", ")
        }
        str = str.dropLast(2)
        return str
    }

    private fun convertMinuteToMHString(minutes : Int) : String{
        var hour = 0
        var mins = minutes
        return if(minutes > 60){
            while(mins - 60 > 0){
                hour += 1
                mins -= 60
            }
            hour.toString().plus("h").plus(" $mins").plus("m")
        }else{
            mins.toString().plus("m")
        }
    }

    fun mapMovieDetailResponseToEntity(input: MovieDetailResponse): FilmEntity {
        return FilmEntity(
                film_id = input.id,
                name = input.title,
                rating = input.voteAverage.toString(),
                poster = input.posterPath,
                duration = convertMinuteToMHString(input.runtime ?: 0),
                genre = concatStringGenres(input.genres ?: emptyList()),
                overview = input.overview,
                type = FilmEntity.MOVIE
            )
    }

    fun mapMovieDetailResponseToDomain(input: MovieDetailResponse): Film {
        return Film(
            film_id = input.id,
            name = input.title,
            rating = input.voteAverage.toString(),
            poster = input.posterPath,
            duration = convertMinuteToMHString(input.runtime ?: 0),
            genre = concatStringGenres(input.genres ?: emptyList()),
            overview = input.overview,
            type = FilmEntity.MOVIE
        )
    }

    fun mapTvShowDetailResponseToDomain(input: TvShowDetailResponse): Film {
        return Film(
            film_id = input.id,
            name = input.name,
            rating = input.voteAverage.toString(),
            poster = input.posterPath,
            duration = convertMinuteToMHString(input.episodeRunTime?.get(0) ?: 0),
            genre = concatStringGenres(input.genres ?: emptyList()),
            overview = input.overview,
            type = FilmEntity.TV_SHOW
        )
    }

    fun mapTvShowDetailResponseToEntity(input: TvShowDetailResponse): FilmEntity {
        return FilmEntity(
            film_id = input.id,
            name = input.name,
            rating = input.voteAverage.toString(),
            poster = input.posterPath,
            duration = convertMinuteToMHString(input.episodeRunTime?.get(0) ?: 0),
            genre = concatStringGenres(input.genres ?: emptyList()),
            overview = input.overview,
            type = FilmEntity.TV_SHOW
        )
    }

    fun mapEntityToDomain(input: FilmEntity): Film {
        return Film(
            film_id = input.film_id,
            name = input.name,
            rating = input.rating,
            poster = input.poster,
            genre = input.genre,
            duration = input.duration,
            overview = input.overview,
            type = input.type
        )
    }

    fun mapDomainToEntity(input: Film): FilmEntity {
        return FilmEntity(
            film_id = input.film_id,
            name = input.name,
            rating = input.rating,
            poster = input.poster,
            genre = input.genre,
            duration = input.duration,
            overview = input.overview,
            type = input.type
        )
    }

    fun mapListEntitiesToDomain(input: List<FilmEntity>): List<Film> {
        val filmList = ArrayList<Film>()
        input.map {
            val film = Film(
                film_id = it.film_id,
                name = it.name,
                rating = it.rating,
                poster = it.poster,
                genre = it.genre,
                duration = it.duration,
                overview = it.overview,
                type = it.type
            )
            filmList.add(film)
        }
        return filmList
    }


    fun mapListDomainToEntities(input: List<Film>): List<FilmEntity> {
        val filmList = ArrayList<FilmEntity>()
        input.map {
            val film = FilmEntity(
                film_id = it.film_id,
                name = it.name,
                rating = it.rating,
                poster = it.poster,
                genre = it.genre,
                duration = it.duration,
                overview = it.overview,
                type = it.type
            )
            filmList.add(film)
        }
        return filmList
    }
}