package testexo2

import exo2.Date
import exo2.Paques
import exo2.PaquesException
import exo2.PaquesJulienne
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestPaquesJulienne {

    lateinit var p: Paques

    @BeforeEach
    fun init() {
        p = PaquesJulienne()
    }

    @Test
    fun testPaquesJulienne125() {
        assertThrows<PaquesException> { p.calculeDatePaques(125) }
    }

    @Test
    fun testPaquesJulienne324() {
        assertThrows<PaquesException> { p.calculeDatePaques(324) }
    }

    @Test
    fun testPaquesJulienne325() {
        assertThrows<PaquesException> { p.calculeDatePaques(325) }
    }

    @Test
    fun testPaquesJulienne326() {
        val d: Date = p.calculeDatePaques(326)
        assertEquals("3-4-326", d.toString())
    }

    @Test
    fun testPaquesJulienne327() {
        val d: Date = p.calculeDatePaques(327)
        assertEquals("26-3-327", d.toString())
    }

    @Test
    fun testPaquesJulienne1492() {
        val d: Date = p.calculeDatePaques(1492)
        assertEquals("22-4-1492", d.toString())
    }
}