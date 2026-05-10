package testexo1v2

import exo1.v2.BoissonChaude
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

class TestUMLBoissonChaude {

     val uml = UMLChecker.create(BoissonChaude::class)

    @Test
    fun extend() {
        uml.extendNothing()
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
        uml.methodNumber(5)
    }

    @Test
    fun construct() {
        uml.constructorCheck()
    }

    @Test
    fun `test suivreRecette`() {
        uml.methodCheck("suivreRecette", methParamAndTypes=arrayOf(Pair("supplément", Boolean::class)), returnType = String::class, isOpenOrOverride=false)
    }

    @Test
    fun `test preparer`() {
        uml.methodCheck("preparer", String::class, isAbstract = true)
    }

    @Test
    fun `test ajouterSupplement`() {
        uml.methodCheck("ajouterSupplement", String::class, isAbstract = true)
    }

    @Test
    fun `test faireBouillir`() {
        uml.methodCheck("faireBouillir", String::class, isAbstract = true)
    }

    @Test
    fun `test verserDansTasse`() {
        uml.methodCheck("verserDansTasse", String::class, isOpenOrOverride=false, methVisibility = KVisibility.PRIVATE)
    }


}