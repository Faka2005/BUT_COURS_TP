package testexo1

import exo1.Validator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for Validator *****/

class TestUMLValidator {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Validator::class)
    }

    @Test
    fun `test0 - class Validator is abstract or not`() {
        uml.isAbstract(true)
    }

    @Test
    fun `test1 - class Validator is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Validator' extends other classe(s)`() {
        uml.extendNothing()
    }

    @Test
    fun `test3 - 'Validator' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'Validator' has method(s)`() {
        uml.methodNumber(1)
    }

    @Test
    fun `test5 - 'Validator' has a method 'validate'`() {
        uml.methodCheck(
            "validate",
            Boolean::class,
            methParamAndTypes = arrayOf(Pair("value", String::class)),
            isAbstract = true
        )
    }


}
