package exo2

/* NE PAS MODIFIER CETTE CLASSE */

/**
 * Interface définissant les opérations possibles sur un spatioport.
 */
interface UsageSpatioport {

    /**
     * Retourne le nombre total de places dans le spatioport.
     */
    fun nbPlacesTotales(): Int

    /**
     * Retourne le nombre de places libres dans le spatioport.
     */
    fun nbPlacesLibres(): Int


    /**
     * Rend une place inutilisable dans le spatioport.
     * @param place L'index de la place à rendre indisponible.
     * @throws PlaceInexistanteException Si la place n'existe pas.
     * @throws PlaceOccupeeException Si la place est déjà occupée par un vaisseau.
     * @throws PlaceInutilisableException Si la place est déjà inutilisable.
     */
    fun emplacementInutilisable(place: Int)

    /**
     * Répare une place inutilisable dans le spatioport, la rendant à nouveau libre.
     * @param place L'index de la place à réparer.
     * @throws PlaceInexistanteException Si la place n'existe pas.
     * @throws PlaceOccupeeException Si la place est occupée par un vaisseau.
     * @throws PlaceLibreException Si la place est déjà libre.
     */
    fun reparerEmplacement(place: Int)


    /**
     * Retourne le nombre de places inutilisables dans le spatioport.
     */
    fun nbPlacesInutilisables(): Int

    /**
     * indique si un vaisseau est amarré dans le spatioport.
     * @param vaisseau Le vaisseau à vérifier.
     * @return le numero de la place où le vaisseau est amarré, ou -1 s'il n'est pas amarré.
     */
    fun estAmarreA(vaisseau: Vaisseau): Int

    /**
     * Amarre un vaisseau dans le spatioport à la première place libre disponible (dans l'ordre des places).
     * @param vaisseau Le vaisseau à amarrer.
     * @throws SpatioportPleinException Si le spatioport est plein.
     * @throws VaisseauDejaAmarreException Si le vaisseau est déjà amarré dans le spatioport.
     */
    fun amarrer(vaisseau: Vaisseau)

    /**
     * Retourne le nombre de places occupées par des vaisseaux dans le spatioport.
     */
    fun nbPlacesOccupees(): Int

    /**
     * Retourne le tonnage total des vaisseaux amarrés dans le spatioport.
     */
    fun tonnagesTotalAmarres(): Int

    /**
     * Désamarre un vaisseau du spatioport.
     * @param vaisseau Le vaisseau à désamarer.
     * @throws VaisseauNonAmarreException Si le vaisseau n'est pas amarré dans le spatioport.
     */
    fun desamarrer(vaisseau: Vaisseau)


    /**
     * Amarre un vaisseau à une place spécifique dans le spatioport.
     * @param vaisseau Le vaisseau à amarrer.
     * @param place L'index de la place où amarrer le vaisseau.
     * @throws PlaceInexistanteException Si la place n'existe pas.
     * @throws PlaceInutilisableException Si la place est inutilisable.
     * @throws PlaceOccupeeException Si la place est déjà occupée par un autre vaisseau.
     * @throws VaisseauDejaAmarreException Si le vaisseau est déjà amarré dans le spatioport.
     */
    fun amarrerA(vaisseau: Vaisseau, place: Int)

    /**
     * Désamarre le vaisseau amarré à une place spécifique dans le spatioport.
     * @param place L'index de la place d'où désamarrer le vaisseau.
     * @return Le vaisseau désamarré.
     * @throws PlaceInexistanteException Si la place n'existe pas.
     * @throws PlaceLibreException Si aucun vaisseau n'est amarré à cette place.
     * @throws PlaceInutilisableException Si la place est inutilisable.
     */
    fun desamarrerDe(place: Int): Vaisseau

    /**
     * Amarre un vaisseau à la place libre la plus proche (avant ou après (avec priorité après)) de la place demandée.
     * @param vaisseau Le vaisseau à amarrer.
     * @param place L'index de la place de référence.
     * @throws SpatioportPleinException Si le spatioport est plein.
     * @throws VaisseauDejaAmarreException Si le vaisseau est déjà amarré dans le spatioport.
     * @throws PlaceInexistanteException Si la place de référence n'existe pas.
     */
    fun amarrerAuPlusPresDe(vaisseau: Vaisseau, place: Int)

    /**
     * Retourne une liste des vaisseaux amarrés dans le spatioport, triés par nom alphabétiquement.
     * @return Liste des vaisseaux triés par nom alphabétiquement.
     */
    fun vaisseauxTriesParNom(): List<Vaisseau>


    /**
     * Retourne une liste des vaisseaux amarrés dans le spatioport, triés par tonnage décroissant.
     * @return Liste des vaisseaux triés par tonnage décroissant, puis par nom.
     */
    fun vaisseauxTriesParTonnageDecroissantPuisNom(): List<Vaisseau>


}