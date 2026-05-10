package iut.but2.tp1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestUsageIterators2 {


    @Test
    fun testFilesIntIterators() {
        val fileArrayList = FileArrayList<Int>()
        val fileChainee = FileChainee<Int>()

        for (i in 0..1000) {
            val randomValue = (-1000..1000).random()
            fileArrayList.insererEnQueue(randomValue)
            fileChainee.insererEnQueue(randomValue)
        }

        val iterator1 = fileArrayList.iterator()
        val iterator2 = fileChainee.iterator()
        while(iterator1.hasNext() && iterator2.hasNext()) {
            assertEquals(iterator1.next(), iterator2.next())
        }
    }

    @Test
    fun testFilesIterators() {

        val fileArrayListString = FileArrayList<String>()
        val fileChaineeString = FileChainee<String>()
        for (mot in listeReference) {
            fileArrayListString.insererEnQueue(mot)
            fileChaineeString.insererEnQueue(mot)
        }

        val iterator1 = fileArrayListString.iterator()
        val iterator2 = fileChaineeString.iterator()
        while(iterator1.hasNext() && iterator2.hasNext()) {
            assertEquals(iterator1.next(), iterator2.next())
        }
    }
}