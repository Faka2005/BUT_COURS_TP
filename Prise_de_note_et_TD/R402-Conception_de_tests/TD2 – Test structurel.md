
## Constructeur `BasicAlarmClock`
##### Graphe de flot de contrôle:
![[Pasted image 20260128103846.png]]
###### Expression : `A[ B | C [ D | E [F | G [H | E [J | KL] ] ] ] ]`

si l'oracle est vide alors est peut prendre n'importe quel valeur

| Chemin  | Cas de test | valeur de l'oracle |
| ------- | ----------- | ------------------ |
| ACEGIKL | 1,0,0       | 1,0,0,False,False  |
| ACEGIJ  | 0,0,0       | throw              |
| ACEGH   | 0,0,60      |                    |
| ACEF    | 0,0,-1      |                    |
| ACD     | 0,24,0      |                    |
| AB      | 0,-1,0      |                    |


## Fonction `selectRing`

##### Graphe de  flot de contrôle:
![[Pasted image 20260128103914.png]]
##### Expression : `AB [C [D |EFG]|FG]` ou `AB [CD |CEFG]|FG]` ou `AB [CD |(CE)?|FG]`

| Chemin | Cas de test | valeur de l'oracle |
| ------ | ----------- | ------------------ |
| ABCEFG | 1,False     | modified =False,   |
| ABCD   | 0,False     | throw              |
| ABFG   | 0,True      | modified =False,   |




## Fonction `addMin`
##### Graphe de  flot de contrôle:

![[Pasted image 20260128103936.png]]
##### Expression : `AB [C|D[ED]*F GH?IJ[KJ]*[LM]`

| Chemin         | Cas de test | valeur de l'oracle=résultat des test              |
| -------------- | ----------- | ------------------------------------------------- |
| ABC            | (-1,0,0)    | throw                                             |
| ABDEDFGHIJKLM  | (61,59,22)  | (0,0)                                             |
| ABDFGIJKLM     | (0,0,0)     | (0,0)<br>                                         |
| ABDEFDFGHIJKLM | (61,59,0)   | (2,0)<br>                                         |
| ABDEFDFGIJKLM  | (60,0,23)   | (0,0)<br>                                         |
| ABDEFDFGHIJLM  | (60,0,0)    | (1,0)<br>                                         |
| ABDFGHIJKLM    | (1,59,23)   | (0,0)<br>                                         |
| ABDFGHIJLM     | (1,59,0)    | (1,0)<br>                                         |
| ABDFGIJKLM     | (0,0,?)     | (n'importe quel valeur,n'importe quel valeur)<br> |
| ABDFGIKJKJLM   |             |                                                   |



## Fonction `switchOff`
##### Graphe de  flot de contrôle:
##### Expression : ``
| Chemin         | Cas de test | valeur de l'oracle=résultat des test              |
| -------------- | ----------- | ------------------------------------------------- |
|                |             |                                                   |
|                |             |                                                   |
|                |             |                                                   |
|                |             |                                                   |
|                |             |                                                   |
|                |             |                                                   |
|                |             |                                                   |
|                |             |                                                   |
|                |             |                                                   |
|                |             |                                                   |