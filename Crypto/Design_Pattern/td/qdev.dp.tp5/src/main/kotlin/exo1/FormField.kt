package exo1

import java.awt.Color
import javax.swing.JTextField
import javax.swing.event.DocumentListener

class FormField(
    text: String = ""
) : JTextField(text,15) {

    /* NE PAS MODIFIER */

    init {
        this.getDocument().addDocumentListener(object : DocumentListener {
            override fun insertUpdate(e: javax.swing.event.DocumentEvent?) {
                checkText()
            }

            override fun removeUpdate(e: javax.swing.event.DocumentEvent?) {
                checkText()
            }

            override fun changedUpdate(e: javax.swing.event.DocumentEvent?) {
                checkText()
            }
        })
    }

    fun checkText() {
        if (isTextValid()) {
            println("'$text' is valid")
            foreground = java.awt.Color.BLACK
        } else {
            println("***** '$text' is NOT valid")
            foreground = Color.RED
        }
    }

    fun getInfo() : String = "FormField with value $text"

    /* FIN NE PAS MODIFIER */

    fun isTextValid() : Boolean {
        //TODO
        return true
    }

    companion object {
        fun buildUsernameField(value: String = "") : FormField {
            TODO()
        }

        fun buildPasswordField(value: String = "") : FormField {
            TODO()
        }

        fun buildNumericField(value: String = "") : FormField {
            TODO()
        }

        fun buildEmailField(value: String = "") : FormField {
            TODO()
        }

    }
}