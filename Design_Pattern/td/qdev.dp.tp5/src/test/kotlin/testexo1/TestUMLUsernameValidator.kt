package testexo1

import exo1.UsernameValidator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for UsernameValidator *****/

class TestUMLUsernameValidator {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(UsernameValidator::class)
    }

    @Test
    fun `test0 - class UsernameValidator is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class UsernameValidator is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'UsernameValidator' extends other classe(s)`() {
        uml.extend("Validator")
    }

    @Test
    fun `test3 - 'UsernameValidator' has attribute(s)`() {
        uml.attributeNumber(0)
    }

    @Test
    fun `test4 - 'UsernameValidator' has method(s)`() {
        uml.methodNumber(1)
    }

    @Test
    fun `test5 - 'UsernameValidator' has a method 'validate'`() {
        uml.methodCheck(
            "validate",
            Boolean::class,
            methParamAndTypes = arrayOf(Pair("value", String::class)),
            isOpenOrOverride = true
        )
    }


}
