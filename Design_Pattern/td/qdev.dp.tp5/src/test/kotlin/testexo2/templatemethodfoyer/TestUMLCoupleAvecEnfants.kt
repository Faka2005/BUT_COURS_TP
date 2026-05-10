package testexo2.templatemethodfoyer

import exo2.templatemethodfoyer.CoupleAvecEnfants
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for CoupleAvecEnfants *****/

class TestUMLCoupleAvecEnfants {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(CoupleAvecEnfants::class)
    }

    @Test
    fun `test0 - class CoupleAvecEnfants is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class CoupleAvecEnfants is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'CoupleAvecEnfants' extends other classe(s)`() {
        uml.extend("Foyer")
    }

    @Test
    fun `test3 - 'CoupleAvecEnfants' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'CoupleAvecEnfants' has method(s)`() {
        uml.methodNumber(5)
    }

    @Test
    fun `test5 - 'CoupleAvecEnfants' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test6 - 'CoupleAvecEnfants' has a method 'primeEnfants'`() {
        uml.methodCheck("primeEnfants", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test7 - 'CoupleAvecEnfants' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test8 - 'CoupleAvecEnfants' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test9 - 'CoupleAvecEnfants' has a method 'modificateur'`() {
        uml.methodCheck("modificateur", Double::class, isOpenOrOverride = true)
    }


}
