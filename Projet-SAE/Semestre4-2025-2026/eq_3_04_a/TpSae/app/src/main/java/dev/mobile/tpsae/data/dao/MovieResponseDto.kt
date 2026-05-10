package dev.mobile.tpsae.data.dao

import kotlinx.serialization.Serializable


    @Serializable
    data class MovieResponseDto(
        val results: List<MovieDto>,
    )
