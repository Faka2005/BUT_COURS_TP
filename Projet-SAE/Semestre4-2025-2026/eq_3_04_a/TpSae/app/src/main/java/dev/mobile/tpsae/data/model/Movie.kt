package dev.mobile.tpsae.data.model

import java.time.LocalDate

data class Movie(
    val id: Int,
    val title: String,
    val overview: String?,
    val imageUrl: String,
    val genres: List<String>,
    val rate: Float,
    val nbVote: Int,
    val popularity: Float,
    val date: LocalDate?
)