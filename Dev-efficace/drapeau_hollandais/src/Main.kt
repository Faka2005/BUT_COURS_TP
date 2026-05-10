package Drapeau_hollandais
import Drapeau_hollandais.drapeau_hollandais

    fun main() {
        val T = arrayOf('B', 'R', 'W', 'B', 'R', 'W', 'R', 'B')
        println("Avant tri : ${T.contentToString()}")
        val T_tri = drapeau_hollandais(T)
        println("Après tri : ${T_tri.contentToString()}")
    }


