package testexo1

import exo1.PasswordValidator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for PasswordValidator *****/

class TestUMLPasswordValidator {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(PasswordValidator::class)
    }

    @Test
    fun `test0 - class PasswordValidator is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class PasswordValidator is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'PasswordValidator' extends other classe(s)`() {
        uml.extend("Validator")
    }

    @Test
    fun `test3 - 'PasswordValidator' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'PasswordValidator' has method(s)`() {
        uml.methodNumber(1)
    }

    @Test
    fun `test5 - 'PasswordValidator' has a method 'validate'`() {
        uml.methodCheck(
            "validate",
            Boolean::class,
            methParamAndTypes = arrayOf(Pair("value", String::class)),
            isOpenOrOverride = true
        )
    }


}
