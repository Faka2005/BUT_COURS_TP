package exo1

import java.awt.Dimension
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

fun main() {
    val fenetre = JFrame("Entrez un nom")
    val texteSaisi = JTextField(15)
    val boutonOK = JButton("OK")
    val resultat = JLabel("")
    fenetre.contentPane.layout = GridLayout(5, 1)
    fenetre.contentPane.add(JLabel("Saisir le nom de la personne ou de l'entreprise : "))
    fenetre.contentPane.add(texteSaisi)
    fenetre.contentPane.add(boutonOK)
    fenetre.contentPane.add(resultat)
    boutonOK.addActionListener {
        lateinit var personne: PersonneA
        // TODO (question 3):
        //  recupérer texteSaisi.text
        //  affecter le resultat à resultat.text

    }
    fenetre.preferredSize = Dimension(310, 200)
    fenetre.setLocation(200, 200)
    fenetre.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
    fenetre.pack()
    fenetre.isVisible = true
}