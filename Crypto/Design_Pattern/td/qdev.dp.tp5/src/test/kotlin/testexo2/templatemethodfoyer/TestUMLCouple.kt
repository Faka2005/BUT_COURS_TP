package testexo2.templatemethodfoyer

import exo2.templatemethodfoyer.Couple
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for Couple *****/

class TestUMLCouple {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Couple::class)
    }

    @Test
    fun `test0 - class Couple is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class Couple is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Couple' extends other classe(s)`() {
        uml.extend("Foyer")
    }

    @Test
    fun `test3 - 'Couple' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'Couple' has method(s)`() {
        uml.methodNumber(3)
    }

    @Test
    fun `test5 - 'Couple' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test6 - 'Couple' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test7 - 'Couple' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isOpenOrOverride = true)
    }


}
