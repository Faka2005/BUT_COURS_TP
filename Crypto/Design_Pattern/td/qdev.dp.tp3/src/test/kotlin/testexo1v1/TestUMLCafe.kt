package testexo1v1

import exo1.v1.Cafe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for Cafe *****/

class TestUMLCafe {

lateinit var uml : UMLChecker

@BeforeEach
fun init() {
    uml = UMLChecker.create(Cafe::class)
}

@Test
fun `test0 - class Cafe is abstract or not`() {
    uml.isAbstract(false)
}

@Test
fun `test1 - class Cafe is open or not`() {
    uml.isOpen(false)
}

@Test
fun `test2 - 'Cafe' extends other classe(s)`() {
    uml.extend("BoissonEauChaude")
}

@Test
fun `test3 - 'Cafe' has attribute(s)`() {
    uml.attributeNumber(0)
}

@Test
fun `test4 - 'Cafe' has method(s)`() {
    uml.methodNumber(2)
}

@Test
fun `test5 - 'Cafe' has a method 'preparer'`() {
    uml.methodCheck("preparer", String::class, isOpenOrOverride=true)
}

@Test
fun `test6 - 'Cafe' has a method 'ajouterSupplement'`() {
    uml.methodCheck("ajouterSupplement", String::class, isOpenOrOverride=true)
}

    @Test
    fun construct() {
        uml.constructorCheck()
    }

}