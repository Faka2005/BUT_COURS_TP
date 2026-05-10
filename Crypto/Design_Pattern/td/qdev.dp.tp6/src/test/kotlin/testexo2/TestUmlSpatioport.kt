package testexo2

import exo2.Dock
import exo2.Spatioport
import exo2.Vaisseau
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import univ.nantes.UMLChecker
import univ.nantes.umlchecker.Conformity

/***** Generated JUnit/UMLChecker Test Cases for Spatioport *****/

class TestUmlSpatioport {

    lateinit var uml: UMLChecker

    @BeforeEach
    fun init() {
        uml = UMLChecker.create(Spatioport::class)
    }

    @Test
    fun `test0 - class Spatioport is abstract or not`() {
        uml.isAbstract(false)
    }

    @Test
    fun `test1 - class Spatioport is open or not`() {
        uml.isOpen(false)
    }

    @Test
    fun `test2 - 'Spatioport' extends other classe(s)`() {
        uml.extend("UsageSpatioport")
    }

    @Test
    fun `test3 - 'Spatioport' has a constructor 1`() {
        uml.constructorCheck(paramsTypesAndNullability = arrayOf(Triple("nbPlaces", Int::class, false)))
    }

    @Test
    fun `test4 - 'Spatioport' has attribute(s)`() {
        uml.attributeNumber(1, conformity = Conformity.STRONG)
    }

    @Test
    fun `test5 - 'Spatioport' has an attribute 'dock'`() {
        uml.attributeCheck("dock", Dock::class, attIsNullable = false, attIsAbstract = false)
    }

    @Test
    fun `test6 - 'Spatioport' has method(s)`() {
        uml.methodNumber(15, conformity = Conformity.STRONG)
    }

    @Test
    fun `test7 - 'Spatioport' has a method 'nbPlacesTotales'`() {
        uml.methodCheck(
            "nbPlacesTotales",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test8 - 'Spatioport' has a method 'nbPlacesLibres'`() {
        uml.methodCheck(
            "nbPlacesLibres",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test9 - 'Spatioport' has a method 'emplacementInutilisable'`() {
        uml.methodCheck(
            "emplacementInutilisable",
            methParamTypesAndNullability = arrayOf(Triple("place", Int::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test10 - 'Spatioport' has a method 'reparerEmplacement'`() {
        uml.methodCheck(
            "reparerEmplacement",
            methParamTypesAndNullability = arrayOf(Triple("place", Int::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test11 - 'Spatioport' has a method 'nbPlacesInutilisables'`() {
        uml.methodCheck(
            "nbPlacesInutilisables",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test12 - 'Spatioport' has a method 'estAmarreA'`() {
        uml.methodCheck(
            "estAmarreA",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methParamTypesAndNullability = arrayOf(Triple("vaisseau", Vaisseau::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test13 - 'Spatioport' has a method 'amarrer'`() {
        uml.methodCheck(
            "amarrer",
            methParamTypesAndNullability = arrayOf(Triple("vaisseau", Vaisseau::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test14 - 'Spatioport' has a method 'nbPlacesOccupees'`() {
        uml.methodCheck(
            "nbPlacesOccupees",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test15 - 'Spatioport' has a method 'tonnagesTotalAmarres'`() {
        uml.methodCheck(
            "tonnagesTotalAmarres",
            returnType = Int::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test16 - 'Spatioport' has a method 'desamarrer'`() {
        uml.methodCheck(
            "desamarrer",
            methParamTypesAndNullability = arrayOf(Triple("vaisseau", Vaisseau::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test17 - 'Spatioport' has a method 'amarrerA'`() {
        uml.methodCheck(
            "amarrerA",
            methParamTypesAndNullability = arrayOf(
                Triple("vaisseau", Vaisseau::class, false),
                Triple("place", Int::class, false)
            ),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test18 - 'Spatioport' has a method 'desamarrerDe'`() {
        uml.methodCheck(
            "desamarrerDe",
            returnType = Vaisseau::class,
            returnTypeIsNullable = false,
            methParamTypesAndNullability = arrayOf(Triple("place", Int::class, false)),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test19 - 'Spatioport' has a method 'amarrerAuPlusPresDe'`() {
        uml.methodCheck(
            "amarrerAuPlusPresDe",
            methParamTypesAndNullability = arrayOf(
                Triple("vaisseau", Vaisseau::class, false),
                Triple("place", Int::class, false)
            ),
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test20 - 'Spatioport' has a method 'vaisseauxTriesParNom'`() {
        uml.methodCheck(
            "vaisseauxTriesParNom",
            returnType = List::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }

    @Test
    fun `test21 - 'Spatioport' has a method 'vaisseauxTriesParTonnageDecroissantPuisNom'`() {
        uml.methodCheck(
            "vaisseauxTriesParTonnageDecroissantPuisNom",
            returnType = List::class,
            returnTypeIsNullable = false,
            methIsOverride = true,
            methIsOpen = true
        )
    }


}
