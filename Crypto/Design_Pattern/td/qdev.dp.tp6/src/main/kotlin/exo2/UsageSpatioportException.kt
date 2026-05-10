package exo2

/* NE PAS MODIFIER CES CLASSES */

abstract class UsageSpatioportException(msg: String) : Exception(msg)

class SpatioportException(msg: String) : UsageSpatioportException(msg)

class PlaceInexistanteException(msg: String) : UsageSpatioportException(msg)

class SpatioportPleinException(msg: String) : UsageSpatioportException(msg)

class PlaceInutilisableException(msg: String) : UsageSpatioportException(msg)

class PlaceOccupeeException(msg: String) : UsageSpatioportException(msg)

class PlaceLibreException(msg: String) : UsageSpatioportException(msg)

class VaisseauDejaAmarreException(msg: String) : UsageSpatioportException(msg)