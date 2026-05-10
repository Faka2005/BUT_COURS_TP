package testexo1

import exo1.EmailValidator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for EmailValidator *****/

class TestUMLEmailValidator {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(EmailValidator::class)
    }

    @Test
    fun `test0 - class EmailValidator is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class EmailValidator is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'EmailValidator' extends other classe(s)`() {
        uml.extend("Validator")
    }

    @Test
    fun `test3 - 'EmailValidator' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'EmailValidator' has method(s)`() {
        uml.methodNumber(1)
    }

    @Test
    fun `test5 - 'EmailValidator' has a method 'validate'`() {
        uml.methodCheck(
            "validate",
            Boolean::class,
            methParamAndTypes = arrayOf(Pair("value", String::class)),
            isOpenOrOverride = true
        )
    }


}
