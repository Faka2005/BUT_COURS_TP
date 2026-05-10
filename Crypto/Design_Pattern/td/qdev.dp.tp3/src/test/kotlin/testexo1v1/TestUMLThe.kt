package testexo1v1

import exo1.v1.Cafe
import exo1.v1.The
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker


/***** Generated JUnit/UMLChecker Test Cases for The *****/

class TestUMLThe {

lateinit var uml : UMLChecker

@BeforeEach
fun init() {
    uml = UMLChecker.create(The::class)
}

@Test
fun `test0 - class The is abstract or not`() {
    uml.isAbstract(false)
}

@Test
fun `test1 - class The is open or not`() {
    uml.isOpen(false)
}

@Test
fun `test2 - 'The' extends other classe(s)`() {
    uml.extend("BoissonEauChaude")
}

@Test
fun `test3 - 'The' has attribute(s)`() {
    uml.attributeNumber(0)
}

@Test
fun `test4 - 'The' has method(s)`() {
    uml.methodNumber(2)
}

@Test
fun `test5 - 'The' has a method 'preparer'`() {
    uml.methodCheck("preparer", String::class, isOpenOrOverride=true)
}

@Test
fun `test6 - 'The' has a method 'ajouterSupplement'`() {
    uml.methodCheck("ajouterSupplement", String::class, isOpenOrOverride=true)
}

    @Test
    fun construct() {
        uml.constructorCheck()
    }

}