package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

	/***** Generated JUnit/UMLChecker Test Cases for Cargaison *****/

class TestUMLCargaison {

	lateinit var uml : UMLChecker

	@BeforeEach
	fun init() {
		uml = UMLChecker.create(Cargaison::class)
	}

	@Test
	fun `test0 - class Cargaison is abstract or not`() {
		uml.isAbstract(true)
	}

	@Test
	fun `test1 - class Cargaison is open or not`() {
		uml.isOpen(false)
	}

	@Test
	fun `test2 - 'Cargaison' extends other classe(s)`() {
		uml.extendNothing()
	}

	@Test
	fun `test3 - 'Cargaison' has a constructor`() {
		uml.constructorCheck(paramsAndTypes=arrayOf(Pair("distance", Int::class)), visibility=KVisibility.PROTECTED)
	}

	@Test
	fun `test4 - 'Cargaison' has attribute(s)`() {
		uml.attributeNumber(3)
	}

	@Test
	fun `test5 - 'Cargaison' has an attribute 'distance'`() {
		uml.attributeCheck("distance", Int::class)
	}

	@Test
	fun `test6 - 'Cargaison' has an attribute 'encombrementActuel'`() {
		uml.attributeCheck("encombrementActuel", Double::class)
	}

	@Test
	fun `test9 - 'Cargaison' has method(s)`() {
		uml.methodNumber(6)
	}

	@Test
	fun `test10 - 'Cargaison' has a method 'ajouter'`() {
		uml.methodCheck("ajouter", Boolean::class, methParamAndTypes=arrayOf(Pair("marchandise", Marchandise::class)))
	}

	@Test
	fun `test11 - 'Cargaison' has a method 'rechercher'`() {
		uml.methodCheck("rechercher", Int::class, methParamAndTypes=arrayOf(Pair("marchandise", Marchandise::class)))
	}

	@Test
	fun `test12 - 'Cargaison' has a method 'cout'`() {
		uml.methodCheck("cout", Double::class)
	}

	@Test
	fun `test13 - 'Cargaison' has a method 'limite'`() {
		uml.methodCheck("limite", Double::class, isAbstract=true, methVisibility=KVisibility.PROTECTED)
	}

	@Test
	fun `test14 - 'Cargaison' has a method 'facteur'`() {
		uml.methodCheck("facteur", Int::class, methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}

	@Test
	fun `test15 - 'Cargaison' has a method 'encombrement'`() {
		uml.methodCheck("encombrement", Double::class, methParamAndTypes=arrayOf(Pair("marchandise", Marchandise::class)), methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}


}
