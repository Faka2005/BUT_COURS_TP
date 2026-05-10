package dev.mobile.tpsae.data.model

import java.time.LocalDate

data class Serie(
    val id: Int,
    val name: String,
    val overview: String?,
    val imageUrl: String,
    val genres: List<String>,
    val rate: Float,
    val nbVote: Int,
    val popularity: Float,
    val date: LocalDate?
)