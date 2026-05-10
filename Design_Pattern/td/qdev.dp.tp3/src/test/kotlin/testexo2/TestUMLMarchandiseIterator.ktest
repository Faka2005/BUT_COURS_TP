package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker

/***** Generated JUnit/UMLChecker Test Cases for Cargaison *****/

class TestUMLMarchandiseIterator {

	lateinit var uml : UMLChecker

	@BeforeEach
	fun init() {
		uml = UMLChecker.create(Cargaison.MarchandiseIterator::class)
	}

	@Test
	fun `test0 - class MarchandiseIterator is abstract or not`() {
		uml.isAbstract(false)
	}

	@Test
	fun `test1 - class MarchandiseIterator is open or not`() {
		uml.isOpen(false)
	}

	@Test
	fun `test2 - 'MarchandiseIterator' extends other classe(s)`() {
		uml.extend("Iterator")
	}

	@Test
	fun `test3 - 'MarchandiseIterator' has a constructor`() {
		uml.constructorCheck(paramsAndTypes=arrayOf(Pair("cargaison", Cargaison::class)))
	}

	@Test
	fun `test4 - 'MarchandiseIterator' has attribute(s)`() {
		uml.attributeNumber(3)
	}

	@Test
	fun `test5 - 'MarchandiseIterator' has an attribute 'cargaisoon'`() {
		uml.attributeCheck("cargaison", Cargaison::class)
	}

	@Test
	fun `test6 - 'MarchandiseIterator' has an attribute 'nbTotalMarchandises'`() {
		uml.attributeCheck("nbTotalMarchandises", Int::class)
	}

	@Test
	fun `test7 - 'MarchandiseIterator' has an attribute 'nbMarchandisesIteree'`() {
		uml.attributeCheck("nbMarchandisesIteree", Int::class)
	}

		@Test
	fun `test9 - 'MarchandiseIterator' has method(s)`() {
		uml.methodNumber(2)
	}

	@Test
	fun `test10 - 'MarchandiseIterator' has a method 'hasNext'`() {
		uml.methodCheck("hasNext", Boolean::class, isOpenOrOverride = true)
	}

	@Test
	fun `test11 - 'MarchandiseIterator' has a method 'next'`() {
		uml.methodCheck("next", Marchandise::class, isOpenOrOverride = true)
	}



}
