import exo2.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestUsageCargaison {

    lateinit var m1: Marchandise
    lateinit var ca: Cargaison

    @BeforeEach
    fun reinitialise() {
        m1 = Marchandise(poids = 100.0, volume = 78.0)
        ca = Cargaison.donne(10, Cargaison.CARGAISON.ROUTIERE, false)
    }

    @Test
    fun testFactoryOKroutiere() {
        assertTrue( ca is CargaisonRoutiere)
    }

    @Test
    fun testFactoryOKfluviale() {
        ca = Cargaison.donne(10, Cargaison.CARGAISON.FLUVIALE, false)
        assertTrue( ca is CargaisonFluviale)
    }

    @Test
    fun testFactoryOKAerienne() {
        ca = Cargaison.donne(10, Cargaison.CARGAISON.AERIENNE, false)
        assertTrue( ca is CargaisonAerienne)
    }

    @Test
    fun testFactoryOKAerienneUrgente() {
        ca = Cargaison.donne(10, Cargaison.CARGAISON.AERIENNE, true)
        assertTrue( ca is CargaisonAerienneUrgente)
    }

    @Test
    fun testFactoryExceptionRoutiere() {
        assertThrows<UrgentImpossibleException> {
            Cargaison.donne(10, Cargaison.CARGAISON.ROUTIERE, true)
        }
    }

    @Test
    fun testFactoryExceptionFluviale() {
        assertThrows<UrgentImpossibleException> {
            Cargaison.donne(10, Cargaison.CARGAISON.FLUVIALE, true)
        }
    }

    @Test
    fun testMarchandise() {
        assertAll(
            { assertEquals(100.0, m1.donnePoids()) },
            { assertEquals(78.0, m1.donneVolume()) },
        )
    }

    @Test
    fun testCargaisonRoutiere_init() {
        assertAll(
            { assertEquals(0.0, ca.cout()) },
            { assertEquals(-1, ca.rechercher(m1)) }
        )
    }

    @Test
    fun testCargaisonRoutiere_1Ajout() {
        assertTrue(ca.ajouter(marchandise = m1))
    }

    @Test
    fun testCargaisonRoutiere_1Ajout_cout() {
        ca.ajouter(marchandise = m1)
        assertAll(
            { assertEquals((4 * 10 * 100.0), ca.cout()) },
            { assertTrue(ca.rechercher(marchandise = m1) != -1) }
        )
    }

    @Test
    fun testCargaisonRoutiere_plusieursAjouts() {
        ca.ajouter(marchandise = m1)
        for (i in 0 until 70) {
            ca.ajouter(Marchandise(10.0, 10.0))
        }
        assertTrue(ca.ajouter(Marchandise(37000.0, 1.0)))
    }

    @Test
    fun testCargaisonRoutiere_plusieursAjouts_cout() {
        ca.ajouter(marchandise = m1)
        for (i in 0 until 70) {
            ca.ajouter(Marchandise(10.0, 10.0))
        }
        ca.ajouter(Marchandise(37000.0, 1.0))

        assertEquals((4 * 10 * (100.0 + 37000.0 + (70 * 10.0))), ca.cout())
    }


    @Test
    fun testCargaisonRoutiere_plusieursAjouts_limite() {
        ca.ajouter(marchandise = m1)
        for (i in 0 until 70) {
            ca.ajouter(Marchandise(10.0, 10.0))
        }
        ca.ajouter(Marchandise(37000.0, 1.0))
        assertTrue(ca.ajouter(Marchandise(199.99, 1.0)))
    }

    @Test
    fun testCargaisonRoutiere_plusieursAjouts_limiteDepassee() {
        ca.ajouter(marchandise = m1)
        for (i in 0 until 70) {
            ca.ajouter(Marchandise(10.0, 10.0))
        }
        ca.ajouter(Marchandise(37000.0, 1.0))
        ca.ajouter(Marchandise(199.99, 1.0))
        assertFalse(ca.ajouter(Marchandise(20.0, 1.0)))
    }

    @Test
    fun testCargaisonRoutiere_plusieursAjouts_limiteTaille() {
        for (i in 0 until 99) {
            ca.ajouter(Marchandise(1.0, 1.0))
        }
        assertTrue(ca.ajouter(Marchandise(1.0, 1.0)))
    }

    @Test
    fun testCargaisonRoutiere_plusieursAjouts_limiteTailleDepassee() {
        for (i in 0 until 99) {
            ca.ajouter(Marchandise(1.0, 1.0))
        }
        ca.ajouter(Marchandise(1.0, 1.0))
        assertFalse(ca.ajouter(Marchandise(1.0, 1.0)))
    }

    @Test
    fun testAjoutEtRechercheDansCargaisonsDifferentes() {
        val m1 = Marchandise(50.0, 20.0)
        val m2 = Marchandise(80.0, 30.0)
        val m3 = Marchandise(120.0, 40.0)

        val cargFluviale = Cargaison.donne(15, Cargaison.CARGAISON.FLUVIALE)
        val cargRoutiere = Cargaison.donne(20, Cargaison.CARGAISON.ROUTIERE)
        val cargAerienne = Cargaison.donne(25, Cargaison.CARGAISON.AERIENNE)

        // Ajout dans chaque cargaison
        assertTrue(cargFluviale.ajouter(m1))
        assertTrue(cargFluviale.ajouter(m2))
        assertTrue(cargRoutiere.ajouter(m2))
        assertTrue(cargRoutiere.ajouter(m3))
        assertTrue(cargAerienne.ajouter(m1))
        assertTrue(cargAerienne.ajouter(m3))

        // Recherche
        assertAll(
            {assertEquals(0, cargFluviale.rechercher(m1))},
            {assertEquals(1, cargFluviale.rechercher(m2))},
            {assertEquals(-1, cargFluviale.rechercher(m3))},
            {assertEquals(0, cargRoutiere.rechercher(m2))},
            {assertEquals(1, cargRoutiere.rechercher(m3))},
            {assertEquals(-1, cargRoutiere.rechercher(m1))},
            {assertEquals(0, cargAerienne.rechercher(m1))},
            {assertEquals(1, cargAerienne.rechercher(m3))},
            {assertEquals(-1, cargAerienne.rechercher(m2))}
        )
    }

    @Test
    fun testCoutCargaisonsDifferentes() {
        val m1 = Marchandise(100.0, 10.0)
        val m2 = Marchandise(200.0, 20.0)

        val cargFluviale = Cargaison.donne(10, Cargaison.CARGAISON.FLUVIALE)
        val cargRoutiere = Cargaison.donne(10, Cargaison.CARGAISON.ROUTIERE)
        val cargAerienne = Cargaison.donne(10, Cargaison.CARGAISON.AERIENNE)

        cargFluviale.ajouter(m1)
        cargFluviale.ajouter(m2)
        cargRoutiere.ajouter(m2)
        cargAerienne.ajouter(m1)

        // Calcul du coût
        assertEquals(3000.0, cargFluviale.cout())
        assertEquals(8000.0, cargRoutiere.cout())
        assertEquals(1000.0, cargAerienne.cout())
    }
}