package dev.mobile.tpsae.data.dao

import kotlinx.serialization.Serializable

@Serializable
data class SerieResponseDto(
    val results: List<SerieDto>
)