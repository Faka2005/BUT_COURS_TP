import hashtables.CollisionException
import hashtables.Hashtable
import hashtables.SimpleHashtable
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TestExemplePersonne {

    data class Personne(val nom : String, val age :Int, val ville : String)

    @Test
    fun exemple1() {
        val table = SimpleHashtable<Personne>(5, {pers -> pers.age})
        assertTrue(table.add(Personne("Alfred", 42, "Nantes")))
        assertTrue(table.add(Personne("Justine", 20, "Rennes")))
        assertTrue(table.add(Personne("Kevin", 9, "Paris")))
    }


    @Test
    fun exemple2() {
        val table = SimpleHashtable<Personne>(5, {pers -> pers.nom[0].toInt()})
        assertTrue(table.add(Personne("Alfred", 42, "Nantes")))
        assertTrue(table.add(Personne("Justine", 20, "Rennes")))
        assertThrows<CollisionException> { table.add(Personne("Kevin", 9, "Paris")) }
    }

    @Test
    fun exemple3() {
        val table = Hashtable<Personne>(5, {pers -> pers.nom[0].toInt()})
        assertTrue(table.add(Personne("Alfred", 42, "Nantes")))
        assertTrue(table.add(Personne("Justine", 20, "Rennes")))
        assertDoesNotThrow { table.add(Personne("Kevin", 9, "Paris")) }
        assertEquals(1, table.avoidedCollisions())
    }
}