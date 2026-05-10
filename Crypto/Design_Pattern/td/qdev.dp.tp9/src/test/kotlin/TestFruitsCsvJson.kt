import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import tp9.dao.FruitCsvDAO
import tp9.dao.FruitDAO
import tp9.dao.FruitJsonDAO
import java.io.File

class TestFruitsCsvJson {

    lateinit var daoJson: FruitDAO
    lateinit var daoCsv: FruitDAO

    val basedir = "./data/"
    val testdir = basedir + "test/"
    val filenameJSON = "fruits.json"
    val filenameCSV = "fruits.csv"


    @BeforeEach
    fun init() {
        File(basedir + filenameJSON).copyTo(File(testdir + filenameJSON), overwrite = true)
        File(basedir + filenameCSV).copyTo(File(testdir + filenameCSV), overwrite = true)
        daoJson = FruitJsonDAO(File(testdir + filenameJSON))
        daoCsv = FruitCsvDAO(File(testdir + filenameCSV))
    }

    @AfterEach
    fun clean() {
        File(testdir + filenameJSON).delete()
        File(testdir + filenameCSV).delete()
    }

    @Test
    fun testTousLesFruits() {
        val fruitsJ = daoJson.donneLesFruits()
        val fruitsS = daoCsv.donneLesFruits()
        assertEquals(fruitsJ, fruitsS)
    }

    @Test
    fun testFruitsCoutantMoinsQue10() {
        val fruitsJ = daoJson.donneLesFruitsCoutantMoinsQue(10.0)
        val fruitsS = daoCsv.donneLesFruitsCoutantMoinsQue(10.0)
        assertEquals(fruitsJ, fruitsS)
    }

    @Test
    fun testEnregistrement() {
        val mesFruits = daoJson.donneLesFruitsCoutantMoinsQue(10.0)
        daoCsv.enregistreLesFruits(mesFruits)
        assertEquals(mesFruits, daoCsv.donneLesFruitsCoutantMoinsQue(10.0))
    }
}
