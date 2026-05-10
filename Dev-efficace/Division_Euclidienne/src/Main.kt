import Calcul.division_euclidienne

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(division_euclidienne(7, 50))//(0,7)
    println(division_euclidienne(50, 7))//(7,1)
    println(division_euclidienne(10, 2))//(5,0)
    println(division_euclidienne(9, 3))//(3,0)
    println(division_euclidienne(0, 5))//(0,0)
    println(division_euclidienne(1, 1))//(1,0)
    println(division_euclidienne(5, 6))//(0,5)
    println(division_euclidienne(100, 9))//(11,1)
    println(division_euclidienne(1234, 10))//(123,4)
}
