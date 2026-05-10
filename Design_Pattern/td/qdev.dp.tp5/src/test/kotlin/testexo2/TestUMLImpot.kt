package testexo2

import exo2.Impot
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for Impot *****/

class TestUMLImpot {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Impot::class)
    }

    @Test
    fun `test0 - class Impot is abstract or not`() {
        uml.isAbstract(true)
    }

    @Test
    fun `test1 - class Impot is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Impot' extends other classe(s)`() {
        uml.extendNothing()
    }

    @Test
    fun `test3 - 'Impot' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'Impot' has method(s)`() {
        uml.methodNumber(2)
    }

    @Test
    fun `test6 - 'Impot' has a method 'impotsSurLeRevenu'`() {
        uml.methodCheck("impotsSurLeRevenu", Int::class, isAbstract = true)
    }

    @Test
    fun `test7 - 'Impot' has a method 'taxeHabitation'`() {
        uml.methodCheck("taxeHabitation", Int::class, isAbstract = true)
    }


}
