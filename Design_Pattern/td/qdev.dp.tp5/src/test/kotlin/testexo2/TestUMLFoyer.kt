package testexo2

import exo2.Foyer
import exo2.SITUATION
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for Foyer *****/

class TestUMLFoyer {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Foyer::class)
    }

    @Test
    fun `test0 - class Foyer is abstract or not`() {
        uml.isAbstract(false)
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
            )
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
    fun `test9 - 'Foyer' has an attribute 'situation'`() {
        uml.attributeCheck("situation", SITUATION::class, KVisibility.PUBLIC)
    }

    @Test
    fun `test8 - 'Foyer' has method(s)`() {
        uml.methodNumber(0)
    }


}
