package testexo1

import exo1.FormField
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TestUsageFormField {

    lateinit var formField: FormField

    @ParameterizedTest(name = "FormField with value {0} is valid ? {1}")
    @CsvSource(
        "'batman', 1",
        "'joker3' , 1",
        "'a' , 1",
        "'0', 1",
        "'9', 1",
        "'12345', 1",
        "'12345678', 1",
        "'123456789', 1",
        "'b@tman' , 0",
        "'batman@' , 0",
        "'batman@gotham.com' , 0",
        "'batman.gotham@com' , 0",
        "'joker.2' , 0",
        "'@.', 0",
        "'.@', 0",
        "'' , 0",
    )
    fun testValidUsernameField(value : String, expected : Int) {
        formField = FormField(exo1.UsernameValidator())
        formField.setText(value)
        assertEquals("FormField with value $value", formField.getInfo())
        if (expected==1)
            assertTrue(formField.isTextValid())
        else
            assertFalse(formField.isTextValid())
    }

    @ParameterizedTest(name = "FormField with value {0} is valid ? {1}")
    @CsvSource(
        "'batman', 0",
        "'joker3' , 0",
        "'a' , 0",
        "'0', 1",
        "'9', 1",
        "'12345', 1",
        "'12345678', 1",
        "'123456789', 1",
        "'b@tman' , 0",
        "'batman@' , 0",
        "'batman@gotham.com' , 0",
        "'batman.gotham@com' , 0",
        "'joker.2' , 0",
        "'@.', 0",
        "'.@', 0",
        "'' , 0",
    )
    fun testValidNumericField(value : String, expected : Int) {
        formField = FormField(exo1.NumericValidator())
        formField.setText(value)
        assertEquals("FormField with value $value", formField.getInfo())
        if (expected==1)
            assertTrue(formField.isTextValid())
        else
            assertFalse(formField.isTextValid())
    }

    @ParameterizedTest(name = "FormField with value {0} is valid ? {1}")
    @CsvSource(
        "'batman', 0",
        "'joker3' , 0",
        "'a' , 0",
        "'0', 0",
        "'9', 0",
        "'12345', 0",
        "'12345678', 1",
        "'123456789', 1",
        "'b@tman' , 0",
        "'batman@' , 0",
        "'batman@gotham.com' , 1",
        "'batman.gotham@com' , 1",
        "'joker.2' , 0",
        "'@.', 0",
        "'.@', 0",
        "'' , 0",
    )
    fun testValidPasswordField(value : String, expected : Int) {
        formField = FormField(exo1.PasswordValidator())
        formField.setText(value)
        assertEquals("FormField with value $value", formField.getInfo())
        if (expected==1)
            assertTrue(formField.isTextValid())
        else
            assertFalse(formField.isTextValid())
    }

    @ParameterizedTest(name = "FormField with value {0} is valid ? {1}")
    @CsvSource(
        "'batman', 0",
        "'joker3' , 0",
        "'a' , 0",
        "'0', 0",
        "'9', 0",
        "'12345', 0",
        "'12345678', 0",
        "'123456789', 0",
        "'b@tman' , 0",
        "'batman@' , 0",
        "'batman@gotham.com' , 1",
        "'batman.gotham@com' , 1",
        "'joker.2' , 0",
        "'@.', 1",
        "'.@', 1",
        "'' , 0",
    )
    fun testValidEmailField(value : String, expected : Int) {
        formField = FormField( exo1.EmailValidator())
        formField.setText(value)
        assertEquals("FormField with value $value", formField.getInfo())
        if (expected==1)
            assertTrue(formField.isTextValid())
        else
            assertFalse(formField.isTextValid())
    }

    @ParameterizedTest(name = "FormField with value {0} is valid ? {1}")
    @CsvSource(
        "'batman', 1",
        "'joker3' , 1",
        "'a' , 1",
        "'0', 1",
        "'9', 1",
        "'12345', 1",
        "'12345678', 1",
        "'123456789', 1",
        "'b@tman' , 0",
        "'batman@' , 0",
        "'batman@gotham.com' , 0",
        "'batman.gotham@com' , 0",
        "'joker.2' , 0",
        "'@.', 0",
        "'.@', 0",
        "'' , 0",
    )
    fun testValidUsernameFieldFactory(value : String, expected : Int) {
        formField = FormField.buildUsernameField()
        formField.setText(value)
        assertEquals("FormField with value $value", formField.getInfo())
        if (expected==1)
            assertTrue(formField.isTextValid())
        else
            assertFalse(formField.isTextValid())
    }

    @ParameterizedTest(name = "FormField with value {0} is valid ? {1}")
    @CsvSource(
        "'batman', 0",
        "'joker3' , 0",
        "'a' , 0",
        "'0', 1",
        "'9', 1",
        "'12345', 1",
        "'12345678', 1",
        "'123456789', 1",
        "'b@tman' , 0",
        "'batman@' , 0",
        "'batman@gotham.com' , 0",
        "'batman.gotham@com' , 0",
        "'joker.2' , 0",
        "'@.', 0",
        "'.@', 0",
        "'' , 0",
    )
    fun testValidNumericFieldFactory(value : String, expected : Int) {
        formField = FormField.buildNumericField()
        formField.setText(value)
        assertEquals("FormField with value $value", formField.getInfo())
        if (expected==1)
            assertTrue(formField.isTextValid())
        else
            assertFalse(formField.isTextValid())
    }

    @ParameterizedTest(name = "FormField with value {0} is valid ? {1}")
    @CsvSource(
        "'batman', 0",
        "'joker3' , 0",
        "'a' , 0",
        "'0', 0",
        "'9', 0",
        "'12345', 0",
        "'12345678', 1",
        "'123456789', 1",
        "'b@tman' , 0",
        "'batman@' , 0",
        "'batman@gotham.com' , 1",
        "'batman.gotham@com' , 1",
        "'joker.2' , 0",
        "'@.', 0",
        "'.@', 0",
        "'' , 0",
    )
    fun testValidPasswordFieldFactory(value : String, expected : Int) {
        formField = FormField.buildPasswordField()
        formField.setText(value)
        assertEquals("FormField with value $value", formField.getInfo())
        if (expected==1)
            assertTrue(formField.isTextValid())
        else
            assertFalse(formField.isTextValid())
    }

    @ParameterizedTest(name = "FormField with value {0} is valid ? {1}")
    @CsvSource(
        "'batman', 0",
        "'joker3' , 0",
        "'a' , 0",
        "'0', 0",
        "'9', 0",
        "'12345', 0",
        "'12345678', 0",
        "'123456789', 0",
        "'b@tman' , 0",
        "'batman@' , 0",
        "'batman@gotham.com' , 1",
        "'batman.gotham@com' , 1",
        "'joker.2' , 0",
        "'@.', 1",
        "'.@', 1",
        "'' , 0",
    )
    fun testValidEmailFieldFactory(value : String, expected : Int) {
        formField = FormField.buildEmailField()
        formField.setText(value)
        assertEquals("FormField with value $value", formField.getInfo())
        if (expected==1)
            assertTrue(formField.isTextValid())
        else
            assertFalse(formField.isTextValid())
    }




}