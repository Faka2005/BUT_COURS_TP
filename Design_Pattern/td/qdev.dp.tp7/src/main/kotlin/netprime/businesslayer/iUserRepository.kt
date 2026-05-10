package netprime.businesslayer

import netprime.datalayer.datamodel.users.*
import netprime.exceptions.*

interface iUserRepository {


    /**
     * donne le nombre d'utilisateurs actuellement enregistrés.
     *
     * @return le nombre d'utilisateurs.
     */
    fun nbUsers(): Int

    /**
     * donne la liste des utilisateurs ayant comme nationalité [nat], triée par
     * ordre alphabétique des emails.
     *
     * @param nat la nationalité des utilisateurs.
     * @return une liste d'utilisateurs.
     */
    fun listByNat(nat: NAT): List<User>

    /**
     * indique si un utilisateur considéré est présent ou non.
     *
     * @param user l'utilisateur considéré.
     * @return [true] si l'utilisateur indiqué est présent, [false] sinon.
     */
    fun contains(user: User): Boolean

    /**
     * indique si un utilisateur ayant comme nom de famille [lastname] est
     * présent ou non.
     *
     * @param lastname le nom de famille à considérer.
     * @return [true] si un utilisateur ayant comme nom de famille [lastname]
     *     est présent, [false] sinon.
     */
    fun containsByLastname(lastname: String): Boolean


    /**
     * efface l'utilisateur ayant comme email [[email].
     *
     * @param email l'email de l'utilisateur à effacer.
     * @exception UserException si l'utilisateur ne peut pas être effacé.
     */
    fun deleteByEmail(email: String)

    /**
     * donne la liste de noms d'utilisateurs ayant [gender] comme GENRE, triée
     * par ordre alphabétique des noms de familles.
     *
     * @param gender le genre à considérer.
     * @return une liste de noms d'utilisateurs.
     */
    fun listByGender(gender: GENDER): List<Name>

    /**
     * donne la liste de logins d'utilisateurs ayant [firstname] comme prénoms.
     * triée par ordre alphabétique des noms de familles.
     *
     * @param firstname le prénom à considérer.
     * @return une liste des logins d'utilisateurs.
     */
    fun listByFirstname(firstname: String): List<Login>


    /**
     * Donne le couple login/mot de passe de l'utilisateur nommé [name].
     *
     * @param name le nom à considérer.
     * @return le couple login/mot de passe de l'utilisateur.
     * @exception UserException si l'utilisateur n'est pas trouvé.
     */
    fun giveLogin(name: Name): Pair<String, String>

}
