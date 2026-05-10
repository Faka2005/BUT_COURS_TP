package netprime.datalayer

import netprime.exceptions.EpisodeException
import netprime.exceptions.JsonParserException
import java.io.FileNotFoundException

interface iMediaDAO {

    /**
     * Ajoute des séries depuis le fichier JSON [ressource]
     *
     * @param ressource le chemin vers le fichier .
     * @exception FileNotFoundException si le fichier n'est pas trouvé.
     * @exception JsonParserException si le fichier ne contient pas un JSON correct.
     */
    fun addSeriesFrom(ressource: String)

    /**
     * Ajoute des films depuis le fichier JSON [ressource]
     *
     * @param ressource le chemin vers le fichier .
     * @exception FileNotFoundException si le fichier n'est pas trouvé.
     * @exception JsonParserException si le fichier ne contient pas un JSON correct.
     */
    fun addMoviesFrom(ressource: String)

    /**
     * Ajoute des episodes depuis le fichier JSON [ressource]
     *
     * @param ressource le chemin vers le fichier .
     * @exception FileNotFoundException si le fichier n'est pas trouvé.
     * @exception JsonParserException si le fichier ne contient pas un JSON correct.
     * @exception EpisodeException si l'episode référence une série qui n'est
     *     pas déjà présente.
     */
    fun addEpisodesFrom(ressource: String)


}
