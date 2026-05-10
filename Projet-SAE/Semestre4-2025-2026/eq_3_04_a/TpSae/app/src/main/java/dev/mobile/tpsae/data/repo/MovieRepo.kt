package dev.mobile.tpsae.data.repo

import dev.mobile.tpsae.data.Resource
import dev.mobile.tpsae.data.model.Movie
import dev.mobile.tpsae.data.remote.MovieAPI
import java.time.LocalDate

class MovieRepo (private val Api: MovieAPI){
    private var gMap : Map<Int, String>? = null

    suspend fun getPopularMovies(page: Int = 1): Resource<List<Movie>>{
        val genres = getGenres()
        return when (val res = Api.getPopularMovies(page)){
            is Resource.Success -> {
                val movies = res.data.map{ it ->
                    Movie(
                        id = it.id,
                        title = it.title,
                        overview = it.overview,
                        imageUrl = "https://image.tmdb.org/t/p/w500${it.poster_path ?: ""}",
                        genres = it.genre_ids.mapNotNull { id -> genres[id] },
                        rate = it.vote_average,
                        nbVote = it.vote_count,
                        popularity = it.popularity,
                        date = if (it.release_date.isNotBlank()) {
                            LocalDate.parse(
                                it.release_date
                            )
                        } else {
                            null
                        }

                    )
                }
                Resource.Success(movies)
            }
            is Resource.Error -> Resource.Error(res.message)
            else -> Resource.Error("Unknown Error")
        }
    }

    suspend fun searchMovies(query: String, page: Int = 1) : Resource<List<Movie>>{
        val genres = getGenres()
        return when(val res = Api.searchMovies(query, page)) {
            is Resource.Success -> {
                val movies = res.data.map { it ->
                    Movie(
                        id = it.id,
                        title = it.title,
                        overview = it.overview,
                        imageUrl = "https://image.tmdb.org/t/p/w500${it.poster_path ?: ""}",
                        genres = it.genre_ids.mapNotNull { id -> genres[id] },
                        rate = it.vote_average,
                        nbVote = it.vote_count,
                        popularity = it.popularity,
                        date = if (it.release_date.isNotBlank()) {
                            LocalDate.parse(
                                it.release_date
                            )
                        } else {
                            null
                        }

                    )
                }
                Resource.Success(movies)
            }
            is Resource.Error -> Resource.Error(res.message)
            else -> Resource.Error("Unknown Error")
        }
    }
    private suspend fun getGenres() : Map<Int, String>{
        if (gMap == null || gMap == {}) {
            val res = Api.getGenres()

            gMap = when (res) {
                is Resource.Success -> res.data.associate { it.id to it.name }
                is Resource.Error -> emptyMap()
                else -> emptyMap()
            }
        }
        return gMap!!
    }
}