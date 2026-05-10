package testexo1v2

import exo1.v2.The
import exo1.v2.Cafe
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestUsageTheCafe {

    val THE_AVEC = "Portage de l'eau à ébulitionInfusion du théRemplissage de la tasseAjout du citron"
    val THE_SANS = "Portage de l'eau à ébulitionInfusion du théRemplissage de la tasse"
    val CAFE_AVEC = "Portage de l'eau à ébulitionPassage du caféRemplissage de la tasseAjout de sucre"
    val CAFE_SANS = "Portage de l'eau à ébulitionPassage du caféRemplissage de la tasse"

    @Test
    fun testTheAvec() {
        val the = The()
        assertEquals(THE_AVEC, the.suivreRecette(true))
    }

    @Test
    fun testTheSans() {
        val the = The()
        assertEquals(THE_SANS, the.suivreRecette(false))
    }

    @Test
    fun testCafeAvec() {
        val cafe = Cafe()
        assertEquals(CAFE_AVEC, cafe.suivreRecette(true))
    }

    @Test
    fun testCafeSans() {
        val cafe = Cafe()
        assertEquals(CAFE_SANS, cafe.suivreRecette(false))
    }


}