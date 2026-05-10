package exo1.v2

class Cafe {
     fun suivreRecette(supplément : Boolean) : String {
        var str = faireBouillirEau()
         str += filtrerCafe()
         str += verserDansTasse()
         if (supplément)
                  str += ajouterSucre()
        return str
     }

    private fun faireBouillirEau() = "Portage de l'eau à ébulition"

    private fun filtrerCafe() = "Passage du café"

    private fun verserDansTasse() = "Remplissage de la tasse"

    private fun ajouterSucre() = "Ajout de sucre"

}