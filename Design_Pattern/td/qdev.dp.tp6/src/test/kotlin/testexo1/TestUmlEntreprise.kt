package testexo1

import exo1.Departement
import exo1.Entite
import exo1.Entreprise
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for Entreprise *****/

class TestUmlEntreprise {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Entreprise::class)
    }

    @Test
    fun `test0 - class Entreprise is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class Entreprise is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Entreprise' extends other classe(s)`() {
        uml.extend("Salariable", "Ajoutable")
    }

    @Test
    fun `test3 - 'Entreprise' has a constructor 1`() {
        uml.constructorCheck(paramsTypesAndNullability = arrayOf(Triple("principal", Departement::class, false)))
    }

    @Test
    fun `test4 - 'Entreprise' has attribute(s)`() {
        uml.attributeNumber(1, conformity = Conformity.STRONG)
    }


    @Test
    fun `test5 - 'Entreprise' has an attribute 'principal'`() {
        uml.attributeCheck("principal", Departement::class, attIsNullable = false, attIsAbstract = false)
    }

    @Test
    fun `test5 - 'Entreprise' has method(s)`() {
        uml.methodNumber(3, conformity = Conformity.WEAK)
    }

    @Test
    fun `test6 - 'Entreprise' has a method 'ajouter'`() {
        uml.methodCheck(
            "ajouter",
            methParamTypesAndNullability = arrayOf(Triple("entite", Entite::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test7 - 'Entreprise' has a method 'supprimer'`() {
        uml.methodCheck(
            "supprimer",
            methParamTypesAndNullability = arrayOf(Triple("entite", Entite::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test8 - 'Entreprise' has a method 'salaire'`() {
        uml.methodCheck(
            "salaire",
            returnType = Double::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }


}
