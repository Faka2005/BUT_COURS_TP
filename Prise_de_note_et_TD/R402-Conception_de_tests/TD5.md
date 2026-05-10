
(Alphabétique)
Pour tester A il faut une doublure de B 
B ->C 
retester A
C
retester B
D->E,G

E->F,G
F->I,H
retester E
G->H
H
retester G
I 
retester f

**5.2.1**
top-down(profondir):
D bessoin doublure de G ,E
G bessoin doublure de H ,E
H bessoin doublure de F
F bessoin doublure de I
retester H
I
retester I
E bessoin doublure de A
retester D, G
A bessoin doublure de B
retester E
B bessoin doublure de C
retester A
C pas bessoin doublure 
retester B

**5.2.2**
top-down(largeur):
D bessoin doublure de G E
G bessoin doublure de H E
E bessoin doublure de A F
retester D
H bessoin doublure de F
retester F
A bessoin doublure de B
F bessoin doublure de  I
retester E H
B bessoin doublure de C
retester A
I pas bessoin doublure 
retester F
C pas bessoin doublure 
retester B

**5.2.3**
bottom-up:
C bessoin doublure de B
B pas bessoin doublure
retester B
A pas bessoin doublure
I bessoin doublure de F G
F bessoin doublure de H
H pas bessoin doublure 
E bessoin doublure de G
G pas bessoin doublure de
D pas bessoin doublure 

**5.3.1**

CFC1 =BC   =ALPHA,CFC2 =BETA= IFHGE

**5.3.2**
D->ALPHA->A->BETA    

**5.3.3**
ordre partiel d'intégration:
alpha puis A puis Beta puis D
**5.3.4**

CFC1 :



| Noeud | Cycle | ARC intérieur | Arc extérieur |
| ----- | ----- | ------------- | ------------- |
| B     | 1     | 1             | 1             |
| C     | 1     | 1             | 0             |


Ordre d'intéfration  :
C bessoin de doublure de B 
B
retester C

CFC2 :


`mardown
CFC 2

| Noeud | Cycle               |
| ----- | ------------------- |
| E     | 2 (EG,EFIG)         |
| F     | 4 (FI,FH,FIGH,FIGE) |
| G     | 3(GE,GHFI,GEFI)     |
| H     | 2(HF,HFIG)          |
| I     | 3(IGEF,IF,IGHF)     |

`
CFC2-F

| Noeud | Cycle | ARC intérieur | Arc extérieur |
| ----- | ----- | ------------- | ------------- |
| E     | 1     | 1             | 1             |
| F     | 1     | 1             | 0             |
| G     |       |               |               |
| H     |       |               |               |
| I     |       |               |               |
 F ET G Candidat 
CFC :G ,E
Inverse arc entrant dans G
Efface arc sortant de F
Inverse arc déjà traité dans le CFC

![[Pasted image 20260211105449.png]]         
Bottom-up :
I (G,F)
H(F) 
F
reteste H
E(G)
G
reteste I
retester E

aplpha puis Apuis deta puis D 

C (B)
B
reteste C
A
I (G,F)
H(F) 
F
reteste H
E(G)
G
reteste I
retester E
D

**5.4.1**

C (B)  2h +1h
B  2h
reteste C 30 min
A 2h
I (G,F) 2h +1h+1h
H(F) 2+1
F 2
reteste H 30 min
E(G) 2+1
G 2
reteste I 30 min
retester E 30 min
D 2

**5.5.1**


