package testexo2.templatemethod

import exo2.Foyer
import exo2.templatemethod.CalculImpotCelibataire
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for CalculImpotCelibataire *****/

class TestUMLCalculImpotCelibataire {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(CalculImpotCelibataire::class)
    }

    @Test
    fun `test0 - class CalculImpotCelibataire is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class CalculImpotCelibataire is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'CalculImpotCelibataire' extends other classe(s)`() {
        uml.extend("CalculImpot")
    }

    @Test
    fun `test3 - 'CalculImpotCelibataire' has a constructor`() {
        uml.constructorCheck(paramsAndTypes = arrayOf(Pair("foyer", Foyer::class)))
    }

    @Test
    fun `test4 - 'CalculImpotCelibataire' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test5 - 'CalculImpotCelibataire' has method(s)`() {
        uml.methodNumber(4)
    }

    @Test
    fun `test5 - 'Celibataire' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test6 - 'Celibataire' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test7 - 'Celibataire' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }

    @Test
    fun `test8 - 'Celibataire' has a method 'modificateur'`() {
        uml.methodCheck("modificateur", Double::class, isOpenOrOverride = true, methVisibility = KVisibility.PROTECTED)
    }


}
