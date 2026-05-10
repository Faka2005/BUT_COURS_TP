package testexo2

import exo2.LIBRE
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for LIBRE *****/

class TestUmlLIBRE {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(LIBRE::class)
    }

    @Test
    fun `test0 - class LIBRE is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class LIBRE is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'LIBRE' extends other classe(s)`() {
        uml.extend("Dockable")
    }

    @Test
    fun `test3 - 'LIBRE' has attribute(s)`() {
        uml.attributeNumber(0, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'LIBRE' has method(s)`() {
        uml.methodNumber(0, conformity = Conformity.STRONG)
    }


}
