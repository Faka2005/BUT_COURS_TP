package testexo2

import exo2.INUTILISABLE
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for INUTILISABLE *****/

class TestUmlINUTILISABLE {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(INUTILISABLE::class)
    }

    @Test
    fun `test0 - class INUTILISABLE is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class INUTILISABLE is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'INUTILISABLE' extends other classe(s)`() {
        uml.extend("Dockable")
    }

    @Test
    fun `test3 - 'INUTILISABLE' has attribute(s)`() {
        uml.attributeNumber(0, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'INUTILISABLE' has method(s)`() {
        uml.methodNumber(0, conformity = Conformity.STRONG)
    }


}
