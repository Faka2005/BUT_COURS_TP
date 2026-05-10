package testexo2.strategy

import exo2.Foyer
import exo2.strategy.CalculImpotCouple
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

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
