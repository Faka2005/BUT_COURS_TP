package test.fr.nantes.univ.clock

import fr.nantes.univ.clock.AlarmClockException
import fr.nantes.univ.clock.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class BasicAlarmClockTest {
    @Test
    fun checkTimeAndRing() {
    }

    @Test
    fun `constructor nominal case`() {
        // GIVEN : paramètres valides
        val ring = 5
        val hour = 10
        val min = 30

        // WHEN : création de l'alarme
        val alarm = BasicAlarmClock(ring, hour, min)
        // THEN : vérification de l'état initial
        assertEquals(ring, alarm.ring, "La sonnerie doit être initialisée")
        assertEquals(hour, alarm.hour, "L'heure doit être initialisée")
        assertEquals(min, alarm.min, "Les minutes doivent être initialisées")

        assertFalse(alarm.isEnabled, "L'alarme doit être désactivée par défaut")
        assertFalse(alarm.isRinging, "L'alarme ne doit pas sonner à la création")
    }
    @Test
    fun `addMin1`() {

        val alarm = BasicAlarmClock(1, 0, 0)
        assertFailsWith<AlarmClockException> {
            alarm.addMin(-1)
        }
    }
    @Test
    fun `addMin2`() {
        val alarm2 = BasicAlarmClock(1, 22, 59)
        alarm2.addMin(61)
        assertEquals(0, alarm2.hour)
        assertEquals(0, alarm2.min)
    }
    @Test
    fun `addMin3`() {
        val alarm3 = BasicAlarmClock(1, 0, 0)
        alarm3.addMin(0)
        assertEquals(0, alarm3.hour)
        assertEquals(0, alarm3.min)
    }
    @Test
    fun `addMin4`() {
        val alarm4 = BasicAlarmClock(1, 0, 59)
        alarm4.addMin(61)
        assertEquals(2, alarm4.hour)
        assertEquals(0, alarm4.min)
    }
    @Test
    fun `addMin5`() {
        val alarm5 = BasicAlarmClock(1, 23, 0)
        alarm5.addMin(60)
        assertEquals(0, alarm5.hour)
        assertEquals(0, alarm5.min)
    }
    @Test
    fun `addMin6`() {
        val alarm6 = BasicAlarmClock(1, 0, 0)
        alarm6.addMin(60)
        assertEquals(1, alarm6.hour)
        assertEquals(0, alarm6.min)
    }

    @Test
    fun `addMin7`() {
        val alarm7 = BasicAlarmClock(1, 23, 59)
        alarm7.addMin(1)
        assertEquals(0, alarm7.hour)
        assertEquals(0, alarm7.min)
    }

    @Test
    fun `addMin8`() {
        val alarm8 = BasicAlarmClock(1, 0, 59)
        alarm8.addMin(1)
        assertEquals(1, alarm8.hour)
        assertEquals(0, alarm8.min)

    }

    @Test
    fun  `selecctRing1`(){
        val clock = BasicAlarmClock(1, 0, 0)
        clock.setRingingOn()
        assertTrue(clock.isRinging)

        assertFalse(clock.selectRing(2))
    }

    @Test
    fun  `selecctRing2`(){
        val clock = BasicAlarmClock(1, 0, 0)

        assertFalse(clock.isRinging)

        assertFalse(clock.selectRing(1))
    }

    @Test
    fun  `switchOff`(){

    }
}