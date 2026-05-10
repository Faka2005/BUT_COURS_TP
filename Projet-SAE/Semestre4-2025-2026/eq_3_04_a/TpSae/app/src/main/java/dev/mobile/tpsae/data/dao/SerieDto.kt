package dev.mobile.tpsae.data.dao

import kotlinx.serialization.Serializable

@Serializable
data class SerieDto(
    val backdrop_path: String? = null,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String? = "",
    val popularity: Float,
    val poster_path : String? = null,
    val vote_average: Float,
    val vote_count: Int
)