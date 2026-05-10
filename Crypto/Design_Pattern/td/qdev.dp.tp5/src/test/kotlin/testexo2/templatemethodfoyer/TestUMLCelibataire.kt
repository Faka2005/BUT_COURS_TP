package testexo2.templatemethodfoyer

import exo2.templatemethodfoyer.Celibataire
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for Celibataire *****/

class TestUMLCelibataire {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Celibataire::class)
    }

    @Test
    fun `test0 - class Celibataire is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class Celibataire is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Celibataire' extends other classe(s)`() {
        uml.extend("Foyer")
    }

    @Test
    fun `test3 - 'Celibataire' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'Celibataire' has method(s)`() {
        uml.methodNumber(4)
    }

    @Test
    fun `test5 - 'Celibataire' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test6 - 'Celibataire' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test7 - 'Celibataire' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test8 - 'Celibataire' has a method 'modificateur'`() {
        uml.methodCheck("modificateur", Double::class, isOpenOrOverride = true)
    }


}
