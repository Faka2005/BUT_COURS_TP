
# Chapitre 1

## Exercice 1

### Rappel

#### 1) Quelques mots
- `00`
- `10`
- `111111010000`

##### En compréhension
- \( M_n = \{ m \mid \ \} \)
- \( M_n \)
- \( M_n \)
- …

---

#### 2) Définition de \( M_n \)

- \( M_n \) : ensemble des mots de longueur **n**, avec **n ∈ ℕ**
- Rappel :
  - Un ensemble peut être défini :
    - par **énumération**
    - ou par **compréhension**

---

#### 3) Méthodes

1.  
   \[
   M = \{ m \mid m = 1^* m_q 0^* \dots,\; m_q \in A^* \}
   \]

2.  
   \[
   M = \{ m \mid \ \}
   \]

---

#### 4)
\[
M = \{ \}
\]

---

#### 5)
> Les parenthèses sont en puissances (+)

\[
M = \{ \}
\]

---

#### 6)
\[
M = \{ \}
\]

---

#### 7) Q7 – Mots contenant **A**
- Le code ASCII de **A** est :
  - `41` en **hexadécimal**

---

#### 8)
- `red`

#### 9)
- `vefd`

#### 10)
- ❌ Pas faite

#### 11)
- ❌ Pas faite

#### 12)
- ❌ Non, on n’a pas assez de données

---

## Exercice 2

### 1) Exemples
- `dorefasol`
- `fasolredo`
- `dodododo`
- `doredoredore`

---

### 2) Exemples
- `misila`
- `misisimi`

---

### 3)
\[
A_3 = A_1 \cup A_2
\]

---

### 4)
\[
A_4 = A_3 \setminus A_1
\]
\[
A_4 = (A_1 \cup A_2) \setminus A_1 = A_2
\]

---

### 5)
\[
A_5 = A_3 \cap A_1
\]

---

### 6)
…

---

### 7)
\[
M = \{ m \mid \ \}
\]

---

## Exercice 3

### 1) Alphabet
\[
A = \{T, S, D, E, G, R, B, A, V, F, -, 3, 6, 7, 0, 2, 8, 9\}
\]

---

### 2)
- L’alphabet **A ne suffit pas**
- Il faut ajouter :
  - des **marques**
  - une **structure**
  - des règles de **validation**

---

### 3) Décomposition des alphabets

\[
A_1 = \{A, \dots, Z\}
\]

\[
A_2 = \{0, \dots, 9\}
\]

\[
A = A_1 \cup A_2 \cup \dots
\]

#### Structure du langage
\[
M = \{ \}
\]

---

## Exercice 4
- Design sur la feuille

---

## Exercice 5
…



## Chapitre 2

### Exercice 1

#### f) Suite de dérivations (rappel)

Dérivation à partir de l’axiome `P` :

```text
P
⇒ I SI
⇒ V = V OP E SI
⇒ x = V OP E SI
```

Notation condensée (comme dans le cours) :

```text
P ⇒³ x = V OP E SI
```

---



# Chapitre 2

### Exercice 1

#### f) Dérivation
```md
P  
⇒ I SI  
⇒ V = V OP E SI  
⇒ x = V OP E SI  

On note :
P ⇒³ x = V OP E SI
```

---

### Variante encore plus claire (pour révisions)

```md
- Axiome : `P`
- Dérivations :
  - `P ⇒ I SI`
  - `I ⇒ V = V OP E`
  - `V ⇒ x`

Résultat :
`P ⇒³ x = V OP E SI`
```

---

### Exercice 2

  

#### 1)

  

- ⇒ `x = x * 2 ; x = x - V OP E SI`
    
- ⇒ `x = x * 2 ; x = x - x OP E SI`
    
- ⇒ `x = x * 2 ; x = x - x - E SI`
    
- ⇒ `x = x * 2 ; x = x - x - V OP E SI`
    
- ⇒ `x = x * 2 ; x = x - x - x OP E SI`
    
- ⇒ `x = x * 2 ; x = x - x - x + E SI`
    
- ⇒ `x = x * 2 ; x = x - x - x + 7 SI`
    
- ⇒ `x = x * 2 ; x = x - x - x + 7`
2)x - x - x + 7
        ↑
      V OP E
            ↑
          V OP E
                ↑
                7 → E





3)
----
### Exercice 3

#### 1) Pour les expression arithmétiques :
G =<T,N,S,R>
T={2,4,3,x,y,+,-,*}
N={P,IOP,V,C,A} 
S = P
R={
	⇒ P --> I
	⇒ I --> V OP V
	⇒ OP--> +|-|*|
	⇒ P --> C|A
	⇒ P --> I
	⇒ P --> I
	⇒ P --> I
	⇒ P --> I
}




### Exercice 4

#### 1)
Feature= void | public |void | synchronized|  abstract |final
ListParamType =int , ListInt
NomFonction= a|...|z |A...|Z

G =<T,N,S,R>
T={}
N={S,NomFonction,ListParamType,Feature} 
S = P
R={
	⇒ 
	⇒
	⇒ 
	⇒ 
	⇒
	⇒ 
	⇒ 
	⇒
}











### Exercice 7

#### 1) 
```md
Mot = le | la | chat | bouteille
Verbe = avale | mange
<Phrase> ::= <Debut> <Verbe> <Suite>

<Mot>    ::= "le" | "la" | "chat" | "bouteille"
<Verbe>  ::= "avale" | "mange"
```



### Exercice 8

### 1)
```md 
L={w |w∈ A* et w =w1*1}
```

# Chapitre 3
### Exercice 1
##### 1) Ils possèdent 5 états.

##### 2) 
* États initiale :e0
* États finaux: e2 et e4
	##### 3)Oui  car 
##### 3)Oui  car il y a δ
##### 4)Forme de fonction de δ :  S *  A -> S    
δ:{
 * ((Eo,a)->E1),
 * ((E1,b)->E2),
 * ((E1,c)->E3),
 * ((E2,b)->E1),
 * ((E2,C)->E4),
 * ((E3,b)->E4),
 * ((E4,E)->E3),
 * ((E4,D)->E0),
}

##### 5)A1:On est bloqué à E0 car la première lettre n'est pas a .
##### 6)L'état de A1 est A3 car on est pas bloqué à un moment .
##### 7)Un automate accepteur reconnait un mot à partir de son état initiale .
##### 8)Automate Mealy .
##### 9)Il n'est reconnu car commence par l'état initiale(e0) et termine pas un état finale(E2 ou E4).
##### 10)oui  car (abebebecbeb) et (abcdabcebdacb)finit en e4 .

### Exercice 2

##### 1)
* ababccb
* abccbabc
##### 2)
##### 3)
* Couples:
{
(E1,A),E1
(E1,C)1E3
}
##### 4)E1->E2->E1->E3->E3->E3->E3

### Exercice 3
### Smiley :   :-(   :-D  :-[  :-{   
![[Pasted image 20260203143302.png]]


### Exercice 4
* Écrire un automate qui permet de reconnaître des entiers pairs non nuls.
 ![[Pasted image 20260203145321.png]]

### Exercice 5

##### 1)
##### 2)L'automate reconnait si un mot donner est du format hh(0 à23):mm(00 à 59) 
##### 3)
* S={E0,H1,H2,H,M1,M2,M,Err}
* A={0,1,2,3,4,5,6,7,8,9,:}
* S0=E0
* Sfinal={}
* delta:

##### 4et 5)Probléme:
* On va pas au bout du mot
* Plusieurs finaux

##### 6)

### Exercice 6

##### 1)

##### 2)
##### 3)
##### 4)
##### 5)
### Exercice 21 page 22

Alphabet A={a,b,c,d,e,f}
##### 1)M={m =a((be)$^*$ (bc | cb (cb)$^*$)) (da (be) $^*$(bc | cb (eb)$^*$))$^*$





class automate{
Stats
Alphabets
InitialState
FinalStates
delta
}
class State{
name

}