package testexo2

import exo2.UsageSpatioport
import exo2.Vaisseau
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for UsageSpatioport *****/

class TestUmlUsageSpatioport {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(UsageSpatioport::class)
    }

    @Test
    fun `test0 - class UsageSpatioport is interface or not`() {
        uml.isInterface(true)
    }

    @Test
    fun `test1 - 'UsageSpatioport' extends other classe(s)`() {
        uml.extendNothing()
    }

    @Test
    fun `test2 - 'UsageSpatioport' has attribute(s)`() {
        uml.attributeNumber(0, conformity = Conformity.STRONG)
    }

    @Test
    fun `test4 - 'UsageSpatioport' has method(s)`() {
        uml.methodNumber(15, conformity = Conformity.STRONG)
    }

    @Test
    fun `test5 - 'UsageSpatioport' has a method 'nbPlacesTotales'`() {
        uml.methodCheck("nbPlacesTotales", returnType = Int::class, returnTypeIsNullable = false, methIsAbstract = true)
    }

    @Test
    fun `test6 - 'UsageSpatioport' has a method 'nbPlacesLibres'`() {
        uml.methodCheck("nbPlacesLibres", returnType = Int::class, returnTypeIsNullable = false, methIsAbstract = true)
    }

    @Test
    fun `test7 - 'UsageSpatioport' has a method 'emplacementInutilisable'`() {
        uml.methodCheck(
            "emplacementInutilisable",
            methParamTypesAndNullability = arrayOf(Triple("place", Int::class, false)),
            methIsAbstract = true
        )
    }

    @Test
    fun `test8 - 'UsageSpatioport' has a method 'reparerEmplacement'`() {
        uml.methodCheck(
            "reparerEmplacement",
            methParamTypesAndNullability = arrayOf(Triple("place", Int::class, false)),
            methIsAbstract = true
        )
    }

    @Test
    fun `test9 - 'UsageSpatioport' has a method 'nbPlacesInutilisables'`() {
        uml.methodCheck(
            "nbPlacesInutilisables",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methIsAbstract = true
        )
    }

    @Test
    fun `test10 - 'UsageSpatioport' has a method 'estAmarreA'`() {
        uml.methodCheck(
            "estAmarreA",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methParamTypesAndNullability = arrayOf(Triple("vaisseau", Vaisseau::class, false)),
            methIsAbstract = true
        )
    }

    @Test
    fun `test11 - 'UsageSpatioport' has a method 'amarrer'`() {
        uml.methodCheck(
            "amarrer",
            methParamTypesAndNullability = arrayOf(Triple("vaisseau", Vaisseau::class, false)),
            methIsAbstract = true
        )
    }

    @Test
    fun `test12 - 'UsageSpatioport' has a method 'nbPlacesOccupees'`() {
        uml.methodCheck(
            "nbPlacesOccupees",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methIsAbstract = true
        )
    }

    @Test
    fun `test13 - 'UsageSpatioport' has a method 'tonnagesTotalAmarres'`() {
        uml.methodCheck(
            "tonnagesTotalAmarres",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methIsAbstract = true
        )
    }

    @Test
    fun `test14 - 'UsageSpatioport' has a method 'desamarrer'`() {
        uml.methodCheck(
            "desamarrer",
            methParamTypesAndNullability = arrayOf(Triple("vaisseau", Vaisseau::class, false)),
            methIsAbstract = true
        )
    }

    @Test
    fun `test15 - 'UsageSpatioport' has a method 'amarrerA'`() {
        uml.methodCheck(
            "amarrerA",
            methParamTypesAndNullability = arrayOf(
                Triple("vaisseau", Vaisseau::class, false),
                Triple("place", Int::class, false)
            ),
            methIsAbstract = true
        )
    }

    @Test
    fun `test16 - 'UsageSpatioport' has a method 'desamarrerDe'`() {
        uml.methodCheck(
            "desamarrerDe",
            returnType = Vaisseau::class,
            returnTypeIsNullable = false,
            methParamTypesAndNullability = arrayOf(Triple("place", Int::class, false)),
            methIsAbstract = true
        )
    }

    @Test
    fun `test17 - 'UsageSpatioport' has a method 'amarrerAuPlusPresDe'`() {
        uml.methodCheck(
            "amarrerAuPlusPresDe",
            methParamTypesAndNullability = arrayOf(
                Triple("vaisseau", Vaisseau::class, false),
                Triple("place", Int::class, false)
            ),
            methIsAbstract = true
        )
    }

    @Test
    fun `test18 - 'UsageSpatioport' has a method 'vaisseauxTriesParNom'`() {
        uml.methodCheck(
            "vaisseauxTriesParNom",
            returnType = List::class,
            returnTypeIsNullable = false,
            methIsAbstract = true
        )
    }

    @Test
    fun `test19 - 'UsageSpatioport' has a method 'vaisseauxTriesParTonnageDecroissantPuisNom'`() {
        uml.methodCheck(
            "vaisseauxTriesParTonnageDecroissantPuisNom",
            returnType = List::class,
            returnTypeIsNullable = false,
            methIsAbstract = true
        )
    }
}
