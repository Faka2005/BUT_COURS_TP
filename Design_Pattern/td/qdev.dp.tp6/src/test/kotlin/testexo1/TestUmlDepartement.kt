package testexo1

import exo1.Departement
import exo1.Entite
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for Departement *****/

class TestUmlDepartement {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Departement::class)
    }

    @Test
    fun `test0 - class Departement is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class Departement is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Departement' extends other classe(s)`() {
        uml.extend("Ajoutable", "Entite")
    }

    @Test
    fun `test3 - 'Departement' has a constructor 1`() {
        uml.constructorCheck(paramsTypesAndNullability = arrayOf())
    }

    @Test
    fun `test4 - 'Departement' has attribute(s)`() {
        uml.attributeNumber(1, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'Departement' has an attribute 'elements'`() {
        uml.attributeCheck("elements", MutableList::class, attIsNullable = false, attIsAbstract = false)
    }

    @Test
    fun `test6 - 'Departement' has method(s)`() {
        uml.methodNumber(3, conformity = Conformity.WEAK)
    }

    @Test
    fun `test7 - 'Departement' has a method 'ajouter'`() {
        uml.methodCheck(
            "ajouter",
            methParamTypesAndNullability = arrayOf(Triple("entite", Entite::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test8 - 'Departement' has a method 'supprimer'`() {
        uml.methodCheck(
            "supprimer",
            methParamTypesAndNullability = arrayOf(Triple("entite", Entite::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test9 - 'Departement' has a method 'salaire'`() {
        uml.methodCheck(
            "salaire",
            returnType = Double::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }


}
