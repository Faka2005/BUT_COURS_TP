package netprime.datalayer.datamodel.users

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val first: String,
    val last: String
)