import kotlinx.serialization.json.Json
import netprime.datalayer.MediaDAO
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for MediaDAO *****/

class TestUMLMediaDAO {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(MediaDAO::class)
    }

    @Test
    fun `test0 - class MediaDAO is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class MediaDAO is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'MediaDAO' extends other classe(s)`() {
        uml.extend("iMediaDAO")
    }

    @Test
    fun `test3 - 'MediaDAO' has attribute(s)`() {
        uml.attributeNumber(5, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'MediaDAO' has method(s)`() {
        uml.methodNumber(3, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'MediaDAO' has attribute jsonparser`() {
        uml.attributeCheck("jsonparser", Json::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'MediaDAO' has attribute medias`() {
        uml.attributeCheck("medias", List::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'MediaDAO' has attribute movies`() {
        uml.attributeCheck("movies", List::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'MediaDAO' has attribute series`() {
        uml.attributeCheck("series", List::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'MediaDAO' has attribute episodes`() {
        uml.attributeCheck("episodes", List::class, KVisibility.PRIVATE)
    }


    @Test
    fun `test13 - 'MediaDAO' has a method 'addSeriesFrom'`() {
        uml.methodCheck(
            "addSeriesFrom",
            methParamAndTypes = arrayOf(Pair("filename", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test14 - 'MediaDAO' has a method 'addMoviesFrom'`() {
        uml.methodCheck(
            "addMoviesFrom",
            methParamAndTypes = arrayOf(Pair("filename", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test15 - 'MediaDAO' has a method 'addEpisodesFrom'`() {
        uml.methodCheck(
            "addEpisodesFrom",
            methParamAndTypes = arrayOf(Pair("filename", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test6 - 'MediaDAO' constructeur`() {
        uml.constructorCheck(
            paramsTypesAndNullability = arrayOf(
                Triple("medias", kotlin.collections.List::class, false),
                Triple("movies", kotlin.collections.List::class, false),
                Triple("series", kotlin.collections.List::class, false),
                Triple("episodes", kotlin.collections.List::class, false)
            )
        )
    }


}
