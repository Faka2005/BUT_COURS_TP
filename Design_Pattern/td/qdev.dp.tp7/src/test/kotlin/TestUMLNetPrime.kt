import netprime.businesslayer.NetPrime
import netprime.datalayer.datamodel.medias.Media
import netprime.datalayer.datamodel.users.GENDER
import netprime.datalayer.datamodel.users.NAT
import netprime.datalayer.datamodel.users.Name
import netprime.datalayer.datamodel.users.User
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for NetPrime *****/

class TestUMLNetPrime {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(NetPrime::class)
    }

    @Test
    fun `test0 - class NetPrime is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class NetPrime is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'NetPrime' extends other classe(s)`() {
        uml.extend("iUserRepository", "iMediaRepository")
    }

    @Test
    fun `test6 - 'Netprime' constructeur`() {
        uml.constructorCheck(
            paramsTypesAndNullability = arrayOf(
                Triple("users", MutableSet::class, false),
                Triple("medias", MutableList::class, false),
                Triple("movies", MutableList::class, false),
                Triple("series", MutableList::class, false),
                Triple("episodes", MutableList::class, false)
            )
        )
    }


    @Test
    fun `test3 - 'NetPrime' has attribute(s)`() {
        uml.attributeNumber(5, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'NetPrime' has method(s)`() {
        uml.methodNumber(17, conformity = Conformity.STRONG)
    }


    @Test
    fun `test6 - 'NetPrime' has a method 'nbUsers'`() {
        uml.methodCheck("nbUsers", Int::class, isOpenOrOverride = true)
    }

    @Test
    fun `test7 - 'NetPrime' has a method 'listByNat'`() {
        uml.methodCheck(
            "listByNat",
            List::class,
            methParamAndTypes = arrayOf(Pair("nat", NAT::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test8 - 'NetPrime' has a method 'contains'`() {
        uml.methodCheck(
            "contains",
            Boolean::class,
            methParamAndTypes = arrayOf(Pair("user", User::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test9 - 'NetPrime' has a method 'delete'`() {
        uml.methodCheck("delete", methParamAndTypes = arrayOf(Pair("media", Media::class)), isOpenOrOverride = true)
    }

    @Test
    fun `test8 - 'NetPrime' has a method 'containsByLastname'`() {
        uml.methodCheck(
            "containsByLastname",
            Boolean::class,
            methParamAndTypes = arrayOf(Pair("lastname", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test9 - 'NetPrime' has a method 'deleteByEmail'`() {
        uml.methodCheck(
            "deleteByEmail",
            methParamAndTypes = arrayOf(Pair("email", String::class)),
            isOpenOrOverride = true
        )
    }


    @Test
    fun `test10 - 'NetPrime' has a method 'listByGender'`() {
        uml.methodCheck(
            "listByGender",
            List::class,
            methParamAndTypes = arrayOf(Pair("gender", GENDER::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test11 - 'NetPrime' has a method 'listByFirstname'`() {
        uml.methodCheck(
            "listByFirstname",
            List::class,
            methParamAndTypes = arrayOf(Pair("firstname", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test12 - 'NetPrime' has a method 'giveLogin'`() {
        uml.methodCheck(
            "giveLogin",
            Pair::class,
            methParamAndTypes = arrayOf(Pair("name", Name::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test16 - 'NetPrime' has a method 'nbTotalMedias'`() {
        uml.methodCheck("nbTotalMedias", Int::class, isOpenOrOverride = true)
    }

    @Test
    fun `test17 - 'NetPrime' has a method 'nbMovies'`() {
        uml.methodCheck("nbMovies", Int::class, isOpenOrOverride = true)
    }

    @Test
    fun `test18 - 'NetPrime' has a method 'nbSeries'`() {
        uml.methodCheck("nbSeries", Int::class, isOpenOrOverride = true)
    }

    @Test
    fun `test19 - 'NetPrime' has a method 'listAllMedias'`() {
        uml.methodCheck("listAllMedias", List::class, isOpenOrOverride = true)
    }

    @Test
    fun `test20 - 'NetPrime' has a method 'isSerieId'`() {
        uml.methodCheck(
            "isSerieId",
            Boolean::class,
            methParamAndTypes = arrayOf(Pair("id", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test21 - 'NetPrime' has a method 'episodesFrom'`() {
        uml.methodCheck(
            "episodesFrom",
            List::class,
            methParamAndTypes = arrayOf(Pair("title", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test22 - 'NetPrime' has a method 'listByTitleKeyword'`() {
        uml.methodCheck(
            "listByTitleKeyword",
            List::class,
            methParamAndTypes = arrayOf(Pair("keyword", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test23 - 'NetPrime' has a method 'listByCrew'`() {
        uml.methodCheck(
            "listByCrew",
            List::class,
            methParamAndTypes = arrayOf(Pair("person", String::class)),
            isOpenOrOverride = true
        )
    }

    @Test
    fun `test4 - 'NetPrime' has attribute medias`() {
        uml.attributeCheck("medias", List::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'NetPrime' has attribute movies`() {
        uml.attributeCheck("movies", List::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'NetPrime' has attribute series`() {
        uml.attributeCheck("series", List::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'NetPrime' has attribute episodes`() {
        uml.attributeCheck("episodes", List::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'NetPrime' has attribute users`() {
        uml.attributeCheck("users", Set::class, KVisibility.PRIVATE)
    }

}
