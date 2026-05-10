package iut.but2.tp1

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class TestUsageFile1Element {

    lateinit var file : File<Int>

    @BeforeEach
    fun reinit() {
        file = FileChainee()
        file.insererEnQueue(42)
    }


    @Test
    fun taille() {
        assertEquals(1, file.taille())
    }

    @Test
    fun listedebut() {
        assertEquals(mutableListOf(42), file.listerDepuisDebut())
    }

    @Test
    fun listeFin() {
        assertEquals(mutableListOf(42), file.listerDepuisFin())
    }

    @Test
    fun consult0() {
        assertEquals(42, file.consulter(0))
    }

    @Test
    fun consult10() {
        assertThrows<IndexOutOfBoundsException> { file.consulter(10) }
    }


    @Test
    fun suppr() {
        assertDoesNotThrow { file.supprimerEnTete() }
    }

    @Test
    fun suppr_taille() {
        file.supprimerEnTete()
        assertEquals(0, file.taille())
    }

    @Test
    fun suppr_listedebut() {
        file.supprimerEnTete()
        assertEquals(mutableListOf<Int>(), file.listerDepuisDebut())
    }

    @Test
    fun suppr_listefin() {
        file.supprimerEnTete()
        assertEquals(mutableListOf<Int>(), file.listerDepuisFin())
    }

    @Test
    fun suppr_consult() {
        file.supprimerEnTete()
        assertThrows<IndexOutOfBoundsException> { file.consulter(0) }
    }
}