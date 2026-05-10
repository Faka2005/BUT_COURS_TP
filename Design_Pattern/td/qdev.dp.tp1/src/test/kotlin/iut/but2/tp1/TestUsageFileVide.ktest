package iut.but2.tp1

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class TestUsageFileVide {

    lateinit var file  : File<Int>

    @BeforeEach
    fun reinit() {
        file = FileChainee()
    }

    @Test
    fun taille() {
        assertEquals(0, file.taille())
    }

    @Test
    fun listedebutvide() {
        assertEquals( mutableListOf<Int>(), file.listerDepuisDebut())
    }

    @Test
    fun listefinvide() {
        assertEquals( mutableListOf<Int>(), file.listerDepuisFin())
    }

    @Test
    fun consult0() {
        assertThrows<IndexOutOfBoundsException> { file.consulter(0) }
    }

    @Test
    fun consult10() {
        assertThrows<IndexOutOfBoundsException> { file.consulter(10) }
    }

    @Test
    fun supp() {
        assertThrows<NoSuchElementException> { file.supprimerEnTete() }
    }


}