package iut.but2.tp1

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class TestUsageFilePlusieursElements {

    lateinit var file  : File<Int>

    @BeforeEach
    fun reinit() {
        file = FileChainee()
        file.insererEnQueue(100)
        file.insererEnQueue(0)
        file.insererEnQueue(42)
    }

    @Test
    fun taille() {
        assertEquals(3, file.taille())
    }

    @Test
    fun listes() {
        assertAll(
            { assertEquals(mutableListOf<Int>(100, 0, 42), file.listerDepuisDebut()) },
            { assertEquals(mutableListOf<Int>(42, 0, 100), file.listerDepuisFin()) },
        )
    }

    @Test
    fun consultations() {
        assertAll(
            { assertEquals(100, file.consulter(0)) },
            { assertEquals(0, file.consulter(1)) },
            { assertEquals(42, file.consulter(2)) },
            { assertThrows<IndexOutOfBoundsException> { file.consulter(10) } },
        )
    }

    @Test
    fun deuxSuppr() {
        assertDoesNotThrow { file.supprimerEnTete() }
        assertDoesNotThrow { file.supprimerEnTete() }
    }

    @Test
    fun deuxSuppr_listedebut() {
        file.supprimerEnTete()
        file.supprimerEnTete()
        assertEquals(mutableListOf<Int>(42), file.listerDepuisDebut())
    }

    @Test
    fun deuxSuppr_listefin() {
        file.supprimerEnTete()
        file.supprimerEnTete()
        assertEquals(mutableListOf<Int>(42), file.listerDepuisFin())
    }

    @Test
    fun deuxSuppr_consult() {
        file.supprimerEnTete()
        file.supprimerEnTete()
        assertAll(
            { assertEquals(42, file.consulter(0)) },
            { assertThrows<IndexOutOfBoundsException> { file.consulter(10) } },
        )
    }

    @Test
    fun troisSuppr() {
        file.supprimerEnTete()
        file.supprimerEnTete()
        assertDoesNotThrow { file.supprimerEnTete() }
    }

    @Test
    fun troisSuppr_listeDebut() {
        file.supprimerEnTete()
        file.supprimerEnTete()
        file.supprimerEnTete()
        assertEquals(mutableListOf<Int>(), file.listerDepuisDebut())
    }

    @Test
    fun troisSuppr_listeFin() {
        file.supprimerEnTete()
        file.supprimerEnTete()
        file.supprimerEnTete()
        assertEquals(mutableListOf<Int>(), file.listerDepuisFin())
    }

    @Test
    fun troisSuppr_consult() {
        file.supprimerEnTete()
        file.supprimerEnTete()
        file.supprimerEnTete()
        assertThrows<IndexOutOfBoundsException> { file.consulter(0) }
    }


}