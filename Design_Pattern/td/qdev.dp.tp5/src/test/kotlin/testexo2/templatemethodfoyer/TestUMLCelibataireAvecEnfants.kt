package testexo2.templatemethodfoyer

import exo2.templatemethodfoyer.CelibataireAvecEnfants
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for CelibataireAvecEnfants *****/

class TestUMLCelibataireAvecEnfants {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(CelibataireAvecEnfants::class)
    }

    @Test
    fun `test0 - class CelibataireAvecEnfants is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class CelibataireAvecEnfants is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'CelibataireAvecEnfants' extends other classe(s)`() {
        uml.extend("Foyer")
    }

    @Test
    fun `test3 - 'CelibataireAvecEnfants' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'CelibataireAvecEnfants' has method(s)`() {
        uml.methodNumber(5)
    }

    @Test
    fun `test5 - 'CelibataireAvecEnfants' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test6 - 'CelibataireAvecEnfants' has a method 'primeEnfants'`() {
        uml.methodCheck("primeEnfants", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test7 - 'CelibataireAvecEnfants' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test8 - 'CelibataireAvecEnfants' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test9 - 'CelibataireAvecEnfants' has a method 'modificateur'`() {
        uml.methodCheck("modificateur", Double::class, isOpenOrOverride = true)
    }


}
