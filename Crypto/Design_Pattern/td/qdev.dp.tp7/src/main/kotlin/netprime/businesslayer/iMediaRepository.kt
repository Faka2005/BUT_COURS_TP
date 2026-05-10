package netprime.businesslayer

import netprime.datalayer.datamodel.medias.Media
import netprime.datalayer.datamodel.medias.MediaWithCrew
import netprime.exceptions.*

interface iMediaRepository {


    /**
     * donne le nombre total de médias enregistrés.
     *
     * @return le nombre de médias.
     */
    fun nbTotalMedias(): Int

    /**
     * donne le nombre de films enregistrés.
     *
     * @return le nombre de films
     */
    fun nbMovies(): Int

    /**
     * donne le nombre de séries enregistrées.
     *
     * @return le nombre de séries.
     */
    fun nbSeries(): Int


    /**
     * donne une liste de tous les titres des médias enregistrés, triée par
     * imDbRating, puis par titre.
     *
     * @return la liste des titres des médias.
     */
    fun listAllMedias(): List<String>

    /**
     * Indique si [id] correspond à l'id d'une série enregistrée.
     *
     * @param id l'id à rechercher.
     * @return [true] si l'id est trouvé, [false] sinon.
     */
    fun isSerieId(id: String): Boolean

    /**
     * donne tous les titres des épisodes de la série ayant comme titre exact
     * [title], triée par seasonNumber puis par episodeNumber.
     *
     * @param title le titre exact de la série à rechercher.
     * @return la liste de tous les titres des épisodes correspondant au
     *     critère.
     */
    fun episodesFrom(title: String): List<String>

    /**
     * Liste tous les médias dont le titre contient [keyword], triée par année,
     * puis par titre.
     *
     * @param keyword le mot clef à rechercher dans les titres.
     * @return la liste des médias recherchés.
     */
    fun listByTitleKeyword(keyword: String): List<Media>

    /**
     * liste tous les médias dont la [person] fait partie de l'equipe, triée
     * par titre, puis par année.
     *
     * @param person personne à rechercher
     * @return la liste de médias recherchés.
     */
    fun listByCrew(person: String): List<MediaWithCrew>

    /**
     * efface un média.
     *
     * @param media le média à effacer.
     * @exception MediaException si le media n'est pas présent.
     */
    fun delete(media: Media)

}
