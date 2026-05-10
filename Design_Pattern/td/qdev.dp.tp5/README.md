# qdev.dp.tp5

> Si vous êtes sur votre ordinateur personnel, 2 solutions pour que le projet s'ouvre correctement
>
> 1) utiliser **EduPVN** et _uniquement_ désactiver la configuration du proxy  
     > pour `gradle`en commentant les lignes correspondantes dans le fichier `gradle.properties`
>
>2) ne pas utiliser **EduVPN** et désactiver la configuration du proxy pmais aussi
    > toutes les références à `nexus.dep-info.iut-nantes.univ-nantes.prive`dans `build.gradle.kts` et
    `settings.gradle.kts`

## Exercice n°1

Il va s'agir d'implémenter l'exercice 1 du TD n°5. Le problème de départ était le suivant :

![formfield](plantuml/td5-formfield.png)


La solution proposée est :

![formfield strategies](plantuml/td5-formfield-strategies.png)

Des cas de tests JUnit vous sont fournis dans le package `testexo1`.
Renommez les fichiers `.ktest` en `.kt` pour qu'ils soient pris en compte.

Vous pouvez aussi tester votre implémentation en lançant la classe `Main.kt` (clic droit -> Run `MainKt`),
Attention, le programme affiche des messages dans la console.

## Exercice n°2

Il va s'agir d'implémenter l'exercice 2 du TD n°5. La spécification UML de départ est la suivante :

![img](plantuml/td5-impots.png)

_Dans le package `exo2.sans`, vous trouverez une implémentation **fonctionnelle** qui n'utilise pas de design patterns,
afin
de vous permettre de comparer les solutions_

### Solution avec le design pattern _Strategy_

Dans le package `exo2.strategy`, implémentez la solution utilisant le design pattern _Strategy_.

![img](plantuml/td5-impots-strategy.png)

Des cas de tests JUnit vous sont fournis dans le package `testexo2.strategy`.
Renommez les fichiers `.ktest` en `.kt` pour qu'ils soient pris en compte.

### Solution avec le design pattern _Template Method_

Dans le package  `exo2.templatemethod`, implémentez la solution utilisant le design pattern
_Template method_.

![img](plantuml/td5-impots-templatemethod.png)

Des cas de tests JUnit vous sont fournis dans le package `testexo2.templatemethod`.
Renommez les fichiers `.ktest` en `.kt` pour qu'ils soient pris en compte.

### Solution avec le design pattern _Template Method_ appliquée sur la classe `Foyer`

Dans le package  `exo2.templatemethodfoyer`, implémentez la solution utilisant le design pattern
_Template method_ appliquée sur la classe `Foyer`.

![img](plantuml/td5-impots-templatemethod-foyer.png)

Des cas de tests JUnit vous sont fournis dans le package `testexo2.templatemethodfoyer`.
Renommez les fichiers `.ktest` en `.kt` pour qu'ils soient pris en compte.

### Comparaison des solutions

Comparez les 4 solutions (sans design pattern, avec _Strategy_ sur `CalculImpot`, avec _Template Method_ sur
`CalculImpot`,
et avec _Template Method_ sur `Foyer`), en terme de compréhension du code, de maintenabilité, d'évolutivité, etc.

## Pour aller plus loin

- Implémentez un `Validator` pouvant **combiner** plusieurs `Validator` (ex : `AndValidator`, `OrValidator`,
  `NotValidator`, etc.)
- Dans l'exercice n°1, modifiez les règles de validation pour qu'elles correspondent vraiment à des règles réelles ?
- Modifiez/augmentez les cas de tests en conséquence
- Ajoutez de nouveaux `Validator` et implémentez les cas de tests en conséquence
- ...