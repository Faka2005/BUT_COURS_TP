package testexo1

import exo1.Salariable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for Salariable *****/

class TestUmlSalariable {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Salariable::class)
    }

    @Test
    fun `test0 - class Salariable is interface or not`() {
        uml.isInterface(true)
    }

    @Test
    fun `test1 - 'Salariable' extends other classe(s)`() {
        uml.extendNothing()
    }

    @Test
    fun `test2 - 'Salariable' has attribute(s)`() {
        uml.attributeNumber(0, conformity = Conformity.STRONG)
    }

    @Test
    fun `test3 - 'Salariable' has method(s)`() {
        uml.methodNumber(1, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'Salariable' has a method 'salaire'`() {
        uml.methodCheck("salaire", returnType = Double::class, returnTypeIsNullable = false, methIsAbstract = true)
    }


}
