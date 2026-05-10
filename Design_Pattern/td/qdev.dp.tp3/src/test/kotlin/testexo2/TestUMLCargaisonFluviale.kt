package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

	/***** Generated JUnit/UMLChecker Test Cases for CargaisonFluviale *****/

class TestUMLCargaisonFluviale {

	lateinit var uml : UMLChecker

	@BeforeEach
	fun init() {
		uml = UMLChecker.create(CargaisonFluviale::class)
	}

	@Test
	fun `test0 - class CargaisonFluviale is abstract or not`() {
		uml.isAbstract(false)
	}

	@Test
	fun `test1 - class CargaisonFluviale is open or not`() {
		uml.isOpen(false)
	}

	@Test
	fun `test2 - 'CargaisonFluviale' extends other classe(s)`() {
		uml.extend("Cargaison")
	}

	@Test
	fun `test3 - 'CargaisonFluviale' has a constructor`() {
		uml.constructorCheck(paramsAndTypes=arrayOf(Pair("distance", Int::class)))
	}

	@Test
	fun `test4 - 'CargaisonFluviale' has attribute(s)`() {
		uml.attributeNumber(0)
	}

	@Test
	fun `test5 - 'CargaisonFluviale' has method(s)`() {
		uml.methodNumber(1)
	}

	@Test
	fun `test6 - 'CargaisonFluviale' has a method 'limite'`() {
		uml.methodCheck("limite", Double::class, methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}


}
