import hashtables.CollisionException
import hashtables.IHashtable
import hashtables.SimpleHashtable
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows


class TestSimpleHashtable {



    private lateinit var table : IHashtable<Int>

    @BeforeEach
    fun init() {
        val fonctionHachage: (Int) -> Int = {e -> e}
            table = SimpleHashtable(5, fonctionHachage)
    }

    @Test
    fun testVide() {
        assertFalse(10 in table)
    }

    @Test
    fun testUnElement() {
        assertAll(
            { assertTrue(table.add(1)) },
            { assertTrue(1 in table) },
            { assertFalse(4 in table) },
            { assertEquals(1, table.get(1))},
            { assertEquals(null, table.get(4))}
        )
    }

    @Test
    fun testNoColisions() {
        table.add(1)
        assertDoesNotThrow { table.add(-5) }
        assertDoesNotThrow { table.add(7) }
    }

    @Test
    fun testPlusieursElements() {
        assertAll(
            { assertTrue(table.add(1)) },
            { assertTrue(table.add(-5)) },
            { assertTrue(table.add(7)) },
            { assertTrue(table.add(9)) }
        )
        assertAll(
            {  assertTrue(1 in table) },
            {  assertTrue(-5 in table) },
            {  assertTrue(7 in table) },
            {  assertTrue(9 in table) },
            { assertEquals(1, table.get(1))},
            { assertEquals(null, table.get(4))},
            {  assertEquals(4, table.nbElements())}
        )
    }

    @Test
    fun testColision() {
        table.add(1)
        table.add(-5)
        table.add(7)
        table.add(9)
        assertThrows<CollisionException> { table.add(10) }
    }

    @Test
    fun testElementDejaPresent() {
        table.add(1)
        table.add(-5)
        table.add(7)
        table.add(9)
        // ajout d'un élément déjà présent
        assertFalse(table.add(1))
    }

    @Test
    fun testSupprimer() {
        table.add(1)
        table.add(-5)
        table.add(7)
        table.add(9)
        assertTrue(table.remove(7))
        assertFalse(7 in table)
    }

    @Test
    fun testSupprimer_elementAbsent() {
        table.add(1)
        table.add(-5)
        table.add(7)
        table.add(9)
        assertFalse(table.remove(-2))
    }

    @Test
    fun testSupprimer_elementCollision() {
        table.add(1)
        table.add(-5)
        table.add(7)
        table.add(9)
        assertFalse(table.remove(10))
    }



}