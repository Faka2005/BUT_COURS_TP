package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

	/***** Generated JUnit/UMLChecker Test Cases for CargaisonAerienneUrgente *****/

class TestUMLCargaisonAerienneUrgente {

	lateinit var uml : UMLChecker

	@BeforeEach
	fun init() {
		uml = UMLChecker.create(CargaisonAerienneUrgente::class)
	}

	@Test
	fun `test0 - class CargaisonAerienneUrgente is abstract or not`() {
		uml.isAbstract(false)
	}

	@Test
	fun `test1 - class CargaisonAerienneUrgente is open or not`() {
		uml.isOpen(false)
	}

	@Test
	fun `test2 - 'CargaisonAerienneUrgente' extends other classe(s)`() {
		uml.extend("CargaisonAerienne")
	}

	@Test
	fun `test3 - 'CargaisonAerienneUrgente' has a constructor`() {
		uml.constructorCheck(paramsAndTypes=arrayOf(Pair("distance", Int::class)))
	}

	@Test
	fun `test4 - 'CargaisonAerienneUrgente' has attribute(s)`() {
		uml.attributeNumber(0)
	}

	@Test
	fun `test5 - 'CargaisonAerienneUrgente' has method(s)`() {
		uml.methodNumber(1)
	}

	@Test
	fun `test6 - 'CargaisonAerienneUrgente' has a method 'facteur'`() {
		uml.methodCheck("facteur", Int::class, methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}


}
