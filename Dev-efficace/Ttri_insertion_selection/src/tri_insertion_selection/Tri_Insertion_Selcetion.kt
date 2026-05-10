package tri_insertion_selection
import tri_insertion_selection.echange



fun tri_insertion_selection(T: Array<Int>):Array<Int>{
    // Précondition

    require(T.isNotEmpty()){"T doit pas être vide"}
//    require(T.all {it is Int }) {
//        "Le tableau doit contenir uniquement des entiers"
//    }
    require(T.isArrayOf<Int>()){"T doit être un tableau d'entiers"}

    // Initialisation

    var S=T.copyOf();//Copie du tableau initiale
    var index:Int=0;
    var N=T.size-1;
    // Invariant

    // Algorithme
    while (index<N){ //Condition d'arrêt




        val min = indiceMinimum(T, index, N)
        echange(T, index, min)
        // Progression
        index++;
        // Invariant
        // Variant
    }
    // Postcondition
    //Vérifie que le tableau trier conntient les élements de départ
    check(T.sortedArray().contentEquals(S.sortedArray())) {
        "Le sac des éléments n'est pas conservé"
    }
    //Vérifie que T est trier
    assert(( 0 until N-1).all {k->T[k]<T[k+1] }){"Le tableau n'est pas trier "}

    return T
}

