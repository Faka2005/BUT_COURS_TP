### ~~1- classique : gestionnaire~~

* ~~recherche~~
* ~~recommendations~~
* ~~notes + fiabilité (structure)~~
* ~~verif coherence (structure)~~

### ~~2- planificateur~~

* ~~planificateur de saison (a voir)~~
* ~~planif visionnage courant~~

# 5) Structure

4 services + 1 gateway

## 1. API Gateway

### Responsabilités :

* point d’entrée Android
* vérification JWT
* routage
* orchestration des réponses composites
* homogénéisation erreurs

## 2. Auth Service

### Responsabilités :

* inscription / connexion ✔️
* hash mot de passe ✔️
* émission JWT ✔️
* refresh token éventuel ✔️

## 3. Catalog Service

### Responsabilités :

* recherche anime
* récupération / fusion Jikan + AniList + éventuellement AnimeChan
* normalisation des champs
* score de cohérence entre sources (structure + a voir)
* cache / stockage DB des fiches

## 4. Recommendation Service

### Responsabilités :

* prise en compte :
    * favoris
    * notes perso
    * genres préférés
    * liste d'anime
* calcul d’un score de recommandation

## 5. Planning Service

### Responsabilités :

* suivi des animés “en cours”
* prochains épisodes / priorités (recommendation + sorties)
* ordre de visionnage = recommendation pousée

Catalogue -> requete + parse + verif + ...

Liste anime pour user : anime avec status.
Fav : liste
note perso

# quesions

user stock les IDs ?
est ce que je peux stocker une note perso sous forme :

# TODO

score de fiabilité plateformes streaming / infos
endpoint API ? ou bien juste utils / algo ?

Par exemple, dans GET /anime/:id, renvoyer :
{
"id": "123",
"title": "Steins;Gate",
"consistencyScore": 0.87,
"streamingReliabilityScore": 0.65
}

streamingReliabilityScore calculé en intern : utils / ...

recommendations / ranking perso ?
value dans user

# Endpoints :

## DONE

## auth :

* login
* register
* me

---

## TODO

## autre :

### GET

* anime/:id
* anime/search?q={string}

* /users/:username
* /users/:username/favorites

#### Privé / token

* /users/me
* /users/me/favorites

### POST

* /users/me/lists
* DELETE /users/me/lists/:animeId
* /users/me/favorites
* DELETE /users/me/favorites/:animeId

### a definir :

* get privé ? : /users/me/recommendation
