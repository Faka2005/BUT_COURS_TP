package palindrome

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class VerifPalindromeTest {

    var vp = VerifPalindrome()

    @Test
    fun test1() {
        assertTrue(vp.isPalindrome("n"))
    }



}