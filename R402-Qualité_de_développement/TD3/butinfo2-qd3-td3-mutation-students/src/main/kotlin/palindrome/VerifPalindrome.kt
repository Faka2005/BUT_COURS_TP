package palindrome

class VerifPalindrome {
    /**
     * @param s : a word (with at least one letter)
     * @return true if s is a palindrome (a symmetric word)
     */
    fun isPalindrome(s: String): Boolean {
        val l = s.length
        var i = 0
        while (i < l / 2) {
            if (s[i] != s[l
                        - i
                        - 1]
            ) {
                return false
            }
            i++
        }
        return true
    }
}