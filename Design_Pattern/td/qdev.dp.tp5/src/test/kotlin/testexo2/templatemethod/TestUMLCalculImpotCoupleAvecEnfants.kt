package testexo2.templatemethod

import exo2.Foyer
import exo2.templatemethod.CalculImpotCoupleAvecEnfants
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for CalculImpotCoupleAvecEnfants *****/

class TestUMLCalculImpotCoupleAvecEnfants {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(CalculImpotCoupleAvecEnfants::class)
    }

    @Test
    fun `test0 - class CalculImpotCoupleAvecEnfants is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class CalculImpotCoupleAvecEnfants is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'CalculImpotCoupleAvecEnfants' extends other classe(s)`() {
        uml.extend("CalculImpot")
    }

    @Test
    fun `test3 - 'CalculImpotCoupleAvecEnfants' has a constructor`() {
        uml.constructorCheck(paramsAndTypes = arrayOf(Pair("foyer", Foyer::class)))
    }

    @Test
    fun `test4 - 'CalculImpotCoupleAvecEnfants' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test5 - 'CalculImpotCoupleAvecEnfants' has method(s)`() {
        uml.methodNumber(5)
    }

    @Test
    fun `test5 - 'CoupleAvecEnfants' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test6 - 'CoupleAvecEnfants' has a method 'primeEnfants'`() {
        uml.methodCheck("primeEnfants", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test7 - 'CoupleAvecEnfants' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test8 - 'CoupleAvecEnfants' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test9 - 'CoupleAvecEnfants' has a method 'modificateur'`() {
        uml.methodCheck("modificateur", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

}
