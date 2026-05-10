R4.01 CC1
==========

Introduction
------------

Durée : 45 minutes / 1 heure pour les tiers temps
URL authorisées :
1. [Opendata Nantes] (https://data.nantesmetropole.fr/)
2. [NodeJS] (https://nodejs.org/docs/latest-v22.x/api/)
3. [MDB] (https://developer.mozilla.org/)

Les package.json sont fournis à vous d'installer les nodes_modules (npm i)

Pour copier les fichiers sur votre VM, vous pouvez utiliser la commande scp depuis 
le répertoire contenant le répertoire cc1_etudiant.

scp -r cc1_etudiant debian@ip:/home/debian

Travail
-------

# Q1 Langage

Modifier le code suivant pour qu'il passe les tests (il est interdit d'utiliser mon oracle)  
et affiche un carré de coté n

n < 0   : carre(n) léve une erreur (Error("Must be positive or null"))

n=0     : carre(0)=> renvoie '\\n'

n=1     : carre(1)=> renvoie
'*\\n'

n=2     : carre(2)=>
'\*\*\\n\*\*\\n'

n=3     : carre(13)
'\*\*\*\\n\*\*\*\\n\*\*\*\\n'

# Q2 Transformation de données

La source de données est customers.mjs, 
compléter customersUtils.mjs pour passer les tests.

# Q3 Classes

La classe Animal est fournie, il vous faut compléter la classe Rabbit, 
un rabbit est un animal qui peut se cacher.

# Q4 Fetch

La source de données suivante [Toilette] (https://data.nantesmetropole.fr/explore/dataset/244400404_toilettes-publiques-nantes-metropole/information/) 
représente les toilettes de Nantes, compléter le code toilette.mjs 
pour obtenir les toilettes ouvertes accessibles PMR triées par gid.

Rendus
------
Le rendu est à faire sur madoc.
La procèdure suivante présuppose que votre code se trouve sur la VM dans /home/debian/cc1_etudiant
1. En utilisant la commande, compresser le répertoire cc1_etudiant depuis votre VM
   * tar -czvf nom_prenom.tar.gz ./cc1_etudiant
3. Depuis votre terminal local recopier nom_prenom.tar.gz
   * scp debian@IP:/home/debian/nom_prenom.tar.gz .
3. Vérifier le contenu du fichier récupéré
4. Déposer ce fichier sur madoc dans le répertoire correspondant à votre groupe

