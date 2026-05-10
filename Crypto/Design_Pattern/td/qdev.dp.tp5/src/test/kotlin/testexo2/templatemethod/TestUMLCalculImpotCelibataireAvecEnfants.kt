package testexo2.templatemethod

import exo2.Foyer
import exo2.templatemethod.CalculImpotCelibataireAvecEnfants
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for CalculImpotCelibataireAvecEnfants *****/

class TestUMLCalculImpotCelibataireAvecEnfants {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(CalculImpotCelibataireAvecEnfants::class)
    }

    @Test
    fun `test0 - class CalculImpotCelibataireAvecEnfants is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class CalculImpotCelibataireAvecEnfants is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'CalculImpotCelibataireAvecEnfants' extends other classe(s)`() {
        uml.extend("CalculImpot")
    }

    @Test
    fun `test3 - 'CalculImpotCelibataireAvecEnfants' has a constructor`() {
        uml.constructorCheck(paramsAndTypes = arrayOf(Pair("foyer", Foyer::class)))
    }

    @Test
    fun `test4 - 'CalculImpotCelibataireAvecEnfants' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test5 - 'CalculImpotCelibataireAvecEnfants' has method(s)`() {
        uml.methodNumber(5)
    }

    @Test
    fun `test5 - 'CelibataireAvecEnfants' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test6 - 'CelibataireAvecEnfants' has a method 'primeEnfants'`() {
        uml.methodCheck("primeEnfants", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test7 - 'CelibataireAvecEnfants' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test8 - 'CelibataireAvecEnfants' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test9 - 'CelibataireAvecEnfants' has a method 'modificateur'`() {
        uml.methodCheck("modificateur", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }


}
