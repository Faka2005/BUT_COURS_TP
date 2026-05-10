package dev.mobile.tpsae.data.dao

import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val id: Int,
    val title: String,
    val adult: Boolean,
    val backdrop_path: String? = null,
    val genre_ids: List<Int>,
    val original_language: String,
    val original_title: String,
    val overview: String? = "",
    val popularity: Float,
    val poster_path: String? = null,
    val release_date: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int
)