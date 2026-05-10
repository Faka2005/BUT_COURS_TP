package dev.mobile.tpsae.data.dao

import kotlinx.serialization.Serializable

@Serializable
data class GenreResponseDto(
    val genres: List<GenreDto>
)