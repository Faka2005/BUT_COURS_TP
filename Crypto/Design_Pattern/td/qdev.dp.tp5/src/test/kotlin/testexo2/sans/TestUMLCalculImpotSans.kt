package testexo2.sans

import exo2.Foyer
import exo2.sans.CalculImpot
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for CalculImpot *****/

class TestUMLCalculImpotSans {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(CalculImpot::class)
    }

    @Test
    fun `test0 - class CalculImpot is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class CalculImpot is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'CalculImpot' extends other classe(s)`() {
        uml.extend("Impot")
    }

    @Test
    fun `test3 - 'CalculImpot' has a constructor`() {
        uml.constructorCheck(paramsAndTypes = arrayOf(Pair("foyer", Foyer::class)), visibility = KVisibility.PUBLIC)
    }

    @Test
    fun `test4 - 'CalculImpot' has attribute(s)`() {
        uml.attributeNumber(1)
    }

    @Test
    fun `test5 - 'CalculImpot' has an attribute 'foyer'`() {
        uml.attributeCheck("foyer", Foyer::class, KVisibility.PUBLIC)
    }

    @Test
    fun `test6 - 'CalculImpot' has method(s)`() {
        uml.methodNumber(2)
    }

    @Test
    fun `test7 - 'CalculImpot' has a method 'taxeHabitation'`() {
        uml.methodCheck("taxeHabitation", Int::class, isOpenOrOverride = true)
    }

    @Test
    fun `test8 - 'CalculImpot' has a method 'impotsSurLeRevenu'`() {
        uml.methodCheck("impotsSurLeRevenu", Int::class, isOpenOrOverride = true)
    }


}
