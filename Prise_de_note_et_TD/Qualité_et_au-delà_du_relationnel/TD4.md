# Compte rendu – TD4

---
## 1)
```json
[
  {
    "_id": "François Mitterrand",
    "ligne": "L1",
    "type": "tram",
    "lien": [{ "station": "Jamet" }]
  },
  {
    "_id": "Jamet",
    "ligne": "L1",
    "type": "tram",
    "lien": [
      { "station": "François Mitterrand" },
      { "station": "Romanet" }
    ]
  },
  {
    "_id": "Romanet",
    "ligne": "L1",
    "type": "tram",
    "lien": [
      { "station": "Jamet" },
      { "station": "Gare SNCF Nord_L1" }
    ]
  },
  {
    "_id": "Gare SNCF Nord_L1",
    "ligne": "L1",
    "type": "tram",
    "lien": [
      { "station": "Romanet" },
      { "station": "Haluchère-Batignolles" }
    ]
  },

  {
    "_id": "Orvault Grand Val",
    "ligne": "L2",
    "type": "tram",
    "lien": [{ "station": "Morrhonnière-Petit Port" }]
  },
  {
    "_id": "Morrhonnière-Petit Port",
    "ligne": "L2",
    "type": "tram",
    "lien": [
      { "station": "Orvault Grand Val" },
      { "station": "Commerce_L2" }
    ]
  },
  {
    "_id": "Commerce_L2",
    "ligne": "L2",
    "type": "tram",
    "lien": [
      { "station": "Morrhonnière-Petit Port" },
      { "station": "Gare SNCF Nord_L2" }
    ]
  },
  {
    "_id": "Gare SNCF Nord_L2",
    "ligne": "L2",
    "type": "tram",
    "lien": [
      { "station": "Commerce_L2" },
      { "station": "Haluchère-Batignolles" }
    ]
  },

  {
    "_id": "Marcel Paul",
    "ligne": "L3",
    "type": "tram",
    "lien": [{ "station": "Sillon de Bretagne" }]
  },
  {
    "_id": "Sillon de Bretagne",
    "ligne": "L3",
    "type": "tram",
    "lien": [
      { "station": "Marcel Paul" },
      { "station": "Commerce_L3" }
    ]
  },
  {
    "_id": "Commerce_L3",
    "ligne": "L3",
    "type": "tram",
    "lien": [
      { "station": "Sillon de Bretagne" },
      { "station": "Pirmil" }
    ]
  },
  {
    "_id": "Pirmil",
    "ligne": "L3",
    "type": "tram",
    "lien": [{ "station": "Commerce_L3" }]
  },

  {
    "_id": "Gare Maritime",
    "ligne": "N1",
    "type": "navibus",
    "lien": [{ "station": "Trentemoult" }]
  },
  {
    "_id": "Trentemoult",
    "ligne": "N1",
    "type": "navibus",
    "lien": [{ "station": "Gare Maritime" }]
  },
  {
    "_id": "Bas-Chantenay",
    "ligne": "N2",
    "type": "navibus",
    "lien": [{ "station": "Hangar à Bananes" }]
  },
  {
    "_id": "Hangar à Bananes",
    "ligne": "N2",
    "type": "navibus",
    "lien": [{ "station": "Bas-Chantenay" }]
  },
  {
    "_id": "Le Pellerin",
    "ligne": "N3",
    "type": "navibus",
    "lien": [{ "station": "Couëron" }]
  },
  {
    "_id": "Couëron",
    "ligne": "N3",
    "type": "navibus",
    "lien": [{ "station": "Le Pellerin" }]
  }
]


```

---
## 2)
```js
db.TUN.insertMany([

/* L1 */

{_id:"François Mitterrand",ligne:"L1",type:"tram",lien:[{station:"Jamet"}]},

{_id:"Jamet",ligne:"L1",type:"tram",lien:[{station:"François Mitterrand"},{station:"Romanet"}]},

{_id:"Romanet",ligne:"L1",type:"tram",lien:[{station:"Jamet"},{station:"Gare SNCF Nord_L1"}]},

{_id:"Gare SNCF Nord_L1",ligne:"L1",type:"tram",lien:[{station:"Romanet"},{station:"Haluchère-Batignolles"}]},

/* L2 */

{_id:"Orvault Grand Val",ligne:"L2",type:"tram",lien:[{station:"Morrhonnière-Petit Port"}]},

{_id:"Morrhonnière-Petit Port",ligne:"L2",type:"tram",lien:[{station:"Orvault Grand Val"},{station:"Commerce_L2"}]},

{_id:"Commerce_L2",ligne:"L2",type:"tram",lien:[{station:"Morrhonnière-Petit Port"},{station:"Gare SNCF Nord_L2"}]},

{_id:"Gare SNCF Nord_L2",ligne:"L2",type:"tram",lien:[{station:"Commerce_L2"},{station:"Haluchère-Batignolles"}]},

/* L3 */

{_id:"Marcel Paul",ligne:"L3",type:"tram",lien:[{station:"Sillon de Bretagne"}]},

{_id:"Sillon de Bretagne",ligne:"L3",type:"tram",lien:[{station:"Marcel Paul"},{station:"Commerce_L3"}]},

{_id:"Commerce_L3",ligne:"L3",type:"tram",lien:[{station:"Sillon de Bretagne"},{station:"Pirmil"}]},

{_id:"Pirmil",ligne:"L3",type:"tram",lien:[{station:"Commerce_L3"}]},

/* Navibus */

{_id:"Gare Maritime",ligne:"N1",type:"navibus",lien:[{station:"Trentemoult"}]},

{_id:"Trentemoult",ligne:"N1",type:"navibus",lien:[{station:"Gare Maritime"}]},

{_id:"Bas-Chantenay",ligne:"N2",type:"navibus",lien:[{station:"Hangar à Bananes"}]},

{_id:"Hangar à Bananes",ligne:"N2",type:"navibus",lien:[{station:"Bas-Chantenay"}]},

{_id:"Le Pellerin",ligne:"N3",type:"navibus",lien:[{station:"Couëron"}]},

{_id:"Couëron",ligne:"N3",type:"navibus",lien:[{station:"Le Pellerin"}]}

])
```
---
## 3)

### a) Trouver les stations desservies par navibus



```js
db.TUN.find(
  { type: "navibus" },
  { _id: 1, ligne: 1 }
)

```

---

### b) Trouver les stations qui ne sont pas des terminus

```js
db.TUN.find(

{ "lien.1": { $exists: true } },

{ _id: 1, ligne: 1, type: 1 }

)
```

---
### c) Trouver les stations desservies en partant d’une station quelconque
```js
db.TUN.find(

{ "lien.1": { $exists: true } },

{ _id: 1, ligne: 1, type: 1 }

)
```

### d) Trouver les stations desservies en partant de Commerce
```js
db.TUN.find(

{ "lien.1": { $exists: true } },

{ _id: 1, ligne: 1, type: 1 }

)
```