package netprime.datalayer.datamodel.users

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val gender: GENDER,
    val name: Name,
    val email: String,
    val login: Login,
    val nat: NAT
)