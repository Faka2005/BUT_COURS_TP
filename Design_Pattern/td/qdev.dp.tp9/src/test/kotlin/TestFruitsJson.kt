import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import tp9.dao.FruitDAO
import tp9.dao.FruitJsonDAO
import tp9.exceptions.FruitDejaPresentException
import tp9.exceptions.ImportFruitsException
import tp9.model.Fruit
import java.io.File

class TestFruitsJson {

    lateinit var mesFruits: List<Fruit>
    lateinit var dao: FruitDAO

    val basedir = "./data/"
    val testdir = basedir + "test/"
    val filename = "fruits.json"

    @BeforeEach
    fun init() {
        File(basedir + filename).copyTo(File(testdir + filename), overwrite = true)

        dao = FruitJsonDAO(File(testdir + filename))
    }

    @AfterEach
    fun clean() {
        File(testdir + filename).delete()
    }


    @Test
    fun testErreurImport() {
        val errorFilename = "fruits.csv"
        dao = FruitJsonDAO(File(basedir + errorFilename))
        assertThrows<ImportFruitsException> { dao.donneLesFruits() }
    }

    @Test
    fun testTousLesFruits() {
        mesFruits = dao.donneLesFruits()
        println(mesFruits)
        assertEquals(15, mesFruits.size)
        for (i in 1 until 15) {
            assertTrue(mesFruits[i - 1].nom < (mesFruits[i].nom))
        }
    }

    @Test
    fun testFruitsCoutantMoinsQue10() {
        mesFruits = dao.donneLesFruitsCoutantMoinsQue(10.0)
        assertEquals(4, mesFruits.size)
        for (i in 1 until 4) {
            assertTrue(mesFruits[i - 1].prix < mesFruits[i].prix)
        }
    }

    @Test
    fun testFruitBanane() {
        val banane = dao.donneLeFruit("Banane")
        assertNotNull(banane)
        assertEquals(Fruit("Banane", 8.4, 30), banane)
    }

    @Test
    fun testFruitGoyave() {
        val goyave = dao.donneLeFruit("Goyave")
        assertNotNull(goyave)
        assertEquals(Fruit("Goyave", 24.4, 0), goyave)
    }

    @Test
    fun testEnregistrementVide() {
        dao.enregistreLesFruits(emptyList<Fruit>())
        assertTrue(dao.donneLesFruits().isEmpty())
        assertEquals(emptyList<Fruit>(), dao.donneLesFruits())
    }

    @Test
    fun testEnregistrement() {
        mesFruits = dao.donneLesFruitsCoutantMoinsQue(10.0)
        dao.enregistreLesFruits(mesFruits)
        assertEquals(mesFruits, dao.donneLesFruitsCoutantMoinsQue(10.0))
    }


    @Test
    fun testAjout_exception() {
        val fruitPresent = dao.donneLeFruit("Banane")
        assertTrue(dao.donneLesFruits().contains(fruitPresent))
        assertNotNull(fruitPresent)
        assertThrows<FruitDejaPresentException> { dao.ajouteUnFruit(fruitPresent!!) }
        mesFruits = dao.donneLesFruits()
        assertEquals(15, mesFruits.size)
    }

    @Test
    fun testFruitNonPresent() {
        val fruitInexistant = Fruit("XXX", 4.2, 42)
        val fruitTrouve = dao.donneLeFruit("XXX")
        assertNull(fruitTrouve)
    }

    @Test
    fun testAjout() {
        assertEquals(15, dao.donneLesFruits().size)
        val fruitXXX = Fruit("XXX", 4.2, 42)
        dao.ajouteUnFruit(fruitXXX)
        assertEquals(16, dao.donneLesFruits().size)
        assertEquals(fruitXXX, dao.donneLeFruit("XXX"))
        assertTrue(dao.donneLesFruitsCoutantMoinsQue(5.0).contains(fruitXXX))
    }


}
