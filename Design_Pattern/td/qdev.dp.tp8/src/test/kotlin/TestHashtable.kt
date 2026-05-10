import hashtables.Hashtable
import hashtables.IHashtable
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll


class TestHashtable {

    private lateinit var table : IHashtable<Int>

    @BeforeEach
    fun init() {
        val fonctionHachage: (Int) -> Int = {e -> e}
        table = Hashtable(5, fonctionHachage)
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
            { assertEquals(null, table.get(4))}    )
    }

    @Test
    fun testNoColisions() {
        table.add(1)
        assertDoesNotThrow { table.add(5) }
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
        // ajout d'élements en collision
        assertTrue(table.add(10))
        assertTrue(table.add(-2))
        assertTrue(table.add(12))
        // nombre de collisions évitées
        assertEquals(3,table.avoidedCollisions())
    }

    @Test
    fun testColision_2() {
        table.add(1)
        table.add(-5)
        table.add(7)
        table.add(9)
        // ajout d'élements en collision
        assertDoesNotThrow { table.add(10)}
        assertDoesNotThrow { table.add(-2)}
        assertDoesNotThrow { table.add(12)}
        // nombre de collisions évitées
        assertEquals(3,table.avoidedCollisions())
    }

    @Test
    fun testElementDejaPresent() {
        table.add(1)
        table.add(-5)
        table.add(7)
        table.add(9)
        table.add(10)
        table.add(-2)
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
        assertFalse(table.remove(2))
    }

    @Test
    fun testSupprimer_elementCollision() {
        table.add(1)
        table.add(-5)
        table.add(7)
        table.add(9)
        assertFalse(table.remove(10))
    }

    @Test
    fun testRedimensionnement_20() {
        val table1 = Hashtable<Int>(5, {it})
        table1.add(1)
        table1.add(-5)
        table1.add((7))
        table1.add((9))
        table1.add((10))
        table1.add((10))
        table1.add((-2))
        table1.add((12))
        val table2 = Hashtable.resize(table1, 20)
        assertEquals(0,table2.avoidedCollisions())
        //
        assertTrue(table2.contains((1)))
        assertTrue(table2.contains((-5)))
        assertTrue(table2.contains((7)))
        assertTrue(table2.contains((9)))
        assertTrue(table2.contains((10)))
        assertTrue(table2.contains((-2)))
        assertTrue(table2.contains((12)))
    }

    @Test
    fun testRedimensionnement_1() {
        val table1 = Hashtable<Int>(5, {it})
        table1.add((1))
        table1.add((-5))
        table1.add((7))
        table1.add((9))
        table1.add((10))
        table1.add((10))
        table1.add((-2))
        table1.add((12))
        val table2 = Hashtable.resize(table1, 1)
        assertEquals(6,table2.avoidedCollisions())
        //
        assertTrue(table2.contains((1)))
        assertTrue(table2.contains((-5)))
        assertTrue(table2.contains((7)))
        assertTrue(table2.contains((9)))
        assertTrue(table2.contains((10)))
        assertTrue(table2.contains((-2)))
        assertTrue(table2.contains((12)))
    }

}