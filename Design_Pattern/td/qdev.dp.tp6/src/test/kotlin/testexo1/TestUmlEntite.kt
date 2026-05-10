package testexo1

import exo1.Entite
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for Entite *****/

class TestUmlEntite {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Entite::class)
    }

    @Test
    fun `test0 - class Entite is abstract or not`() {
        uml.isAbstract(true)
    }

    @Test
    fun `test1 - class Entite is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Entite' extends other classe(s)`() {
        uml.extend("Salariable")
    }

    @Test
    fun `test3 - 'Entite' has attribute(s)`() {
        uml.attributeNumber(0, conformity = univ.nantes.umlchecker.Conformity.STRONG)
    }

    @Test
    fun `test5 - 'Entite' has method(s)`() {
        uml.methodNumber(0, conformity = univ.nantes.umlchecker.Conformity.STRONG)
    }


}
