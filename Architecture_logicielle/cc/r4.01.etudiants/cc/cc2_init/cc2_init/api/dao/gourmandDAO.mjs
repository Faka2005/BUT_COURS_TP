import { mongoose, Schema } from "mongoose";
import Gourmand from "../model/GourmandModele.mjs";
import Gateau from "../model/GateauModele.mjs";

const schema = new mongoose.Schema({
  nom: { type: String, required: true },
  gateaux: [
    {
      gateau: { nom: String, calories: Schema.Types.Int32 },
      nombre: Schema.Types.Int32,
    },
  ],
});

const MongoGourmand = new mongoose.model("gourmandCollection", schema);

const gourmandAdapter = (obj) => {
  if (obj != null) {
    //obj = obj.toJSON()
    const gourmand = new Gourmand(obj.nom);
    obj.gateaux.forEach((e) => {
      while (e.nombre != 0) {
        gourmand.achete(new Gateau(e.gateau));
        e.nombre--;
      }
    });
    return gourmand;
  }
  return null;
};
const projection = { _id: 0, __v: 0 };

const gourmandDAO = {
  removeAll: async () => await MongoGourmand.deleteMany({}),
  findAll: async () => {
    const data = await MongoGourmand.find({}, projection);

    return data.map((obj) => gourmandAdapter(obj));
  },
  addOne: async (gourmand) => {
    if (!(gourmand instanceof Gourmand))
      return Promise.reject("gourmand n'est pas un gourmand");
    if ((await gourmandDAO.findOne(gourmand.nom)) != null)
      return Promise.reject("Le gourmand existe déjà");
    try {
      await MongoGourmand.insertOne(gourmand.toJSON());
      return await gourmandDAO.findOne(gourmand.nom);
    } catch (e) {
      return Promise.reject("Gourmand non ajouté");
    }
  },
  findOne: async (nom) => {
    nom = nom.toUpperCase();
    let obj = await MongoGourmand.findOne({ nom: nom }, projection);
    return gourmandAdapter(obj);
  },
  removeOne: async (nom) => {
    nom = nom.toUpperCase();
    return await MongoGourmand.deleteOne({ nom: nom });
  },
  //-----------------------------------------
  //TODO compléter achete
  //---------------------------------------------

 achete: async (nom, gateau) => {
  nom = nom.toUpperCase();

  // Vérification entrée
  if (!gateau || !gateau.nom) {
    throw "Gâteau invalide";
  }

  //  Récupérer le gourmand
  const gourmand = await MongoGourmand.findOne({ nom: nom });

  if (!gourmand) {
    throw "Gourmand non trouvé";
  }

  //  Vérifier conflit (même nom, calories différentes)
  const conflit = gourmand.gateaux.find(
    g =>
      g.gateau.nom === gateau.nom &&
      g.gateau.calories !== gateau.calories
  );

  if (conflit) {
    throw "Achat impossible";
  }

  try {
    //  Essayer d'incrémenter si le gâteau existe déjà
    const result = await MongoGourmand.updateOne(
      { nom: nom, "gateaux.gateau.nom": gateau.nom },
      { $inc: { "gateaux.$.nombre": 1 } }
    );

    //  Si pas trouvé → on ajoute
    if (result.modifiedCount === 0) {
      await MongoGourmand.updateOne(
        { nom: nom },
        {
          $push: {
            gateaux: {
              gateau: {
                nom: gateau.nom,
                calories: gateau.calories,
              },
              nombre: 1,
            },
          },
        }
      );
    }

    // Retourner le gourmand mis à jour
    return await gourmandDAO.findOne(nom);

  } catch (e) {
    throw "Gourmand non mis à jour";
  }
}
};
export default gourmandDAO;
