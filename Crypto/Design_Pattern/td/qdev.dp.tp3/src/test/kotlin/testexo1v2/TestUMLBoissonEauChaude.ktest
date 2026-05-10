package testexo1v2

import exo1.v2.BoissonEauChaude
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

class TestUMLBoissonEauChaude {

     val uml = UMLChecker.create(BoissonEauChaude::class)

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
        uml.isAbstract(true)
    }

    @Test
    fun open() {
        uml.isOpen(false)
    }

    @Test
    fun methNumber() {
        uml.methodNumber(1)
    }

    @Test
    fun construct() {
        uml.constructorCheck()
    }

    @Test
    fun `test faireBouillir`() {
        uml.methodCheck("faireBouillir", String::class, isOpenOrOverride=true)
    }


}