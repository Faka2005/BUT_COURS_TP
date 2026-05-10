package exo1.v1

class The {
    fun suivreRecette(supplément : Boolean)  : String {
            var str = faireBouillirEau()
            str += infuserThe()
            str += verserDansTasse()
            if (supplément)
                str +=  ajouterCitron()
            return str
    }
    private fun faireBouillirEau() = "Portage de l'eau à ébulition"

    private fun infuserThe() = "Infusion du thé"

    private fun verserDansTasse()  = "Remplissage de la tasse"

    private fun ajouterCitron()  = "Ajout du citron"
}