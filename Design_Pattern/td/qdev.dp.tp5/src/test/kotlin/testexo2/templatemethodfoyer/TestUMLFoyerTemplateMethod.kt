package testexo2.templatemethodfoyer

import exo2.SITUATION
import exo2.templatemethodfoyer.Foyer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for Foyer *****/

class TestUMLFoyerTemplateMethod {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Foyer::class)
    }

    @Test
    fun `test0 - class Foyer is abstract or not`() {
        uml.isAbstract(true)
    }

    @Test
    fun `test1 - class Foyer is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Foyer' extends other classe(s)`() {
        uml.extendNothing()
    }

    @Test
    fun `test3 - 'Foyer' has a constructor`() {
        uml.constructorCheck(
            paramsAndTypes = arrayOf(
                Pair("revenuAnnuel", Double::class),
                Pair("loyerMensuel", Double::class),
                Pair("situation", SITUATION::class),
                Pair("nbEnfants", Int::class)
            ), visibility = KVisibility.PROTECTED
        )
    }

    @Test
    fun `test4 - 'Foyer' has attribute(s)`() {
        uml.attributeNumber(4)
    }

    @Test
    fun `test5 - 'Foyer' has an attribute 'revenuAnnuel'`() {
        uml.attributeCheck("revenuAnnuel", Double::class, KVisibility.PUBLIC)
    }

    @Test
    fun `test6 - 'Foyer' has an attribute 'loyerMensuel'`() {
        uml.attributeCheck("loyerMensuel", Double::class, KVisibility.PUBLIC)
    }

    @Test
    fun `test7 - 'Foyer' has an attribute 'nbEnfants'`() {
        uml.attributeCheck("nbEnfants", Int::class, KVisibility.PUBLIC)
    }

    @Test
    fun `test71 - 'Foyer' has an attribute 'situation'`() {
        uml.attributeCheck("situation", SITUATION::class, KVisibility.PUBLIC)
    }

    @Test
    fun `test8 - 'Foyer' has method(s)`() {
        uml.methodNumber(5)
    }

    @Test
    fun `test9 - 'Foyer' has a method 'pourcentage'`() {
        uml.methodCheck("pourcentage", Double::class, isAbstract = true)
    }

    @Test
    fun `test10 - 'Foyer' has a method 'primeEnfants'`() {
        uml.methodCheck("primeEnfants", Double::class, isOpenOrOverride = true)
    }

    @Test
    fun `test11 - 'Foyer' has a method 'taux'`() {
        uml.methodCheck("taux", Double::class, isAbstract = true)
    }

    @Test
    fun `test12 - 'Foyer' has a method 'nbLoyers'`() {
        uml.methodCheck("nbLoyers", Double::class, isAbstract = true)
    }

    @Test
    fun `test13 - 'Foyer' has a method 'modificateur'`() {
        uml.methodCheck("modificateur", Double::class, isOpenOrOverride = true)
    }


}
