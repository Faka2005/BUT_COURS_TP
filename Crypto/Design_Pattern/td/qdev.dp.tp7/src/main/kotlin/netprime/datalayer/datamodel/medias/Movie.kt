package netprime.datalayer.datamodel.medias

import kotlinx.serialization.Serializable


@Serializable
data class Movie(
    override var title: String,
    override var year: Int,
    override var crew: String,
    override var imDbRating: Double
) : MediaWithCrew() {
}

