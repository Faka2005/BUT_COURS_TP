package testexo2

import exo2.TypeVaisseau
import exo2.Vaisseau
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for Vaisseau *****/

class TestUmlVaisseau {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Vaisseau::class)
    }

    @Test
    fun `test0 - class Vaisseau is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class Vaisseau is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Vaisseau' extends other classe(s)`() {
        uml.extend("Dockable")
    }

    @Test
    fun `test3 - 'Vaisseau' has a constructor 1`() {
        uml.constructorCheck(
            paramsTypesAndNullability = arrayOf(
                Triple("nom", String::class, false),
                Triple("type", TypeVaisseau::class, false)
            )
        )
    }

    @Test
    fun `test4 - 'Vaisseau' has attribute(s)`() {
        uml.attributeNumber(2, conformity = Conformity.STRONG)
    }

    @Test
    fun `test5 - 'Vaisseau' has an attribute 'nom'`() {
        uml.attributeCheck(
            "nom",
            String::class,
            attIsNullable = false,
            attVisibility = KVisibility.PUBLIC,
            attIsAbstract = false
        )
    }

    @Test
    fun `test6 - 'Vaisseau' has an attribute 'type{readOnly}'`() {
        uml.attributeCheck(
            "type",
            TypeVaisseau::class,
            attIsNullable = false,
            attVisibility = KVisibility.PUBLIC,
            attIsAbstract = false
        )
    }

    @Test
    fun `test7 - 'Vaisseau' has method(s)`() {
        uml.methodNumber(3, conformity = Conformity.STRONG)
    }

    @Test
    fun `test8 - 'Vaisseau' has a method 'renommer'`() {
        uml.methodCheck("renommer", methParamTypesAndNullability = arrayOf(Triple("nouveauNom", String::class, false)))
    }

    @Test
    fun `test9 - 'Vaisseau' has a method 'tonnage'`() {
        uml.methodCheck("tonnage", returnType = Int::class, returnTypeIsNullable = false)
    }

    @Test
    fun `test10 - 'Vaisseau' has a method 'equals'`() {
        uml.methodCheck(
            "equals",
            returnType = Boolean::class,
            returnTypeIsNullable = false,
            methParamTypesAndNullability = arrayOf(Triple("other", Any::class, true)),
            methIsOverride = true,
            methIsOpen = true
        )
    }


}
