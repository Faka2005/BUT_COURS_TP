package testexo2.strategy

import exo2.Foyer
import exo2.strategy.CalculImpotCelibataireAvecEnfants
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

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
