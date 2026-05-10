package netprime.datalayer.datamodel.medias

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Serie(
    val id: String,
    override val title: String,
    override val year: Int,
    override val crew: String,
    override val imDbRating: Double,
    @Transient val episodes: MutableList<Episode> = mutableListOf()
) : MediaWithCrew() {

}