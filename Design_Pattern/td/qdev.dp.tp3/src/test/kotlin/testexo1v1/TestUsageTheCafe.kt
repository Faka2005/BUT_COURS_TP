package testexo1v1

import exo1.v1.The
import exo1.v1.Cafe
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestUsageTheCafe {

    val EXPECTED_THE_AVEC = "Portage de l'eau à ébulitionInfusion du théRemplissage de la tasseAjout du citron"
    val EXPECTED_THE_SANS = "Portage de l'eau à ébulitionInfusion du théRemplissage de la tasse"
    val EXPECTED_CAFE_AVEC = "Portage de l'eau à ébulitionPassage du caféRemplissage de la tasseAjout de sucre"
    val EXPECTED_CAFE_SANS = "Portage de l'eau à ébulitionPassage du caféRemplissage de la tasse"


    @Test
    fun testTheAvec() {
        val the = The()
        assertEquals(EXPECTED_THE_AVEC, the.suivreRecette(true))
    }

    @Test
    fun testTheSans() {
        val the = The()
        assertEquals(EXPECTED_THE_SANS, the.suivreRecette(false))
    }

    @Test
    fun testCafeAvec() {
        val cafe = Cafe()
        assertEquals(EXPECTED_CAFE_AVEC, cafe.suivreRecette(true))
    }

    @Test
    fun testCafeSans() {
        val cafe = Cafe()
        assertEquals(EXPECTED_CAFE_SANS, cafe.suivreRecette(false))
    }


}