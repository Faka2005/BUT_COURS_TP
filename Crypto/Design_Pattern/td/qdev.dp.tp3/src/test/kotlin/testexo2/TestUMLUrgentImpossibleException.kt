package testexo2

import exo2.*
import org.junit.jupiter.api.*
import univ.nantes.UMLChecker
import kotlin.reflect.KVisibility

	/***** Generated JUnit/UMLChecker Test Cases for UrgentImpossibleException *****/

class TestUMLUrgentImpossibleException {

	lateinit var uml : UMLChecker

	@BeforeEach
	fun init() {
		uml = UMLChecker.create(UrgentImpossibleException::class)
	}

	@Test
	fun `test0 - class UrgentImpossibleException is abstract or not`() {
		uml.isAbstract(false)
	}

	@Test
	fun `test1 - class UrgentImpossibleException is open or not`() {
		uml.isOpen(false)
	}

	@Test
	fun `test3 - 'UrgentImpossibleException' has attribute(s)`() {
		uml.attributeNumber(0)
	}

	@Test
	fun `test4 - 'UrgentImpossibleException' has method(s)`() {
		uml.methodNumber(0)
	}


}
