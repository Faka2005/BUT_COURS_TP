package netprime.datalayer.datamodel.medias

import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    val serieId: String,
    override val title: String,
    override val year: Int,
    override val imDbRating: Double,
    val seasonNumber: Int,
    val episodeNumber: Int
) : Media() {
}