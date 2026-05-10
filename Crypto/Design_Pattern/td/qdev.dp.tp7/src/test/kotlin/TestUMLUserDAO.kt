import kotlinx.serialization.json.Json
import netprime.datalayer.UserDAO
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for UserDAO *****/

class TestUMLUserDAO {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(UserDAO::class)
    }

    @Test
    fun `test0 - class UserDAO is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class UserDAO is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'UserDAO' extends other classe(s)`() {
        uml.extend("iUserDAO")
    }

    @Test
    fun `test6 - 'UserDAO' constructeur`() {
        uml.constructorCheck(paramsAndTypes = arrayOf(Pair("users", MutableSet::class)))

        uml.constructorCheck(
            paramsTypesAndNullability = arrayOf(Triple("users", MutableSet::class, false)),
            visibility = KVisibility.PUBLIC,
            Conformity.STRONG
        )
    }

    @Test
    fun `test3 - 'UserDAO' has attribute(s)`() {
        uml.attributeNumber(2, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'UserDAO' has attribute 'jsonparser'`() {
        uml.attributeCheck("jsonparser", Json::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'UserDAO' has attribute 'users'`() {
        uml.attributeCheck("users", Set::class, KVisibility.PRIVATE)
    }

    @Test
    fun `test4 - 'UserDAO' has method(s)`() {
        uml.methodNumber(1, conformity = Conformity.STRONG)
    }

    @Test
    fun `test5 - 'UserDAO' has a method 'addFrom'`() {
        uml.methodCheck(
            "addFrom",
            methParamAndTypes = arrayOf(Pair("filename", String::class)),
            isOpenOrOverride = true
        )
    }
}
