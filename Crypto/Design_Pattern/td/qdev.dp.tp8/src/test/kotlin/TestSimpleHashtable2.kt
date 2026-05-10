import hashtables.IHashtable
import hashtables.SimpleHashtable
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestSimpleHashtable2 {

    data class Truc(val str : String, val value : Int)

    private lateinit var table : IHashtable<Truc>

    @BeforeEach
    fun init() {
            val fonctionHachage: (Truc) -> Int = {e -> e.value}
            table = SimpleHashtable(5, fonctionHachage)
    }

    @Test
    fun testVide() {
        assert(!table.contains(Truc("toto", 10)))
    }

    @Test
    fun testAjout() {
        table.add(Truc("toto", 10))
        assert(table.contains(Truc("toto", 10)))
    }

    @Test
    fun testGet() {
        val truc = Truc("toto", 10)
        table.add(truc)
        assertEquals(truc, table.get(truc))
    }

    @Test
    fun testGetNull() {
        val truc = Truc("toto", 10)
        val machin = Truc("titi", 20)
        table.add(truc)
        assertEquals(null, table.get(machin))
    }

    @Test
    fun testGetBonneRef() {
        val truc = Truc("toto", 10)
        val truc2 = Truc("toto", 10)
        table.add(truc)
        assertTrue(table.contains(truc2))
        assertSame(truc, table.get(truc2))
        assertNotSame(truc2, table.get(truc2))
    }

}
