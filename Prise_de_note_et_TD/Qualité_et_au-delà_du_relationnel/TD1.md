
---

# I. Normalisation et qualité dans le modèle relationnel

---

## **1. Étude de la relation R(A, B, C, D)**

Relation donnée :

| A   | B   | C   | D   |
| --- | --- | --- | --- |
| A1  | B2  | C1  | D1  |
| A1  | B2  | C1  | D2  |
| A1  | B2  | C2  | D3  |
| A2  | B4  | C2  | D2  |
| A3  | B3  | C4  | D2  |

### **a. Clés candidates**

Une clé candidate est un ensemble **minimal d’attributs** permettant d’identifier **de façon unique** chaque tuple.

* Aucun attribut seul (A, B, C ou D) n’est unique.
* Les couples suivants identifient chaque tuple de manière unique :

  * (A, D)
  * (B, D)
  * (C, D)

 **Les clés candidates  sont donc :**

---

### **b. Dépendances fonctionnelles**

* **A → B : OUI**
  Pour chaque valeur de A, il existe une seule valeur associée de B
  (exemple : A1 → B2, A2 → B4, A3 → B3).

* **A → C : NON**
  La valeur A1 est associée à **plusieurs valeurs de C** (C1 et C2).

 **Conclusion :**

* A → B existe
* A → C n’existe pas

---

## **2. Relation R(A, B, C) avec F = {A → B ; B → C}**

### **a. Clé de la relation**



* A → C
* A → B
Par union  ⟹ A =  B, C

 **La clé de la relation est :** **A 
 

---

### **b. Forme normale**

* La clé est simple (A), donc pas de dépendance partielle → **2FN**
* Il existe une dépendance transitive :
  
  A→ B → C
  

 

 **La relation est en 2FN 

---

## **3. Relation R(A, B, C)**

| A | B | C |
| - | - | - |
| 1 | 1 | 1 |
| 2 | 1 | 2 |
| 3 | 2 | 1 |
| 4 | 3 | 3 |

---

### **a. Clé candidates

* A
* B et C



---

### **b. Forme normale**

Dépendances fonctionnelles observées :

* A → B
* A → C


I

 **La relation est en 3FN**

---

### **c. Couverture minimale**

Ensemble initial :

F = {A→ B,\ A→C,\ C → B}

 **Couverture minimale :** Car on peut pas retrouver la dépendance si on enlève un élément

{F_{min} = F

---

## **4. Relation R(A, B, C, D, E)**

Ensemble des dépendances :

F = {A → B, A → D, A → E, E → C}


---

### **a. Clé primaire**

Calcul de la fermeture de A :

* A → B
* A → D
* A → E
* E → C

⟹ A⁺ = {A, B, C, D, E}

Par transitivité   **La clé primaire et candidate de la relation est :** **A**  

---

### **b. Forme normale**

Il existe une dépendance transitive :

A →E → C


* E n’est pas une clé
* C dépend indirectement de la clé A

 **Elle est seulement en 2FN**

---

## **c. F est-il une couverture minimale?**
On rappelle l’ensemble des dépendances fonctionnelles :

F={A→B, A→D, A→E, E→C}
F={A→B, A→D, A→E, E→C}
Étape 1 – Décomposition des dépendances

Chaque dépendance a :

un seul attribut à droite,

un seul attribut à gauche.

 Cette condition d’une couverture minimale est respectée.

Étape 2 – Recherche d’attributs superflus

Dans 
A→B
A→B, 
A
A est nécessaire

Dans 
A→D
A→D, 
A
A est nécessaire

Dans 
A→E
A→E, 
A
A est nécessaire

Dans 
E→C
E→C, 
E
E est nécessaire

 Aucun attribut n’est superflu.

Étape 3 – Recherche de dépendances redondantes

On vérifie si une dépendance peut être déduite des autres :

A→B
A→B : non déductible sans l’utiliser

A→D
A→D : non déductible

A→E
A→E : non déductible

E→C
E→C : non déductible

Même si 
A→C
A→C peut être déduit de

A→E
A→E et 
E→C
E→C, il n’appartient pas à F, donc aucune dépendance de F n’est redondante.

 Conclusion
L’ensemble F est une couverture minimale

---
## 5- Relation R(A,B,C,D,E,F,G) :F= {A-→B ; BC --> DE ; AEF -->G}

--- 

## **Algorithme pour calculer X⁺**

1. **Initialisation** :


X^+= X

(on commence avec l’ensemble de départ)

2. **Application des dépendances** :

* Tant qu’une dépendance (Y \rightarrow Z) a **Y ⊆ X⁺**, ajouter Z dans X⁺.

3. **Stabilisation** :

* Quand aucune dépendance ne permet d’ajouter un nouvel attribut, on s’arrête.

---

## **Étape par étape pour X = {A, C}**

### **Étape 1 – Attributs de départ**


(AC)^+ = {A, C}


---

Étape 2 – Application des dépendances fonctionnelles

On part de :

(AC)+={A,C}
(AC)
+
={A,C}

et on applique toutes les dépendances une par une.

A → B

Vérification : Le côté gauche de la dépendance est A.

Est-ce que A ∈ (AC)^+ ? Oui, A est dans notre fermeture actuelle.

Action : Puisque la condition est remplie, on ajoute B dans (AC)^+.

(AC)+={A,B,C}
(AC)
+
={A,B,C}
 A → D

Côté gauche : A

A ∈ (AC)^+ ?  Oui

Action : Ajouter D

(AC)+={A,B,C,D}
(AC)
+
={A,B,C,D}
A → E

Côté gauche : A

A ∈ (AC)^+ ?  Oui

Action : Ajouter E

(AC)+={A,B,C,D,E}
(AC)
+
={A,B,C,D,E}
 E → C

Côté gauche : E

E ∈ (AC)^+ ? Oui, on vient juste de l’ajouter

Action : Ajouter C

(AC)+={A,B,C,D,E}
(AC)
+
={A,B,C,D,E}

Remarque importante : C est déjà présent dans notre fermeture.

On ne l’ajoute pas une deuxième fois.

En pratique, cela signifie que cette dépendance ne fait pas “grandir” la fermeture.
---

### **Étape 3 – Stabilisation**

* Plus aucune dépendance ne permet d’ajouter de nouvel attribut.
* Les attributs **F et G** n’apparaissent pas dans les dépendances et ne sont donc **pas inclus dans la fermeture**.

---

## **Résultat final**

[
\boxed{(AC)^+ = {A, B, C, D, E}}
]

---

## **Conclusion**

* L’ensemble **AC détermine les attributs {A, B, C, D, E}**, donc c’est une **superclé partielle** pour ces attributs.
* Les attributs **F et G** ne sont pas déterminés par AC (dans cet exemple), donc pour que AC soit une superclé complète de **R(A,B,C,D,E,F,G)**, il faudrait que AC permette aussi de déterminer F et G.
* La **clé minimale** reste **A** si on ne considère que les attributs liés par les dépendances données.

--- 
## 6- Trouver la couverture minimale de F par application de l’algorithme vu en cours : 

F={AB→C ; C→A ; BC→D ; ACD→B ; BE→C ; CE→FA ; CF→BD ; D-->EF}

---
### Étapes 1 - DFs simples (Il doit avoir un élément à droite)
A,B     -> C
C       -> A
B,C     -> D
A,C,D   -> B
B,E     -> C
C,E     -> F
C,E     -> A
C,F     -> B
C,F     -> D 
D       -> E
D       -> F



---

### **Étape 2 – Vérification des attributs superflus**

> Vérifier pour chaque dépendance (X \rightarrow Y) si un attribut à gauche peut être supprimé sans perdre la capacité à déterminer l’attribut à droite.

---

### ** AB → C**

* **A est superflu ?**

  * B0 → {B}
  * B1 → {B}
  * C ∉ B^+ → **A n’est pas superflu**

* **B est superflu ?**

  * A0 → {A}
  * A1 → {A}
  * C ∉ A^+ → **B n’est pas superflu**

 Résultat : **AB → C reste AB → C**

---

### ** BC → D**

* **B est superflu ?**

  * C0 → {C}
  * C1 → {C, A}
  * D ∉ C^+ → **B n’est pas superflu**

* **C est superflu ?**

  * B0 → {B}
  * B1 → {B}
  * D ∉ B^+ → **C n’est pas superflu**

 Résultat : **BC → D reste BC → D**

---

### ** ACD → B**

* **A est superflu ?**

  * CD0 → {C, D}
  * CD1 → {C, D, A, E, F}
  * CD2 → {C, D, A, E, F, B}
  * B ∈ CD2 → **A est superflu**

* **C est superflu ?**

  * AD0 → {A, D}
  * AD1 → {A, D, E, F}
  * B ∉ AD^+ → **C non-superflu**

* **D est superflu ?**

  * AC0 → {A, C}
  * AC1 → {A, C}
  * B ∉ AC^+ → **D non-superflu**

 Résultat : **CD → B** (on supprime A)

---

### ** BE → C**

* **B est superflu ?**

  * E0 → {E}
  * E1 → {E}
  * C ∉ E^+ → **B non-superflu**

* **E est superflu ?**

  * B0 → {B}
  * B1 → {B}
  * C ∉ B^+ → **E non-superflu**

 Résultat : **BE → C reste**

---

### ** CE → F**

* **C est superflu ?**

  * E0 → {E}
  * E1 → {E}
  * F ∉ E^+ → **C non-superflu**

* **E est superflu ?**

  * C0 → {C}
  * C1 → {C, A}
  * F ∉ C^+ → **E non-superflu**

 Résultat : **CE → F reste**

---

### ** CE → A**

* **C est superflu ?**

  * E0 → {E}
  * E1 → {E}
  * A ∉ E^+ → **C non-superflu**

* **E est superflu ?**

  * C0 → {C}
  * C1 → {C, A}
  * A ∈ C^+ → **E est superflu**

 Résultat : **C → A** (on supprime E)

---

### ** CF → B**

* **C est superflu ?**

  * F0 → {F}
  * F1 → {F}
  * B ∉ F^+ → **C non-superflu**

* **F est superflu ?**

  * C0 → {C}
  * C1 → {C, A}
  * B ∉ C^+ → **F non-superflu**

 Résultat : **CF → B reste**

---

### ** CF → D**

* **C est superflu ?**

  * F0 → {F}
  * F1 → {F}
  * D ∉ F^+ → **C non-superflu**

* **F est superflu ?**

  * C0 → {C}
  * C1 → {C, A}
  * D ∉ C^+ → **F non-superflu**

 Résultat : **CF → D reste**

---

### ** D → E et D → F**

* Côté gauche à un seul attribut → aucun superflu possible
   Résultat : **D → E, D → F restent**

---

## ** Résultat après suppression des attributs superflus**

* AB → C
 * C  → A 
 * BC → D 
 * CD→ B 
 * BE → C 
 * CE → F 
 * CF → B 
* CF → D 
 * D → E 
 * D → F



---
### Étapes 3- Dépendance Fonctionnelles redondante
Vérifier que chaque dépendances n'est pas redondante

---
### ** AB → C** 
* **A est redondant ?**
    
*  A0->{A,B}
* A1->{A,B}
A n'est pas redondant
* **B est redondant ?**

* B0->{A,B}
* B1->{A,B}
B n'est pas redondant
###### Conclusion : **AB → C n’est pas redondante**
---
### ** C -> A **
* C0 -> {A}
* C1 ->{A}
* **C est redondant**
###### Conclusion : **C → A n’est pas redondante**
---
## BC → D

### Tester B redondant

- C⁺ = {C, A}
- D ∉ C⁺
### Tester C redondant

- B⁺ = {B}
    
- D ∉ B⁺
    

 **BC → D n’est pas redondante**

---

##  CD → B

### Tester C redondant

- D⁺ = {D, E, F}
    
- B ∉ D⁺
    

### Tester D redondant

- C⁺ = {C, A}
    
- B ∉ C⁺
    

 **CD → B est pas redondante**

---

##  BE → C

### Tester B redondant

- E⁺ = {E}
    
- C ∉ E⁺
    

### Tester E redondant

- B⁺ = {B}
    
- C ∉ B⁺
    

 **BE → C n’est pas redondante**

---

## 6️ CE → F

### Tester C redondant

- E⁺ = {E}
    
- F ∉ E⁺
    

### Tester E redondant

- C⁺ = {C, A}
    
- F ∉ C⁺
    

 **CE → F n’est pas redondante**

---

##  CF → B

### Tester C redondant

- F⁺ = {F}
    
- B ∉ F⁺
    

### Tester F redondant

- C⁺ = {C, A}
    
- B ∉ C⁺
    

 **CF → B n’est pas redondante**

---

##  CF → D

### Tester C redondant

- F⁺ = {F}
    
- D ∉ F⁺
    

### Tester F redondant

- C⁺ = {C, A}
    
- D ∉ C⁺
    

 **CF → D n’est pas redondante**

---

##  D → E

- D⁺ (sans D → E) = {D, F}
    
- E ∉ D⁺
    

 **D → E n’est pas redondante**

---

##  D → F

- D⁺ (sans D → F) = {D, E}
    
- F ∉ D⁺
    

 **D → F n’est pas redondante**
---

## 7-Soit la relation suivante : R<E,R,D,P>, {E-→D ; D→R}>

* Solution 1 : Clé primaire est EP car elle dépend pas des autre attributs  donc c'est une 1FN
R1<{E,D}, {E-->D}>
R2<{D,R}, {D-->R}>


| Solution                     | 1   | 2   | 3   | 4   |
| ---------------------------- | --- | --- | --- | --- |
| Préservation des dépendances | Oui | Non | Non | Non |
| Préservation  du contenu     | Non | Oui |     |     |
| Normalité                    | 3FN | 1FN |     |     |



## 8-Soit la relation R suivante :

| A   | B   | C   |
| --- | --- | --- |
| a1  | b1  | c1  |
| a1  | b2  | c3  |
| a2  | b1  | c1  |
| a2  | b4  | c3  |
| a1  | b5  | c1  |
### **a. Dépendances fonctionnelles incorporées**
{B → C}
### **b. Clé candidate**
AB
### **c. Forme normale**
1FN
### **d. relation R est en 3 FNBC ?
* R1(B,C),R2(A,C) :
	* Préservation des dépendances : **oui
	* Préservation du contenu : **non 
*  R1(B,C),R2(A,B):
* Préservation des dépendances : **oui 
* Préservation du contenu : **oui 
## 9-Soit la relation R suivante :
| A   | B   | C   |
| --- | --- | --- |
| a1  | b1  | c1  |
| a1  | b2  | c2  |
| a2  | b1  | c1  |
| a2  | b2  | c3  |
| a3  | b1  | c1  |
F ={C→B ,AB→ C}
### **a. relation R est en 3 FNBC ?
* Clé candidate : AC et AB
* Clé primaire en choisi AB
	* 1FN oui car C dépende de AB
	* 2FN non car C dépend de AB
	* 3FNCB car on a deux dépendance fonctionnel est la partie de droite n'est pas une 
### **b.Si non à la question a ,proposer une décomposition en 3FNBC et vérifier la qualité de la décomposition

* ## Algo de décomposition
	![[Pasted image 20260130153929.png]]
* Cette décomposition conserve le contenu des données mais avec les pertes des dépendances

## 10-Soit la relation suivante :

| A   | B   | C   | D   | E   |
| --- | --- | --- | --- | --- |
|     |     |     | 1   |     |
|     |     |     | 1   |     |
|     |     |     | 1   |     |
|     |     |     | 4   |     |
|     |     |     | 1   |     |
|     |     |     | 1   |     |
|     |     |     | 3   |     |
|     |     |     | 4   |     |
|     |     |     | 5   |     |
### **a. Dépendances fonctionnelles incorporrées
F={A→ E,B→ E,C→ E,D→ E,D→ B} 
### **b. Clé de candidate
ACD
### **c. Forme normale 
1FN
### **d.Algo de synthése
## 1)Algo de synthése

D→ E sans redondant donc on les enlève
Fmin={A→ E,B→ E,C→ E,D→ B} 

* R1(A,E) AVEC F1 {A→ E}
* R2(B,E) AVEC F1 {B→ E}
* R3(C,E) AVEC F1 {C→ E}
* R4(D,B) AVEC F1 {D→ B}
* R5(A,C,D) avec F5{} (CLÉ DE R)
##### Chaque relation est en 3FN sans perte de donnée et de dépendance 

## 2)Algo de décomposition
![[Pasted image 20260130155738.png]]
