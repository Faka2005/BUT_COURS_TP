package testexo2.templatemethod

import exo2.Foyer
import exo2.templatemethod.CalculImpot
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for CalculImpot *****/

class TestUMLCalculImpotDansTemplateMethod {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(CalculImpot::class)
    }

    @Test
    fun `test0 - class CalculImpot is abstract or not`() {
        uml.isAbstract(true)
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
        uml.constructorCheck(paramsAndTypes = arrayOf(Pair("foyer", Foyer::class)), visibility = KVisibility.PROTECTED)
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
        uml.methodNumber(7)
    }

    @Test
    fun `test6 - 'Impot' has a method 'impotsSurLeRevenu'`() {
        uml.methodCheck("impotsSurLeRevenu", Int::class, isOpenOrOverride = true)
    }

    @Test
    fun `test7 - 'Impot' has a method 'taxeHabitation'`() {
        uml.methodCheck("taxeHabitation", Int::class, isOpenOrOverride = true)
    }

    @Test
    fun `test9 - 'Impot' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isAbstract = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test10 - 'Impot' has a method 'primeEnfants'`() {
        uml.methodCheck("primeEnfants", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test11 - 'Impot' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isAbstract = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test12 - 'Impot' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isAbstract = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test13 - 'Impot' has a method 'modificateur'`() {
        uml.methodCheck("modificateur", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

}
