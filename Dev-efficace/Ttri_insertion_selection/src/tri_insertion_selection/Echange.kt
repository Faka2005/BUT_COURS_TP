package tri_insertion_selection
/*
*Change deux élément de leur place dans un tableau
 */
fun echange(T: Array<Int>, i: Int, j: Int) {
    //Précondition
    require(i in T.indices){"i doit être au borne de T"}
    require(j in T.indices){"j doit être au borne de T"}
    // i et j soit dans les bornes de T
    //Initialisation
    val tmp = T[i]

    T[i] = T[j]
    T[j] = tmp
    //Postcondition

}

