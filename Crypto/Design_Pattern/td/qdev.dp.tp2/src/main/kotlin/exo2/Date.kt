package exo2

/**
 * Classe très simple représentant une date
 *
 * @constructor Constructeur définissant une date
 * @property jour entier représentant le jour
 * @property mois entier représentant le mois
 * @property annee entier représentant l'annee
 */
class Date(j: Int, m: Int, a: Int) {
    var jour: Int
        private set
    var mois: Int
        private set
    var annee: Int
        private set

    init {
        jour = j
        mois = m
        annee = a
    }


    /**
     * donne une chaine de caractères correspondant à la date
     *
     * @return une chaine JJ-MM-AAAA
     */
    override fun toString(): String {
        return "$jour-$mois-$annee"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Date) return false

        if (jour != other.jour) return false
        if (mois != other.mois) return false
        if (annee != other.annee) return false

        return true
    }

    override fun hashCode(): Int {
        var result = jour
        result = 31 * result + mois
        result = 31 * result + annee
        return result
    }


    /**
     * methode qui permet de vérifier si une date est valide, cad si le jour,
     * mois et année sont cohérents : uniquement 28 jours en février, sauf les
     * années bissextiles, uniquement 30 jours en juin, etc.
     *
     * @return true si la date est valide
     */
    fun dateValide(): Boolean {
        TODO("question 6")
    }

    companion object {

        /**
         * fabrique une date valide à partir de la chaine de caractère passé en
         * paramètre
         *
         * @param str chaine representant une date dans le format JJ-MM-AAAA
         * @return la date correspondant à la chaine de caractère
         * @throws DateException si la chaine est malformée
         */
        fun fabrique(str: String): Date {
            TODO("question 7")
        }
    }
}