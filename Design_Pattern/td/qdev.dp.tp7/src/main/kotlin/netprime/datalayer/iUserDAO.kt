package netprime.datalayer

import netprime.exceptions.JsonParserException
import netprime.exceptions.UserException
import java.io.FileNotFoundException

interface iUserDAO {

    /**
     * Ajout depuis le fichier JSON [ressource] les utilisateurs donnés.
     *
     * @param ressource le chemin ver un fichier .json contenant des
     *     utilisateurs.
     * @exception FileNotFoundException si le fichier n'est pas trouvé.
     * @exception JsonParserException si le fichier ne contient pas un JSON correctement formaté.
     * @exception UserException si l'utilisateur est en doublon.
     */
    fun addFrom(ressource: String)


}
