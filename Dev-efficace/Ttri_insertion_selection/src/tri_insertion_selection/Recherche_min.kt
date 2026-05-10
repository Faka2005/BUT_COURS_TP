package tri_insertion_selection


fun indiceMinimum(T: Array<Int>, i: Int, N: Int): Int {
    // Précondition
    require(i in 0..N)

    //Initialisation
    var min = i
    var j = i + 1

    // Invariant :
    // min est l’indice du plus petit élément de T[i..j-1]
    while (j <= N) {
        if (T[j] < T[min]) {
            min = j
        }
        //Progression
        j++
    }

    // Postcondition :
    // ∀k ∈ [i..N], T[min] ≤ T[k]
    return min
}
