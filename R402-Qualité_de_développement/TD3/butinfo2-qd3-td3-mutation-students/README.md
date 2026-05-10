# TD3 ANALYSE DE MUTATION

Nous allons mettre en pratique l'analyse de mutation en utilisant deux cas d'étude :

1. un programme qui vérifie si un mot est un palindrome,
2. le réveil.

Il existe plusieurs outils pour l'analyse de mutation. 
Pour les programmes Java, le plus maintenu est probablement PITEST :
http://pitest.org/
Il existe un plugin de pitest pour les programmes kotlin, 
néanmoins il n'est plus maintenu car ces concepteurs en ont fait un outils payant :
https://www.arcmutate.com/

Commencez par cloner ce projet gitlab dans **IntelliJ**.

Le fichier gradle est déjà prêt. 
Normalement, il ne devrait pas nécessiter de mise à jour : 
il vaut même mieux éviter pour que le plugin marche malgré son statut "deprecated".

## PRISE EN MAIN DU PALINDROME
Si le build du gradle se passe bien (sinon lancez le),
vous obtiendrez un projet configuré avec le programme "Palindrome" dans une classe du dossier source "main",
ainsi qu'une classe Main pour lancer un exemple.

Q1 - Lancez le main.

Il y a aussi une classe avec un premier test.

Q2 - Lancez le test. Passe-t-il ?

## COUVERTURE DE CODE

En lien avec le TD de test structurel, observons la couverture du code obtenue avec ce premier test.

Faites un "Run ... with coverage".
Observez le rapport (dans l'onglet qui doit s'ouvrir).

Q3 - Quelle couverture obtenez-vous ?

Q3.1 - Quelle couverture des instructions ?

Q3.2 - Quelle couverture des arcs ?

Q3.3 - Ajoutez la couverture des branches :
https://www.jetbrains.com/help/idea/running-test-with-coverage.html

Q3.4 - Utilisez une alternative avec jacoco :
Ouvrez l'onglet à droite "Gradle".
Dans "MutationAnalysis>Tasks>verification", vous trouverez différents tasks Gradle.
Commencez par lancer "test".
Puis lancez "jacocoTestReport".
Cela génère dans le dossier "build" de l'onglet "Project", un dossier "customJacoco...".
Ouvrez le index.html (si vous obtenez un 404, faites un drag&drop dans un navigateur).
Analysez ce rapport de Jacoco, dont par exemple le graphisme est plus explicite.

Changez le mot testé "n" par "nn".
Q4 - Quelle couverture obtenez-vous ?

Q4.1 - Quelle couverture des instructions ?

Q4.2 - Quelle couverture des arcs ?

Q5 - Faites une action _minimale_ pour obtenir 100% de couverture des lignes de code.

Q5.1 - Est-il possible d'obtenir une couverture de 100% des noeuds mais pas 100% des arcs ?

## ANALYSE DE MUTATION

Lancez le task Gradle pitest et ouvrez le rapport obtenu.

Q6 - Quel score de mutation obtenez-vous avec ces 2 tests ?

Q6.1 - Quel score de mutation obtenez-vous avec chacun de ces tests ?


Analysez les mutants vivants grace au rapport.
Malheureusement, les numéros de ligne de code sont assez mal gérés 
(encore moins bien dans cette version kotlin que dans la version java de PITest).

Q7 - Créez de nouveaux cas de test pour améliorer le score de mutation, un par un, 
en commençant par analyser le mutant vivant de la ligne 12 (qui est en fait ligne 13)).

Q8 - Pourquoi n'arrivez-vous pas à obtenir un score de 100% ?

Q9 - Enlevez les cas de tests qui ne sont pas utiles pour maintenir un score de mutation maximal.

## ANALYSE DE MUTATION avancée

Q10 - Sait-on quel cas de test tue quel mutant ?

Q10.1 - Quel rapport doit-on générer pour cela ?

https://gradle-pitest-plugin.solidsoft.info/

Q11 - Comment obtenir la matrice de mutation (presque) complète ?

https://pitest.org/quickstart/maven/

Q12 - Analysez les opérateurs de mutation utilisé par PITest.

http://pitest.org/quickstart/mutators/

Q12.1 - Utilisez l'ensemble "STRONGER" en affectant la property "mutators" pour obtenir d'autres mutants.
(L'ensemble ALL n'est plus utilisable sans un plugin additionnel)

Q12.2 - A priori, vous devriez ne pas tuer le même nombre de mutants. Sinon, créez de nouveaux tests.

## CAS D'ETUDE DU REVEIL

Q13 - Générez les mutants pour le cas d'étude du réveil.

_**Tuez les tous !**_

## OPTIONNEL

Q14 - Que génère la feature EXPORT ?

setProperty("features", listOf("+EXPORT"))

Il semble que le bytecode généré ne soit pas décompilable, contrairement à la version java du projet et de PITest :
https://gitlab.univ-nantes.fr/mottu-jm/iut.lpro.miar.tql.mutationanalysis

Q14.1 - Quelle question précédente serait plus facile grâce à cela ?







