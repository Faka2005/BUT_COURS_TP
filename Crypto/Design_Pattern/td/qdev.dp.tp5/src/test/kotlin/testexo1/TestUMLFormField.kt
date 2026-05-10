package testexo1

import exo1.FormField
import exo1.Validator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for FormField *****/

class TestUMLFormField {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(FormField::class)
    }

    @Test
    fun `test0 - class FormField is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class FormField is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'FormField' extends other classe(s)`() {
        uml.extend("JTextField")
    }

    @Test
    fun `test3 - 'FormField' has a constructor`() {
        uml.constructorCheck(
            paramsAndTypes = arrayOf(
                Pair("validator", Validator::class),
                Pair("text", String::class)
                ), visibility = KVisibility.PUBLIC
        )
    }

    @Test
    fun `test4 - 'FormField' has attribute(s)`() {
        uml.attributeNumber(1)
    }

    @Test
    fun `test11 - 'FormField' has an attribute 'validator'`() {
        uml.attributeCheck("validator", Validator::class)
    }

    @Test
    fun `test12 - 'FormField' has method(s)`() {
        uml.methodNumber(3, strict = false)
    }


    @Test
    fun `test15 - 'FormField' has a method 'isTextValid'`() {
        uml.methodCheck("isTextValid", Boolean::class)
    }


}
