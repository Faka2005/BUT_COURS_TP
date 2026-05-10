package dev.mobile.tpsae.data.repo

import dev.mobile.tpsae.data.Resource
import dev.mobile.tpsae.data.model.Movie
import dev.mobile.tpsae.data.model.Serie
import dev.mobile.tpsae.data.remote.MovieAPI
import dev.mobile.tpsae.data.remote.SerieAPI
import java.time.LocalDate

class SerieRepo (private val Api: SerieAPI){
    private var gMap : Map<Int, String>? = null

    suspend fun getPopularSeries(page: Int =1): Resource<List<Serie>>{
        val genres = getGenres()
        return when (val res = Api.getPopularSeries(page)){
            is Resource.Success -> {
                val series = res.data.map{ it ->
                    Serie(
                        id = it.id,
                        name = it.name,
                        overview = it.overview,
                        imageUrl = "https://image.tmdb.org/t/p/w500${it.poster_path ?: ""}",
                        genres = it.genre_ids.mapNotNull { id -> genres[id] },
                        rate = it.vote_average,
                        nbVote = it.vote_count,
                        popularity = it.popularity,
                        date = if (it.first_air_date.isNotBlank()) {
                            LocalDate.parse(
                                it.first_air_date
                            )
                        } else {
                            null
                        }
                    )
                }
                Resource.Success(series)
            }
            is Resource.Error -> Resource.Error(res.message)
            else -> Resource.Error("Unknown Error")
        }
    }

    suspend fun searchSeries(query: String,page: Int = 1) : Resource<List<Serie>>{
        val genres = getGenres()
        return when(val res = Api.searchSeries(query,page)) {
            is Resource.Success -> {
                val series = res.data.map { it ->
                    Serie(
                        id = it.id,
                        name = it.name,
                        overview = it.overview,
                        imageUrl = "https://image.tmdb.org/t/p/w500${it.poster_path ?: ""}",
                        genres = it.genre_ids.mapNotNull { id -> genres[id] },
                        rate = it.vote_average,
                        nbVote = it.vote_count,
                        popularity = it.popularity,
                        date = if (it.first_air_date.isNotBlank()) {
                            LocalDate.parse(
                                it.first_air_date
                            )
                        } else {
                            null
                        }

                    )
                }
                Resource.Success(series)
            }
            is Resource.Error -> Resource.Error(res.message)
            else -> Resource.Error("Unknown Error")
        }
    }
    private suspend fun getGenres() : Map<Int, String>{
        if (gMap == null || gMap == {}) {
            val res = Api.getGenresSeries()

            gMap = when (res) {
                is Resource.Success -> res.data.associate { it.id to it.name }
                is Resource.Error -> emptyMap()
                else -> emptyMap()
            }
        }
        return gMap!!
    }
}