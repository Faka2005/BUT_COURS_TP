package testexo1

import exo1.Ajoutable
import exo1.Entite
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for Ajoutable *****/

class TestUmlAjoutable {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Ajoutable::class)
    }

    @Test
    fun `test0 - class Ajoutable is interface or not`() {
        uml.isInterface(true)
    }

    @Test
    fun `test1 - 'Ajoutable' extends other classe(s)`() {
        uml.extendNothing()
    }

    @Test
    fun `test2 - 'Ajoutable' has attribute(s)`() {
        uml.attributeNumber(0, conformity = Conformity.STRONG)
    }

    @Test
    fun `test3 - 'Ajoutable' has method(s)`() {
        uml.methodNumber(2, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'Ajoutable' has a method 'ajouter'`() {
        uml.methodCheck(
            "ajouter",
            methParamTypesAndNullability = arrayOf(Triple("entite", Entite::class, false)),
            methIsAbstract = true
        )
    }

    @Test
    fun `test5 - 'Ajoutable' has a method 'supprimer'`() {
        uml.methodCheck(
            "supprimer",
            methParamTypesAndNullability = arrayOf(Triple("entite", Entite::class, false)),
            methIsAbstract = true
        )
    }


}
