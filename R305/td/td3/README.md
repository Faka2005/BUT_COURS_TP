# Avant-propos

L'auteur des exercices ci-dessous est Loïg Jezequel.
Le texte d'origine a été modifié à la marge pour l'année 2025-2026.


# _Race condition_

Comme on l'a vu en cours, lorsque deux flots de contrôle concurrents tentent d'accéder à une même variable, si l'un au moins des accès est e en écriture, un conflit peut avoir lieu.
À l'exécution, ces conflits peuvent entraîner l'apparition d'une valeur non cohérente, ce qui peut ensuite donner lieu à des comportements anormaux du programme.
On parle de _race condition_.

Comme on l'a également évoqué en cours, réaliser des tests ne suffit pas pour montrer qu'un programme concurrent est exempts de problèmes d'accès concurrents.
En effet, ces derniers peuvent n'entraîner des conséquences néfastes que pour certaines exécutions.
On rappelle à ce sujet que le compilateur go dispose de l'option `-race`, dont l'objectif est de favoriser l'apparition de problème d'accès concurrents à l'exécution.

Vous trouverez dans le dossier `src/race-condition` du dépôt un ensemble de codes sources. 
Pour chacun, répondre aux questions suivantes :
  - Le code contient-il une ou plusieurs _race conditions_ (justifier la réponse) ?
  - Pour l'exercice 0 et les différentes version de l'exercice 1, corriger les éventuelles _race condition_ en synchronisant les accès à l'aide de verrous (cf. package `sync`).
  - Pour l'exercice 2, corriger les éventuelles _race condition_ en ré-écrivant le code à l'aide de canaux.


# Interblocages

Comme on l'a également vu en cours, un interblocage peut se produire dans un programme concurrent utilisant des outils de synchronisations.
Le terme interblocage désigne une situation ou 2 ou plus flots concurrents sont bloqués, en attente d'une synchronisation avec un flot lui-même bloqué et en attente. 
On distingue parfois les situations où les flots sont complètements bloqué (_deadlock_), de celles où ils sont bloqués dans une boucle incluant une tentative de synchronisation dont aucune sortie n'est possible (_livelock_).

Vous trouverez dans le dossier `src/deadlock` du dépôt un ensemble de codes sources.
Pour chacun, expliquer la cause de l'interblocage et proposer une correction.



