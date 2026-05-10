package testexo1v2

import exo1.v2.The
import exo1.v2.Cafe
import exo1.v2.Cacao
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestUsageCacao {

    val CACAO_AVEC = "Portage du lait à ébulitionMélange du lait et du cacaoRemplissage de la tasseAjout de chantilly"
    val CACAO_SANS = "Portage du lait à ébulitionMélange du lait et du cacaoRemplissage de la tasse"


        @Test
        fun testFaireBouillir() {
            val cacao = Cacao()
            assertEquals("Portage du lait à ébulition", cacao.faireBouillir())
        }

        @Test
        fun testPreparer() {
            val cacao = Cacao()
            assertEquals("Mélange du lait et du cacao", cacao.preparer())
        }

        @Test
        fun testAjouterSupplement() {
            val cacao = Cacao()
            assertEquals("Ajout de chantilly", cacao.ajouterSupplement())
        }

    @Test
    fun testCacaoAvec() {
        val cacao = Cacao()
        assertEquals(CACAO_AVEC, cacao.suivreRecette(true))
    }

    @Test
    fun testCacaoSans() {
        val cacao = Cacao()
        assertEquals(CACAO_SANS, cacao.suivreRecette(false))
    }


}