package testexo1v2

import exo1.v2.Cacao
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
class TestUMLCacao {

     val uml = UMLChecker.create(Cacao::class)

    @Test
    fun extend() {
        uml.extend("BoissonChaude")
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
        uml.methodNumber(3)
    }

    @Test
    fun construct() {
        uml.constructorCheck()
    }

    @Test
    fun `test faireBouillir`() {
        uml.methodCheck("faireBouillir", String::class, isOpenOrOverride=true)
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