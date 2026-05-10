package tools

import java.sql.DriverManager
import kotlin.math.abs

class Tools {

    companion object {

        private fun targetTable(sourceTable: String): String {
            return sourceTable + "_" + abs(System.getProperties().getProperty("user.name").hashCode())
        }

        /**
         * copie la table 'sourceTable' initiale de la base de données 'prefix+cheminComplet'
         * dans une nouvelle table
         * @return le nom de la table copiée
         */
        fun copyDatatable(prefix: String, url: String, sourceTable: String): String {
            val nomTableUnique = targetTable(sourceTable)
            val connection = DriverManager.getConnection(prefix + url)
            val statement = connection.createStatement()
            try {
                val res = statement.executeUpdate("DROP TABLE " + nomTableUnique)
            } catch (e: Exception) {
                println("Table encore inexistante")
            }
            statement.executeUpdate("CREATE TABLE " + nomTableUnique + " AS SELECT * FROM DB_Fruits; ")
            statement.close()
            connection.close()
            return nomTableUnique
        }
    }
}