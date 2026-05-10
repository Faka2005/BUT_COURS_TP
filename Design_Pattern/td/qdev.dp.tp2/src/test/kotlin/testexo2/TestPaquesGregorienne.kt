import exo2.Date
import exo2.Paques
import exo2.PaquesException
import exo2.PaquesGregorienne
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class TestPaquesGregorienne {

    lateinit var p: Paques

    @BeforeEach
    fun init() {
        p = PaquesGregorienne()
    }

    @Test
    fun testPaquesGregorienne125() {
        assertThrows<PaquesException> { p.calculeDatePaques(125) }
    }

    @Test
    fun testPaquesJulienne325() {
        assertThrows<PaquesException> { p.calculeDatePaques(325) }
    }

    @Test
    fun testPaquesJulienne326() {
        assertThrows<PaquesException> { p.calculeDatePaques(326) }
    }

    @Test
    fun testPaquesJulienne327() {
        assertThrows<PaquesException> { p.calculeDatePaques(327) }
    }

    @Test
    fun testPaquesGregorienne1492() {
        assertThrows<PaquesException> { p.calculeDatePaques(1492) }
    }

    @Test
    fun testPaquesGregorienne1582() {
        assertThrows<PaquesException> { p.calculeDatePaques(1582) }
    }

    @Test
    fun testPaquesGregorienne1583_v0() {
        val d = p.calculeDatePaques(1583)
        assertEquals("10-4-1583", d.toString())
    }

    @Test
    fun testPaquesGregorienne1583() {
        val d = p.calculeDatePaques(1583)
        assertEquals(Date(10, 4, 1583), d)
    }

    @Test
    fun testPaquesGregorienne2006() {
        val d = p.calculeDatePaques(2006)
        assertEquals(Date(16, 4, 2006), d)
    }

    @Test
    fun testPaquesGregorienne2015() {
        val d = p.calculeDatePaques(2015)
        assertEquals(Date(5, 4, 2015), d)
    }

    @Test
    fun testPaquesGregorienne2018() {
        val d = p.calculeDatePaques(2018)
        assertEquals(Date(1, 4, 2018), d)
    }

    @Test
    fun testPaquesGregorienne2019() {
        val d = p.calculeDatePaques(2019)
        assertEquals(Date(21, 4, 2019), d)
    }

    @Test
    fun testPaquesGregorienne2022() {
        val d = p.calculeDatePaques(2022)
        assertEquals(Date(17, 4, 2022), d)
    }

    @Test
    fun testPaquesGregorienne2040() {
        val d = p.calculeDatePaques(2040)
        assertEquals(Date(1, 4, 2040), d)
    }

}