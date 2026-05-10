package testexo1

import exo1.Employe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for Employe *****/

class TestUmlEmploye {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Employe::class)
    }

    @Test
    fun `test0 - class Employe is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class Employe is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Employe' extends other classe(s)`() {
        uml.extend("Entite")
    }

    @Test
    fun `test3 - 'Employe' has a constructor 1`() {
        uml.constructorCheck(
            paramsTypesAndNullability = arrayOf(
                Triple("nom", String::class, false),
                Triple("salaire", Double::class, false)
            )
        )
    }

    @Test
    fun `test4 - 'Employe' has attribute(s)`() {
        uml.attributeNumber(2, conformity = univ.nantes.umlchecker.Conformity.STRONG)
    }

    @Test
    fun `test5 - 'Employe' has an attribute 'nom'`() {
        uml.attributeCheck("nom", String::class, attIsNullable = false, attIsAbstract = false)
    }

    @Test
    fun `test6 - 'Employe' has an attribute 'salaire'`() {
        uml.attributeCheck("salaire", Double::class, attIsNullable = false, attIsAbstract = false)
    }

    @Test
    fun `test7 - 'Employe' has method(s)`() {
        uml.methodNumber(1, conformity = univ.nantes.umlchecker.Conformity.STRONG)
    }

    @Test
    fun `test8 - 'Employe' has a method 'salaire'`() {
        uml.methodCheck(
            "salaire",
            returnType = Double::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }


}
