package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

	/***** Generated JUnit/UMLChecker Test Cases for CargaisonRoutiere *****/

class TestUMLCargaisonRoutiere {

	lateinit var uml : UMLChecker

	@BeforeEach
	fun init() {
		uml = UMLChecker.create(CargaisonRoutiere::class)
	}

	@Test
	fun `test0 - class CargaisonRoutiere is abstract or not`() {
		uml.isAbstract(false)
	}

	@Test
	fun `test1 - class CargaisonRoutiere is open or not`() {
		uml.isOpen(false)
	}

	@Test
	fun `test2 - 'CargaisonRoutiere' extends other classe(s)`() {
		uml.extend("Cargaison")
	}

	@Test
	fun `test3 - 'CargaisonRoutiere' has a constructor`() {
		uml.constructorCheck(paramsAndTypes=arrayOf(Pair("distance", Int::class)))
	}

	@Test
	fun `test4 - 'CargaisonRoutiere' has attribute(s)`() {
		uml.attributeNumber(0)
	}

	@Test
	fun `test5 - 'CargaisonRoutiere' has method(s)`() {
		uml.methodNumber(2)
	}

	@Test
	fun `test6 - 'CargaisonRoutiere' has a method 'limite'`() {
		uml.methodCheck("limite", Double::class, methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}

	@Test
	fun `test7 - 'CargaisonRoutiere' has a method 'facteur'`() {
		uml.methodCheck("facteur", Int::class, methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}


}
