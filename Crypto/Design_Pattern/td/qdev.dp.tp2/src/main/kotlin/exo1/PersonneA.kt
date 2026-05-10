package exo1

/**
 * Classe englobant des Personnes ou des Entreprises
 *
 * @property nom le nom de la personne ou de l'entreprise
 */
open class PersonneA protected constructor(protected open val nom: String) {

    companion object {

        /**
         * Méthode permettant de retourner une Personne ou une Entreprise à partir
         * de l'analyse d'une seule chaine de caractères qui doit respecter une format précis
         *
         * @param texteSaisi le texte a analyser
         * @return une Personne ou une Entreprise
         * @throws PersonneException si le chaine [texteSaisi] le respecte pas l'un des formats attendus
         * et donc, ne permet pas de créer une Personne ou une Entreprise
         */
        fun donnePersonneSaisie(texteSaisi: String): PersonneA {
            TODO("question 2")
        }
    }
}