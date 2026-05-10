fun main(args: Array<String>) {
    println("Hello World!")

    var pv = palindrome.VerifPalindrome()

    var mot ="Bonjour"
    println("$mot "+pv.isPalindrome(mot))
    mot = "LOL"
    println("$mot "+pv.isPalindrome(mot))
}