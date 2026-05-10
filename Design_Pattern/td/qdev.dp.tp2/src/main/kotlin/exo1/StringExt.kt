package exo1

/**
 * méthode indiquant si la chaine de caractère est uniquement composée de
 * lettres en majuscules
 *
 * @return [true] si la chaine est en majuscule
 */
fun String.isFullUpperCase(): Boolean {
    if (this.isEmpty()) return false
    return this.all { it.isUpperCase() }
}


/**
 * Méthode indiquant si la chaine de caractères est composée d'un premier
 * caractère en majuscule, suivi des autres caractères en minuscules
 *
 * @return [true] si la chaine respecte le format
 */
fun String.hasAnUppercaseLetterFirst(): Boolean {
    if (this.isEmpty()) return false

    return this.first().isUpperCase() &&
            this.drop(1).all { it.isLowerCase() }
}

