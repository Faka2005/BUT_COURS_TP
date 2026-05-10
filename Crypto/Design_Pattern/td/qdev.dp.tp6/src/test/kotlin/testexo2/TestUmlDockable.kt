package testexo2

import exo2.Dockable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for Dockable *****/

class TestUmlDockable {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Dockable::class)
    }

    @Test
    fun `test0 - class Dockable is interface or not`() {
        uml.isInterface(true)
    }

    @Test
    fun `test1 - 'Dockable' extends other classe(s)`() {
        uml.extendNothing()
    }

    @Test
    fun `test2 - 'Dockable' has attribute(s)`() {
        uml.attributeNumber(0, conformity = Conformity.STRONG)
    }

    @Test
    fun `test3 - 'Dockable' has method(s)`() {
        uml.methodNumber(0, conformity = Conformity.STRONG)
    }


}
