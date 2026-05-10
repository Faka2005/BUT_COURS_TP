package exo2.sans

import exo2.Foyer
import exo2.Impot
import exo2.SITUATION
import kotlin.math.roundToInt

class CalculImpot(var foyer: Foyer) : Impot {

    override fun impotsSurLeRevenu(): Int {
        var revenusImposables: Double
        if (foyer.situation == SITUATION.Celibataire) {
            if (foyer.nbEnfants == 0)
                revenusImposables = foyer.revenuAnnuel -
                        (0.10 * foyer.revenuAnnuel)
            else
                revenusImposables = foyer.revenuAnnuel -
                        (0.12 * foyer.revenuAnnuel) -
                        1000.0 * foyer.nbEnfants
        } else { // SITUATION.Couple
            if (foyer.nbEnfants == 0)
                revenusImposables = foyer.revenuAnnuel -
                        (0.2 * foyer.revenuAnnuel)
            else
                revenusImposables = foyer.revenuAnnuel -
                        (0.2 * foyer.revenuAnnuel) -
                        750.0 * foyer.nbEnfants
        }
        if (revenusImposables < 0)
            revenusImposables = 0.0
        // RevenusImposables calculés, passons à impotsRevenu
        if (foyer.situation == SITUATION.Celibataire) {
            if (foyer.nbEnfants == 0)
                return (1.0 / 3.0 * revenusImposables)
                    .roundToInt()
            else
                return (1.0 / (3.0 + foyer.nbEnfants) * revenusImposables)
                    .roundToInt()
        } else { // SITUATION.Couple
            if (foyer.nbEnfants == 0)
                return (1.0 / 4.0 * revenusImposables)
                    .roundToInt()
            else
                return (1.0 / (4.0 + foyer.nbEnfants) * revenusImposables)
                    .roundToInt()
        }
    }

    override fun taxeHabitation(): Int {
        val taxe: Int
        if (foyer.situation == SITUATION.Celibataire) {
            if (foyer.nbEnfants == 0)
                taxe = (2.0 * foyer.loyerMensuel + 1000.0)
                    .roundToInt()
            else
                taxe = (foyer.loyerMensuel - (75.0 * foyer.nbEnfants))
                    .roundToInt()
        } else { // SITUATION.Couple
            if (foyer.nbEnfants == 0)
                taxe = (2.0 * foyer.loyerMensuel)
                    .roundToInt()
            else
                taxe = (1.5 * foyer.loyerMensuel - 50.0 * foyer.nbEnfants)
                    .roundToInt()
        }
        return if (taxe < 0) 0
        else taxe
    }


}

