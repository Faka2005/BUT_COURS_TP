package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity
import kotlin.reflect.KVisibility

/***** Generated JUnit/UMLChecker Test Cases for Dock *****/

class TestUmlDock {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Dock::class)
    }

    @Test
    fun `test0 - class Dock is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class Dock is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Dock' extends other classe(s)`() {
        uml.extendNothing()
    }

    @Test
    fun `test3 - 'Dock' has a constructor`() {
        uml.constructorCheck(paramsTypesAndNullability=arrayOf(Triple("size", Int::class, false), Triple("elements", Array::class, false)))
    }

    @Test
    fun `test4 - 'Dock' has attribute(s)`() {
        uml.attributeNumber(2, conformity = Conformity.STRONG)
    }

    @Test
    fun `test5 - 'Dock' has an attribute 'size'`() {
        uml.attributeCheck(
            "size",
            Int::class,
            attIsNullable = false,
            attVisibility = KVisibility.PUBLIC,
            attIsAbstract = false
        )
    }

    @Test
    fun `test6 - 'Dock' has an attribute 'elements'`() {
        uml.attributeCheck("elements", Array<Dockable>::class, attIsNullable = false, attIsAbstract = false)
    }

    @Test
    fun `test7 - 'Dock' has method(s)`() {
        uml.methodNumber(2, conformity = Conformity.STRONG)
    }

    @Test
    fun `test8 - 'Dock' has a method 'get'`() {
        uml.methodCheck(
            "get",
            returnType = Dockable::class,
            returnTypeIsNullable = false,
            methParamTypesAndNullability = arrayOf(Triple("index", Int::class, false))
        )
    }

    @Test
    fun `test9 - 'Dock' has a method 'set'`() {
        uml.methodCheck(
            "set",
            methParamTypesAndNullability = arrayOf(
                Triple("index", Int::class, false),
                Triple("vaisseau", Dockable::class, false)
            )
        )
    }


}
