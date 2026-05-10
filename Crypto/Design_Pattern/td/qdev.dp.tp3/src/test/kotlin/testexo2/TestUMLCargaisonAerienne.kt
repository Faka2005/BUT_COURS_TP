package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

	/***** Generated JUnit/UMLChecker Test Cases for CargaisonAerienne *****/

class TestUMLCargaisonAerienne {

	lateinit var uml : UMLChecker

	@BeforeEach
	fun init() {
		uml = UMLChecker.create(CargaisonAerienne::class)
	}

	@Test
	fun `test0 - class CargaisonAerienne is abstract or not`() {
		uml.isAbstract(false)
	}

	@Test
	fun `test1 - class CargaisonAerienne is open or not`() {
		uml.isOpen(true)
	}

	@Test
	fun `test2 - 'CargaisonAerienne' extends other classe(s)`() {
		uml.extend("Cargaison")
	}

	@Test
	fun `test3 - 'CargaisonAerienne' has a constructor`() {
		uml.constructorCheck(paramsAndTypes=arrayOf(Pair("distance", Int::class)))
	}

	@Test
	fun `test4 - 'CargaisonAerienne' has attribute(s)`() {
		uml.attributeNumber(0)
	}

	@Test
	fun `test5 - 'CargaisonAerienne' has method(s)`() {
		uml.methodNumber(3)
	}

	@Test
	fun `test6 - 'CargaisonAerienne' has a method 'limite'`() {
		uml.methodCheck("limite", Double::class, methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}

	@Test
	fun `test7 - 'CargaisonAerienne' has a method 'facteur'`() {
		uml.methodCheck("facteur", Int::class, methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}

	@Test
	fun `test8 - 'CargaisonAerienne' has a method 'encombrement'`() {
		uml.methodCheck("encombrement", Double::class, methParamAndTypes=arrayOf(Pair("marchandise", Marchandise::class)), methVisibility=KVisibility.PROTECTED, isOpenOrOverride=true)
	}


}
