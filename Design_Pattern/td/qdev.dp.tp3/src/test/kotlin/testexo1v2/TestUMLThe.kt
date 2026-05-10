package testexo1v2

import exo1.v2.The
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
class TestUMLThe {

     val uml = UMLChecker.create(The::class)

    @Test
    fun extend() {
        uml.extend("BoissonEauChaude")
    }

    @Test
    fun attNumber() {
        uml.attributeNumber(0)
    }

    @Test
    fun abstract() {
        uml.isAbstract(false)
    }

    @Test
    fun open() {
        uml.isOpen(false)
    }

    @Test
    fun methNumber() {
        uml.methodNumber(2)
    }

    @Test
    fun construct() {
        uml.constructorCheck()
    }

    @Test
    fun `test preparer`() {
        uml.methodCheck("preparer", String::class, isAbstract = false, isOpenOrOverride = true)
    }

    @Test
    fun `test ajouterSupplement`() {
        uml.methodCheck("ajouterSupplement", String::class, isAbstract = false, isOpenOrOverride = true)
    }

}