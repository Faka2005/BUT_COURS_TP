#  FICHE DE RÉVISION – BASES DE DONNÉES (SCHÉMA RELATIONNEL)

---

##  1) Clés candidates
 Une **clé candidate** est :
- Un **ensemble minimal d’attributs**
- Qui permet d’identifier **de façon unique** chaque tuple

 Caractéristiques :
- Unicité
- Minimalité
- Il peut y avoir **plusieurs clés candidates**

Exemple :
- AB⁺ = {A, B, C} → AB est clé candidate
- A seul ❌ / B seul ❌

---

## 2) Clé primaire (clé de relation)
 La **clé primaire** est :
- **UNE clé candidate choisie**


 Règles :
- Unique
- Non nulle
- Une seule par relation

 **Toute clé primaire est une clé candidate, mais pas l’inverse**

---

##  3) Dépendance fonctionnelle (DF)
 Il y a une dépendance fonctionnelle `X → Y` si :
> Pour chaque valeur de **X**, il existe **une seule valeur unique de Y**

 Exemple :
- No-étudiant → Nom
- Promo → Libellé-promo

 Pas une DF :
- Nom → No-étudiant

---

##  4) Formes normales

---

###  1FN – Première Forme Normale
Une relation est en **1FN** si :
- Valeurs **atomiques**
- Pas de listes
- Une seule valeur par cellule

---

### 🔹 2FN – Deuxième Forme Normale
Une relation est en **2FN** si :
- Elle est en **1FN**
- Tous les attributs **non-clés** dépendent **totalement** de la clé
- ❗ Pas de dépendance partielle

📌 Concerne uniquement les **clés composées**

❌ Exemple :
- Clé = {No-étudiant, No-matière}
- No-étudiant → Nom

---

### 🔹 3FN – Troisième Forme Normale
Une relation est en **3FN** si :
- Elle est en **2FN**
- Pas de **dépendance transitive**
- Les attributs non-clés dépendent **directement** de la clé

❌ Exemple :
- No-étudiant → Promo
- Promo → Libellé-promo

---

### 🔹 BCNF / 3NFBC – Boyce-Codd
Une relation est en **BCNF** si :
- Elle est en **3FN**
- Pour toute DF `X → Y`, **X est une clé candidate**

📌 Plus stricte que la 3FN

---

## 🧪 Exemple clé (à savoir refaire)

Relation R(A, B, C)

```markdown
| A | B | C |
|---|---|---|
| 1 | 2 | 4 |
| 2 | 2 | 4 |
| 3 | 2 | 4 |
| 3 | 5 | 6 |
| 5 | 5 | 7 |
```

##  4) Automates
### 1)Automates déterministe
Exemple: 

### 2)Automates non déterministe
Exemple: 