package testexo2.templatemethod

import exo2.Foyer
import exo2.templatemethod.CalculImpotCouple
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for CalculImpotCouple *****/

class TestUMLCalculImpotCouple {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(CalculImpotCouple::class)
    }

    @Test
    fun `test0 - class CalculImpotCouple is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class CalculImpotCouple is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'CalculImpotCouple' extends other classe(s)`() {
        uml.extend("CalculImpot")
    }

    @Test
    fun `test3 - 'CalculImpotCouple' has a constructor`() {
        uml.constructorCheck(paramsAndTypes = arrayOf(Pair("foyer", Foyer::class)))
    }

    @Test
    fun `test4 - 'CalculImpotCouple' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test5 - 'CalculImpotCouple' has method(s)`() {
        uml.methodNumber(3)
    }

    @Test
    fun `test5 - 'Couple' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test6 - 'Couple' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test7 - 'Couple' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }


}
