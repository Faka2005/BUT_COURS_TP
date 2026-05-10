package iut.but2.tp1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

val listeReference = listOf("every", "some", "good", "sorry",
    "bad", "words", "are", "for", "the", "soul", "I", "love", "you",
    "more", "than", "you", "can", "imagine", "plane", "and", "simple")


class TestUsageFileIterable {

    lateinit var fileInt: File<Int>

    lateinit var fileString: File<String>



    @BeforeEach
    fun init() {
        fileInt = FileChainee()
        for (i in 0..1000) {
            val randomValue = (-1000..1000).random()
            fileInt.insererEnQueue(randomValue)
        }
        fileString = FileChainee()
        for (mot in listeReference) {
            fileString.insererEnQueue(mot)
        }

    }

    @Test
    fun testFileIntIterator() {
        val iterator = fileInt.iterator()
        var somme = 0
        var compteur = 0
        while(iterator.hasNext()) {
            somme += iterator.next()
            compteur++
        }
        assertEquals(1001, compteur)
    }

    @Test
    fun testFileIntForEach() {
        var somme = 0
        var compteur = 0
        for (value in fileInt) {
            somme += value
            compteur++
        }
        assertEquals(1001, compteur)
    }

    @Test
    fun testFileStringIterator() {
        val iterator = fileString.iterator()
        var compteur = 0
        while(iterator.hasNext()) {
            assertEquals(listeReference[compteur], iterator.next())
            compteur++
        }
        assertEquals(21, compteur)
    }


    @Test
    fun testFileStringForEach() {
        var compteur = 0
        for(mot in fileString) {
            assertEquals(listeReference[compteur], mot)
            compteur++
        }
        assertEquals(21, compteur)
    }
}