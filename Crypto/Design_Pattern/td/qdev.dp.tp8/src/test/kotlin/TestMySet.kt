import usinghashtables.ISet
import usinghashtables.MySet
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestMySet {

    lateinit var set : ISet<Int>

    @BeforeEach
    fun reninit() {
        set = MySet()
    }

    @Test
    fun testEmpty() {
        assertTrue(set.isEmpty())
        assertEquals(0, set.size())
    }
    @Test
    fun testAddContain() {
        assertTrue(set.add(-10))
        assertTrue(set.contains(-10))
        assertFalse(set.contains(42))
        assertFalse(set.isEmpty())
        assertEquals(1, set.size())
    }

    @Test
    fun testAddContainMORE() {
        assertTrue(set.add(10))
        assertTrue(set.add(20))
        assertTrue(set.add(30))
        assertTrue(set.contains(10))
        assertTrue(set.contains(20))
        assertTrue(set.contains(30))
        assertFalse(set.contains(42))
        assertFalse(set.isEmpty())
        assertEquals(3, set.size())
    }

    @Test
    fun testAddWithDouble() {
        assertTrue(set.add(10))
        assertTrue(set.add(20))
        assertTrue(set.add(30))
        assertFalse(set.add(10))
        assertFalse(set.add(20))
        assertFalse(set.add(30))

    }

    @Test
    fun testRemove() {
        set.add(10)
        set.add(20)
        set.add(30)
        assertTrue(set.remove(20))
        assertTrue(set.contains(10))
        assertFalse(set.contains(20))
        assertTrue(set.contains(30))
        assertEquals(2, set.size())
    }

    @Test
    fun testRemoveUnknownValue() {
        set.add(10)
        set.add(20)
        set.add(30)
        assertFalse(set.remove(42))
        assertTrue(set.contains(10))
        assertTrue(set.contains(20))
        assertTrue(set.contains(30))
        assertFalse(set.contains(42))
        assertEquals(3, set.size())
    }


    @Test
    fun testContainsAll() {
        set.add(10)
        set.add(20)
        set.add(30)
        assertTrue(set.containsAll(listOf(10, 20, 30)))
        assertTrue(set.containsAll(listOf(10, 30)))
        assertTrue(set.containsAll(listOf(30, 20)))
        assertFalse(set.containsAll(listOf(10, 20, 30, 42)))
        assertFalse(set.containsAll(listOf(666, 42)))
        assertEquals(3, set.size())
    }




    @Test
    fun testAddAll() {
        assertTrue(set.addAll(listOf(30, 20, 10)))
        assertTrue(set.containsAll(listOf(10, 20, 30)))
        assertEquals(3, set.size())
    }

    @Test
    fun testAddAllWithDoubleValues() {
        assertTrue(set.addAll(listOf(30, 20, 10, 20, 30, 10, 20, 30, 30, 30, 10, 10)))
        assertTrue(set.containsAll(listOf(10, 20, 30)))
        assertEquals(3, set.size())
    }

    @Test
    fun testAddAllWithoutUpdateValues() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42, 10, 42))
        assertFalse(set.addAll(listOf(20, 666)))
        assertEquals(7, set.size())
    }

    @Test
    fun testRemoveAll() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42))
        assertTrue(set.removeAll(listOf(50, 42, 10)))
        assertEquals(4, set.size())
        assertTrue(set.containsAll(listOf(30, 20, 35, 666)))
        assertFalse(set.containsAll(listOf(10, 50, 42)))

    }

    @Test
    fun testRemoveAll_AllValues() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42))
        assertTrue(set.removeAll(listOf(30, 20, 10, 50, 35, 666, 42)))
        assertEquals(0, set.size())
        assertFalse(set.containsAll(listOf(30, 20, 10, 50, 35, 666, 42)))
        assertTrue(set.isEmpty())
    }

    @Test
    fun testRemoveAllunkownValues() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42))
        assertFalse(set.removeAll(listOf(0, 112, 40)))
        assertTrue(set.containsAll(listOf(10, 20, 30, 35, 42, 50, 666)))
        assertEquals(7, set.size())
    }

    @Test
    fun testRemoveSomeUnkownValues() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42))
        assertTrue(set.removeAll(listOf(0, 112, 50, 40, 42, 10)))
        assertEquals(4, set.size())
        assertTrue(set.containsAll(listOf(20, 30, 35, 666)))
        assertFalse(set.containsAll(listOf(10, 50, 42)))
    }

    @Test
    fun testRetainAll() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42))
        assertTrue(set.retainAll(listOf(50, 42, 10)))
        assertFalse(set.containsAll(listOf(20, 30, 35, 666)))
        assertTrue(set.containsAll(listOf(10, 50, 42)))
    }

    @Test
    fun testRetainAllWithUnkownValues() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42))
        assertTrue(set.retainAll(listOf(112, 50, 0, 42, 10, 99)))
        assertFalse(set.containsAll(listOf(20, 30, 35, 666)))
        assertTrue(set.containsAll(listOf(10, 50, 42)))
    }

    @Test
    fun testRetainAllOnlyUnkownValues() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42))
        assertTrue(set.retainAll(listOf(112, 0, 99)))
        assertFalse(set.containsAll(listOf(30, 20, 10, 50, 35, 666, 42)))
        assertTrue(set.isEmpty())
    }

    @Test
    fun testRetainAll_AllValues() {
        set.addAll(listOf(30, 20, 10, 50, 35, 666, 42))
        assertFalse(set.retainAll(listOf(30, 20, 10, 50, 35, 666, 42)))
        assertTrue(set.containsAll(listOf(30, 20, 10, 50, 35, 666, 42)))
    }



}