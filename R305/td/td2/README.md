# Avant-propos

L'auteur des exercices ci-dessous est Loïg Jezequel.
Le texte d'origine a été modifié à la marge pour l'année 2025-2026.


# Goroutines

Une goroutine est un moyen d’exécuter du code dans un flot de contrôle concurrent au flot de contrôle principal.
Une goroutine est créée à l'aide du mot-clé `go`, suivi de l'appel de la fonction qui constitue le point d'entrée du flot de contrôle concurrent.

Le programme 1 montre la création d’une goroutine.

```go
package main

import (
    "fmt"
)

func iter(id int) {
    for i:=0; i<100; i++ {
        fmt.Println("Goroutine", id, "itération", i)
    }
}

func main() {
    go iter(1)
    iter(2)
}
```

  1. Construire le programme et l'exécuter plusieurs fois, en redirigeant la sortie standard vers des fichiers. Comparer les fichiers. Obtient-on toujours le même résultat ? Expliquer.
  2. Inverser les deux lignes de la fonction `main` puis reprendre la question 1. Expliquer.
Programme 1 – goroutines.go
  3. Modifier le programme pour lancer 100 goroutines au lieu de 2.


# Communication entre Goroutine

## Communiquer par des variables partagées 

Comme expliqué en cours, les goroutines d'un même programme s'exécutent dans le même espace d'adressage, elles peuvent donc facilement partager des variables. Ainsi :
  - les variables globales sont naturellement partagées ;
  - les variables dynamiques (allouées dans le tas) peuvent être partagées via leurs adresses ;
  - les variables automatiques (allouées dans la pile) ne sont pas partagées : en effet, il faudrait les partager via leurs adresses, mais dès que l'adresse d'une variable locale _s'échappe_ du _scope_ où la variable est définie, le compilateur go le détecte et alloue la variable dans le tas (cela a été vu en INFO1 dans la ressource r204)

```go
package main

import (
    "fmt"
)

var turn1 bool

func routine1 () {
    for {
        if turn1 {
            fmt.Println("Goroutine 1")
            turn1 = false
        }
    }
}

func routine2 () {
    for {
        if !turn1 {
            fmt.Println("Goroutine 2")
            turn1 = true
        }
    }
}

func main ( ) {
    go routine1( )
    routine2( )
}
```

  1. Contruire et tester le programme ci-dessus.
  2. Modifier ce programme pour que la variable `turn1` soit maintenant allouée dynamiquement dans la fonction `main`. 


## Communiquer via des canaux

Utiliser des variables partagées pour communiquer entre goroutines n’est pas recommandé : des conflits d'accès peuvent apparaîtrent, qui peuvent produire des valeurs incohérentes pour ces variables.
Régler ces conflits d'accès nécessite d'utiliser des outils de synchronisations qui peuvent eux-même être la source de problème de type deadlock, livelock, ou encore famine.

En Go, la façon idiomatique de faire communiquer des goroutines est d'utiliser des canaux (_channel_).
Un canal est une structure de données concurrentes, c'est-à-dire que les opérations de manipulation sont prévues pour être utilisées dans des goroutines concurrentes.
C'est plus précisément une file de taille fixe.
Lorsque la file est pleine, l'ajout d'une donnée est bloquant.
Lorsque la file est vide, le prélèvement d'une donnée est bloquant.
Il est possible de créer des canaux de taille 0. 
Dans ce cas, ajout et prélèvement doivent être simultanés.

Pour construire un canal, on utilise l'opérateur `make` :

```go
  c := make(chan int32, 3) // canal pouvant contenir jusqu'à 3 valeurs de type int32
```

Pour ajouter / prélever, on utilise l'opérateur `<-` :

```go
  c <- 42 // ajout de la valeur 42 au canal 
  x <- c  // prélèvement de la valeur en tête du canal c, copiée dans la variable x
  x, ok <- c // version non bloquante :  si le canal est vide ou fermé, x reçoit 0 et ok reçoit false, sinon x reçoit la valeur en tête et ok reçoit true
```

  1. Reprendre l'exercice précédent en supprimant la variable `turn1` et en utilisant à la place un canal de taille 0 pour assurer la communication entre les goroutines. 
  2. Lire et comprendre le programme ci-dessous. Prévoir l'affichage des premières lignes affichées.
  3. Reprendre la question précédente lorsque le canal `c` est créé avec une taille de : 1, 2, 4, 10.

```go
package main

import (
    "fmt"
    "time"
)

func writer(c chan bool) {
    for {
        time.Sleep (500 * time.Millisecond)
        c <- true
        fmt.Println("write")
    }
}

func reader(c chan bool) {
    for {
        time.Sleep(time.Second)
        <- c
        fmt.Println("read")
    }
}

func main( ) {
    var c chan bool = make(chan bool)
    go writer(c)
    reader (c)
}
```


##  La structure de contrôle select

La structure de contrôle `select` permet de manipuler plusieurs canaux simultanément.
Concrètement, comme le montre le code ci-dessous, cela permet à une routine de se mettre en attente simultanément sur plusieurs canaux.
L'exemple ne montre que des attentes sur des opérations de prélèvement de données, mais il est tout à fait possible d'utiliser des opérations d'ajout de données, et bien sûr de mélanger les deux.

L'attente se poursuit tant qu'aucune opération n'est possible car les canaux sont vides (pour les opérations de prélèvement) ou plein (pour les opérations d'ajout).
Dès qu'au moins une opération est possible, l'attente se termine et cette opération est réalisée.
Si plusieurs opérations sont possibles, le runtime go en choisit une en effectuant un tirage pseudo-aléatoire selon une loi uniforme.


```go 
package main

import (
    "fmt"
    "math/rand"
    "time"
)

func routine(c chan int) {
    wait := rand.Intn(1000)
    time.Sleep(time.Duration(wait)*time.Millisecond)
    c <- wait
}

func main() {
    rand.Seed(int64(time.Now().Nanosecond()))
    
    c1 := make(chan int)
    c2 := make(chan int)
    go routine(c1)
    go routine(c2)

    select {
        case w := <- c1:
            fmt.Println("c1", w, "milliseconds")
        case w := <- c2: 
            fmt.Println("c2", w, "milliseconds")
    }
}
```

  1. Lire et expliquer le fonctionnement du programme ci-dessus.
  2. Compiler et exécuter le programme plusieurs fois.
  3. Modifier le programme : si, au bout de 500 ms aucune opération n'est possible, le message "no operation within 500ms" est affiché puis le programme se termine. Pour cela, utiliser la fonction `time.After`.


## Retour au client-serveur du td n°1

Reprendre le programme client-serveur du td n°1 pour apporter les modifications suivantes :

  1. Le serveur doit être capable de gérer plusieurs clients simultanément.
  2. Par ailleurs, pendant qu'il s'exécute, le serveur doit afficher le nombre de client actuellement connectés. Cet affichage est mis à jour au fur et à mesure des connexions et déconnexions. Pour cela, le programme ne doit pas utiliser de variables partagées autres que des canaux.
  3. Le serveur doit également pouvoir accepter une connexion sur le port 8081. Quand il reçoit cette connexion, il se termine.

