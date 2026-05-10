# Compte rendu – TD3

---

## 1)Insertion d’un produit

**Objectif :** Insérer un produit avec les informations suivantes :  
`_id = 1`, `libelle = orange`, `prixU = 20`, `dateFab = 2023-02-06T20:20:13Z`

```js
db.produit.insertOne({
  _id: 1,
  libelle: "orange",
  prixU: 20,
  dateFab: new Date("2023-02-06T20:20:13Z")
});
```

---

## 2) Affichage du produit inséré

```js
db.produit.findOne({ _id: 1 });
```

---

## 3)Modification du prix unitaire

**Objectif :** Mettre à jour `prixU` à `100`

```js
db.produit.updateOne(
  { _id: 1 },
  { $set: { prixU: 100 } }
);
```

---

## 4) Ajout du champ `Etat`

```js
db.produit.updateOne(
  { _id: 1 },
  { $set: { Etat: "Frais" } }
);
```

---

## 5) Suppression du champ `Etat`

```js
db.produit.updateOne(
  { _id: 1, Etat: { $exists: true } },
  { $unset: { Etat: "" } }
);
```

---

## 6) Suppression du produit numéro 1

```js
db.produit.deleteOne({ _id: 1 });
```

---

## 7) Suppression de la collection `produit`

```js
db.produit.drop();
```

---

## 8) Réinsertion du produit numéro 1

```js
db.produit.insertOne({
  _id: 1,
  libelle: "orange",
  prixU: 20,
  dateFab: new Date("2023-02-06T20:20:13Z")
});
```

---

## 9) Remplacement du produit (replaceOne)

```js
db.produit.replaceOne(
  { _id: 1 },
  {
    _id: 1,
    libelle: "Salade",
    prixU: 20,
    dateFab: new Date("2023-02-06T20:20:13Z")
  }
);
```

---

## 10) Insertion d’un second produit

```js
db.produit.insertOne({
  _id: 2,
  libelle: "chou",
  prixU: 15,
  dateFab: new Date("2023-01-06T20:20:13Z")
});
```

---

## 11) Ajout du champ `qte` (date > 01/04/2022)

```js
db.produit.updateMany(
  { dateFab: { $gt: new Date("2022-04-01T00:00:00Z") } },
  { $set: { qte: 0 } }
);
```

---

## 12 Suppression du produit numéro 1

```js
db.produit.deleteOne({ _id: 1 });
```

---

## 13)Affichage du libellé des produits dont le prix > 10

```js
db.produit.find(
  { prixU: { $gt: 10 } },
  { _id: 0, libelle: 1 }
);
```

---

## 14) Suppression de tous les produits

```js
db.produit.deleteMany({});
```

---

## 15) Insertion multiple de produits

```js
db.produit.insertMany([
  { _id: 1, libelle: "chou", prixU: 5, qte: 7, dateFab: new Date("2022-03-01T08:00:00Z") },
  { _id: 2, libelle: "tomate", prixU: 10, qte: 2, dateFab: new Date("2021-03-01T08:00:00Z") },
  { _id: 3, libelle: "oignon", prixU: 20, qte: 1, dateFab: new Date("2021-03-01T09:00:00Z") },
  { _id: 4, libelle: "salade", prixU: 5, qte: 10, dateFab: new Date("2021-03-15T09:00:00Z") },
  { _id: 5, libelle: "tomate", prixU: 5, qte: 20, dateFab: new Date("2021-04-04T11:21:39.736Z") },
  { _id: 6, libelle: "chou", prixU: 10, qte: 10, dateFab: new Date("2021-04-04T21:23:13.331Z") },
  { _id: 7, libelle: "oignon", prixU: 7.5, qte: 5, dateFab: new Date("2022-06-04T05:08:13Z") },
  { _id: 8, libelle: "tomate", prixU: 7.5, qte: 10, dateFab: new Date("2022-09-10T08:43:00Z") },
  { _id: 9, libelle: "tomate", prixU: 10, qte: 5, dateFab: new Date("2023-02-06T20:20:13Z") }
]);
```

---

## 16) Affichage de tous les produits

```js
db.produit.find();
```

---

## 17) Nombre total de produits

```js
db.produit.countDocuments();
```

---

## 18) Produits fabriqués entre le 03/04/2021 et le 05/04/2023

```js
db.produit.find({
  dateFab: {
    $gte: new Date("2021-04-03T00:00:00Z"),
    $lte: new Date("2023-04-05T23:59:59Z")
  }
});
```

---

## 19) Afficher tous les produits sauf "tomate"

```js
db.produit.find({ libelle: { $ne: "tomate" } });
```

---

## 20) Prix des produits dont le libellé a moins de 5 lettres

```js
db.produit.find(
  {
    $expr: { $lt: [ { $strLenCP: "$libelle" }, 5 ] }
  },
  { _id: 0, prixU: 1 }
);
```

---

## 21) Prix et date de fabrication des choux

```js
db.produit.aggregate([
  { $match: { libelle: "chou" } },
  {
    $project: {
      _id: 0,
      prixU: 1,
      dateFab: 1
    }
  }
]);
```

---

## 22) Ajout et affichage de l’origine "France"

```js
db.produit.aggregate([
  { $match: { libelle: { $exists: true } } },
  { $addFields: { origine: "France" } },
  {
    $project: {
      _id: 0,
      libelle: 1,
      origine: 1
    }
  }
]);
```

---

## 23) Montant de chaque produit (prix × quantité)

```js
db.produit.aggregate([
  {
    $project: {
      _id: 0,
      libelle: 1,
      prixU: 1,
      qte: 1,
      montant: { $multiply: ["$prixU", "$qte"] }
    }
  }
]);
```

---
## 24) Prix moyen de chacun des produits par libellé

```js
db.produit.aggregate([
  { 
    $group: {
      _id:"$libelle",
      prixMoyen:{$avg:"$prixU"}
    },
    $project:{
	 _id:0,
	 libelle:"$_id",
	 prixMoyen:1_ 
    }
  }
]);
```



---

## 1) Insérer les documents dans la collection `vendeur`

```js
db.vendeur.insertMany([
  {
    _id: "f1",
    nom: "Alfred",
    statut: 20,
    ville: "Londres",
    ventes: [
      { _id: 1, qte: 7, date: new Date("2022-03-01T08:00:00Z") },
      { _id: 2, qte: 2, date: new Date("2021-03-01T08:00:00Z") }
    ]
  },
  {
    _id: "f2",
    nom: "Robert",
    statut: 10,
    ville: "Paris",
    ventes: [
      { _id: 3, qte: 1, date: new Date("2021-03-01T09:00:00Z") },
      { _id: 4, qte: 10, date: new Date("2021-03-15T09:00:00Z") },
      { _id: 1, qte: 2, date: new Date("2022-05-16T10:00:00Z") },
      { _id: 7, qte: 4, date: new Date("2022-03-01T09:00:00Z") }
    ]
  },
  {
    _id: "f3",
    nom: "Raymonde",
    statut: 30,
    ville: "Paris",
    ventes: [
      { _id: 2, qte: 20, date: new Date("2021-04-04T11:21:39.736Z") },
      { _id: 1, qte: 10, date: new Date("2021-04-04T21:23:13.331Z") },
      { _id: 4, qte: 7, date: new Date("2022-10-23T21:23:13.331Z") },
      { _id: 5, qte: 12, date: new Date("2022-09-21T21:23:13.331Z") }
    ]
  },
  {
    _id: "f4",
    nom: "Gaston",
    statut: 20,
    ville: "Londres",
    ventes: [
      { _id: 3, qte: 5, date: new Date("2022-06-04T05:08:13Z") },
      { _id: 2, qte: 10, date: new Date("2022-09-10T08:43:00Z") }
    ]
  },
  {
    _id: "f5",
    nom: "Hector",
    statut: 30,
    ville: "Nantes",
    ventes: [
      { _id: 2, qte: 5, date: new Date("2023-02-06T20:20:13Z") }
    ]
  }
]);
```

---

## 2) Afficher tous les documents

```js
db.vendeur.find({});
```

---

## 3) Trier par nom (croissant) et identifiant (décroissant)

```js
db.vendeur.find().sort({ nom: 1, _id: -1 });
```

---

## 4) Lister les vendeurs (nom et ville)

```js
db.vendeur.find(
  {},
  { _id: 0, nom: 1, ville: 1 }
);
```

---

## 5) Nom, statut et ville du vendeur `f4`

```js
db.vendeur.find(
  { _id: "f4" },
  { _id: 0, nom: 1, statut: 1, ville: 1 }
);
```

---

## 6) Vendeurs de Paris

```js
db.vendeur.find({ ville: "Paris" });
```

---

## 7) Vendeurs de Paris ou Londres

```js
db.vendeur.find({
  $or: [{ ville: "Paris" }, { ville: "Londres" }]
});
```

---

## 8) Vendeurs de Paris avec statut entre 10 et 20

```js
db.vendeur.find(
  {
    ville: "Paris",
    statut: { $gte: 10, $lte: 20 }
  },
  { _id: 0, nom: 1, statut: 1, ville: 1 }
);
```

---

## 9) Nombre total de ventes

```js
db.vendeur.aggregate([
  {
    $group: {
      _id: null,
      totalVentes: { $sum: { $size: "$ventes" } }
    }
  },
  {
    $project: { _id: 0, totalVentes: 1 }
  }
]);
```

---

## 10) Nombre total de ventes par vendeur

```js
db.vendeur.aggregate([
  {
    $project: {
      _id: 0,
      nom: 1,
      nombreVentes: { $size: "$ventes" }
    }
  }
]);
```

---

## 11) Nombre total de ventes du produit n°3

```js
db.vendeur.aggregate([
  {
    $project: {
      ventesProduit: {
        $size: {
          $filter: {
            input: "$ventes",
            as: "v",
            cond: { $eq: ["$$v._id", 3] }
          }
        }
      }
    }
  },
  {
    $group: {
      _id: null,
      totalVentes: { $sum: "$ventesProduit" }
    }
  },
  { $project: { _id: 0, totalVentes: 1 } }
]);
```

---

## 12) Ventes effectuées le 04/04/2021 à 11h

```js
db.vendeur.aggregate([
  {
    $project: {
      ventesProduit: {
        $size: {
          $filter: {
            input: "$ventes",
            as: "v",
            cond: {
              $eq: ["$$v.date", new Date("2021-04-04T11:00:00Z")]
            }
          }
        }
      }
    }
  },
  {
    $group: {
      _id: null,
      totalVentes: { $sum: "$ventesProduit" }
    }
  },
  { $project: { _id: 0, totalVentes: 1 } }
]);
```

---

## 13)Ventes après le 04/04/2021 à 11h

```js
db.vendeur.aggregate([
  {
    $project: {
      ventesProduit: {
        $size: {
          $filter: {
            input: "$ventes",
            as: "v",
            cond: {
              $gte: ["$$v.date", new Date("2021-04-04T11:00:00Z")]
            }
          }
        }
      }
    }
  },
  {
    $group: {
      _id: null,
      totalVentes: { $sum: "$ventesProduit" }
    }
  },
  { $project: { _id: 0, totalVentes: 1 } }
]);
```

---

## 14) Vendeurs ayant vendu les produits 2 **et** 3

```js
db.vendeur.find({
  ventes: {
    $all: [
      { $elemMatch: { _id: 2 } },
      { $elemMatch: { _id: 3 } }
    ]
  }
}).count();
```

---
## 15) Nombre de vendeurs qui ont vendu **exactement deux produits**

👉 Ici on parle du **nombre de ventes (taille du tableau)**, pas des produits 2 et 3.
```js
db.vendeur.find({   $expr: { $eq: [{ $size: "$ventes" }, 2] } }).count();
```


---
## 16)Total des ventes de chaque vendeur (nom + total)


```js
db.vendeur.aggregate([
  {
    $project: {
      _id: 0,
      nom: 1,
      totalVentes: { $size: "$ventes" }
    }
  }
]);

```


---
## 17) Villes des vendeurs (sans doublons)

```js
db.vendeur.distinct("ville");
```

---

## 18) Nombre de vendeurs par ville

```js
db.vendeur.aggregate([
  {
    $group: {
      _id: "$ville",
      nombreVendeurs: { $sum: 1 }
    }
  },
  {
    $project: {
      _id: 0,
      ville: "$_id",
      nombreVendeurs: 1
    }
  }
]);
```

---
## 19) Nombre total de vendeurs

```js
db.vendeur.countDocuments();
```

---

## 20) Noms des vendeurs qui vendent des **choux**

```js
db.vendeur.aggregate([
  { $unwind: "$ventes" },
  {
    $lookup: {
      from: "produit",
      localField: "ventes._id",
      foreignField: "_id",
      as: "produit"
    }
  },
  { $unwind: "$produit" },
  { $match: { "produit.libelle": "chou" } },
  {
    $group: {
      _id: "$nom"
    }
  },
  {
    $project: {
      _id: 0,
      nom: "$_id"
    }
  }
]);
```

---

## 21) Ajouter la couleur dans la collection `produit`


```js
db.produit.updateMany({ libelle: "tomate" },  { $set: { couleur: "rouge" } });
db.produit.updateMany({ libelle: "brocoli" }, { $set: { couleur: "vert" } });
db.produit.updateMany({ libelle: "chou" },    { $set: { couleur: "vert" } });
db.produit.updateMany({ libelle: "salade" },  { $set: { couleur: "vert" } });
db.produit.updateMany({ libelle: "oignon" },  { $set: { couleur: "jaune" } });
```

---

## 22) Noms des vendeurs qui **ne vendent aucun produit rouge**

```js
db.vendeur.aggregate([
  {
    $lookup: {
      from: "produit",
      localField: "ventes._id",
      foreignField: "_id",
      as: "produits"
    }
  },
  {
    $match: {
      produits: {
        $not: { $elemMatch: { couleur: "rouge" } }
      }
    }
  },
  {
    $project: {
      _id: 0,
      nom: 1
    }
  }
]);
```

---

## 23) Noms des vendeurs qui vendent **uniquement des produits rouges**

```js
db.vendeur.aggregate([
  {
    $lookup: {
      from: "produit",
      localField: "ventes._id",
      foreignField: "_id",
      as: "produits"
    }
  },
  {
    $match: {
      produits: {
        $not: { $elemMatch: { couleur: { $ne: "rouge" } } }
      }
    }
  },
  {
    $project: {
      _id: 0,
      nom: 1
    }
  }
]);
```

---

## 24) Nombre total de **produits verts vendus** (tous vendeurs confondus)



```js
db.vendeur.aggregate([
  { $unwind: "$ventes" },
  {
    $lookup: {
      from: "produit",
      localField: "ventes._id",
      foreignField: "_id",
      as: "produit"
    }
  },
  { $unwind: "$produit" },
  { $match: { "produit.couleur": "vert" } },
  {
    $group: {
      _id: null,
      nombreProduitsVerts: { $sum: 1 }
    }
  },
  {
    $project: {
      _id: 0,
      nombreProduitsVerts: 1
    }
  }
]);
```

---

## 25) Numéros des vendeurs ayant vendu **au moins deux produits verts différents**

```js
db.vendeur.aggregate([
  { $unwind: "$ventes" },
  {
    $lookup: {
      from: "produit",
      localField: "ventes._id",
      foreignField: "_id",
      as: "produit"
    }
  },
  { $unwind: "$produit" },
  { $match: { "produit.couleur": "vert" } },
  {
    $group: {
      _id: "$_id",
      produitsVerts: { $addToSet: "$produit._id" }
    }
  },
  {
    $match: {
      $expr: { $gte: [{ $size: "$produitsVerts" }, 2] }
    }
  }
]);
```

---
## 26) Vendeurs qui vendent **tous les produits jaunes**

```js
db.vendeur.aggregate([
  { $unwind: "$ventes" },
  {
    $lookup: {
      from: "produit",
      localField: "ventes._id",
      foreignField: "_id",
      as: "produit"
    }
  },
  { $unwind: "$produit" },
  { $match: { "produit.couleur": "jaune" } },
  {
    $group: {
      _id: "$_id",
      produitsJaunesVendus: { $addToSet: "$produit._id" }
    }
  },
  {
    $lookup: {
      from: "produit",
      pipeline: [
        { $match: { couleur: "jaune" } },
        { $group: { _id: null, tousJaunes: { $addToSet: "$_id" } } }
      ],
      as: "tousProduitsJaunes"
    }
  },
  { $unwind: "$tousProduitsJaunes" },
  {
    $match: {
      $expr: {
        $eq: [
          "$produitsJaunesVendus",
          "$tousProduitsJaunes.tousJaunes"
        ]
      }
    }
  },
  { $project: { _id: 1 } }
]);
```

---
