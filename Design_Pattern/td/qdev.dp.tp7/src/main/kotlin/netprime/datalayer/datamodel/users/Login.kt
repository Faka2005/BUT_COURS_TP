package netprime.datalayer.datamodel.users

import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val username: String,
    val password: String
)