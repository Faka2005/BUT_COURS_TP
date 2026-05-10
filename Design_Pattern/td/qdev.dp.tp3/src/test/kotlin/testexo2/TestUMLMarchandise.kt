package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

	/***** Generated JUnit/UMLChecker Test Cases for Marchandise *****/

class TestUMLMarchandise {

	lateinit var uml : UMLChecker

	@BeforeEach
	fun init() {
		uml = UMLChecker.create(Marchandise::class)
	}

	@Test
	fun `test0 - class Marchandise is abstract or not`() {
		uml.isAbstract(false)
	}

	@Test
	fun `test1 - class Marchandise is open or not`() {
		uml.isOpen(false)
	}

	@Test
	fun `test2 - 'Marchandise' extends other classe(s)`() {
		uml.extendNothing()
	}

	@Test
	fun `test3 - 'Marchandise' has a constructor`() {
		uml.constructorCheck(paramsAndTypes=arrayOf(Pair("poids", Double::class), Pair("volume", Double::class)))
	}

	@Test
	fun `test4 - 'Marchandise' has attribute(s)`() {
		uml.attributeNumber(2)
	}

	@Test
	fun `test5 - 'Marchandise' has an attribute 'poids'`() {
		uml.attributeCheck("poids", Double::class)
	}

	@Test
	fun `test6 - 'Marchandise' has an attribute 'volume'`() {
		uml.attributeCheck("volume", Double::class)
	}

	@Test
	fun `test7 - 'Marchandise' has method(s)`() {
		uml.methodNumber(2)
	}

	@Test
	fun `test8 - 'Marchandise' has a method 'donneVolume'`() {
		uml.methodCheck("donneVolume", Double::class)
	}

	@Test
	fun `test9 - 'Marchandise' has a method 'donnePoids'`() {
		uml.methodCheck("donnePoids", Double::class)
	}


}
