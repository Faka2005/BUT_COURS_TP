CC2 MVC
=======
Introduction
------------
Durée : 1h30 / 2h (tiers temps)

Rendu : l'ensemble du projet sans les nodes modules

Télécharger vos dépendences le plus rapidement possible, 
l'accès à Internet sera coupé sauf pour : 
https://mongoosejs.com/ 
https://nodejs.org/
https://developer.mozilla.org/

L'ensemble de la réalisation doit-être conforme au swagger fourni,
ne pas la regénérer mais modifier dans swagger.json le "host" avec l'IP de la VM.
La doc swagger est dans http://IP:PORT/doc/

Au final vous aurez les routes suivantes :

GET /api/v0/gourmand L'ensemble des gourmands

POST /api/v0/gourmand Ajoute un gourmand

DELETE /api/v0/gourmand  Supprime tous les gourmands

GET /api/v0/gourmand/{name} Permet d obtenir un gourmand

DELETE /api/v0/gourmand/{name} Permet de supprimer un gourmand

PUT /api/v0/gourmand/achete/{name} Achete un chocolat

Copier vos fichiers depuis le répertoire contenant cc2_init avec scp -r cc2_init debian@IP:/home/debian  

Penser à exporter la version de MongoMemory Server export MOGOMS_VERSION=7.0.3
Installer vos node modules npm i

Travail à réaliser 
------------------
Les questions sont independantes.

<strong> Le modèle </strong> 

Compléter la méthde estEnDanger() de Gourmand pour passer les tests.

<strong> Les tests de removeOne du DAO </strong>

Tester la méthode removeOne()

<strong> Coder la méthode achete(nom, gateau) du DAO </strong>

Vous devez passer les tests

<strong> Les routes </strong>

En vous basant sur le swagger coder les routes permettant de supprimer un ou les gourmands

<strong> L'application </strong>

Donner des tests applicatif permettant de supprimer un gourmand  


Rendu
-----
Le rendu est à faire sur madoc.
La procèdure suivante présuppose que votre code se trouve sur la VM dans /home/debian/cc2_init
1. En utilisant la commande, compresser le répertoire cc2_init depuis votre VM
    * tar -czvf nom_prenom.tar.gz ./cc2_init
3. Depuis votre terminal local recopier nom_prenom.tar.gz
    * scp debian@IP:/home/debian/nom_prenom.tar.gz .
3. Vérifier le contenu du fichier récupéré
4. Déposer ce fichier sur madoc 

Remarque
--------
Si vous avez dû recréer une VM penser à mettre à jour node

curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.2/install.sh | bash

source ~/.bashrc

nvm install --lts

nvm use --lts
