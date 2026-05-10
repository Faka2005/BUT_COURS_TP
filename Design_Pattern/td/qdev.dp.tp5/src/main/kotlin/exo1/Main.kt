package exo1

import java.awt.Dimension
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel

class Main(val formField: FormField) : JFrame() {

    val okButton = JButton("OK")

    init {
        this.title = "Exo1 -FormField test"
        this.contentPane.layout = GridLayout(5, 1)
        this.contentPane.add(JLabel("write a text into a FormField :"))
        this.contentPane.add(formField)
        this.contentPane.add(okButton)
        okButton.addActionListener {
            println("Button OK pressed, the FormField has value ${formField.text} which is " + if (!formField.isTextValid()) "NOT valid" else "valid")
        }
        this.preferredSize = Dimension(300, 200)
        this.setLocation(200, 200)
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        this.isVisible = true
        this.pack()
    }
}

fun main() {
    Main(FormField("essai"))
    //Main(FormField.buildUsernameField())
    //Main(FormField.buildNumericField())
    //Main(FormField.buildEmailField())
    //Main(FormField.buildPasswordField())
}