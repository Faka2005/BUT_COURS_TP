package testexo1

import exo1.NumericValidator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for NumericValidator *****/

class TestUMLNumericValidator {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(NumericValidator::class)
    }

    @Test
    fun `test0 - class NumericValidator is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class NumericValidator is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'NumericValidator' extends other classe(s)`() {
        uml.extend("Validator")
    }

    @Test
    fun `test3 - 'NumericValidator' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'NumericValidator' has method(s)`() {
        uml.methodNumber(1)
    }

    @Test
    fun `test5 - 'NumericValidator' has a method 'validate'`() {
        uml.methodCheck(
            "validate",
            Boolean::class,
            methParamAndTypes = arrayOf(Pair("value", String::class)),
            isOpenOrOverride = true
        )
    }


}
