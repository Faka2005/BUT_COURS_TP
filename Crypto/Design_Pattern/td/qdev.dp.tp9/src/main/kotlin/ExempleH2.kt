import java.sql.DriverManager
import java.sql.SQLException

fun main() {

    try {
        // On se connecte à une BDD H2, ie au fichier data/persons.h2.mv.db


        val prefix = "jdbc:h2:"
        val fullPath = "./data/persons.h2"
        val table = "Person"

        val connection = DriverManager.getConnection(prefix + fullPath)
        val statement = connection.createStatement()
        lateinit var sql: String

        // On efface la table Person
        sql = "DROP TABLE " + table
        println(sql)
        statement.executeUpdate(sql)

        // On recréé une table Person
        sql = "CREATE TABLE " + table + "(" +
                "    Id INT PRIMARY KEY NOT NULL, " +
                "    Name TEXT NOT NULL," +
                "    Salary REAL NOT NULL," +
                "    Age INT NOT NULL" +
                ")"
        println(sql)
        statement.executeUpdate(sql)

        // On insère des personnes
        sql = "INSERT INTO " + table + " VALUES " +
                "(31, 'Arnaud', 1045.42, 23), " +
                "(26, 'JFR', 2659.6, 20), " +
                "(34, 'JFB', 2456.6, 19), " +
                "(32, 'JFB', 2456.6, 19), " +
                "(30, 'TBLF', 2343.00, 22)," +
                "(33, 'EB', 2342.99, 22) ;"
        println(sql)
        statement.executeUpdate(sql)

        // On consulte la table Person
        sql = "SELECT * FROM " + table + " WHERE Salary > 2000.0 ORDER BY Age ;"
        println(sql)
        var result = statement.executeQuery(sql)
        while (result.next()) {
            println("${result.getInt("Id")} : ${result.getString("Name")}")
        }

        sql = "SELECT * FROM " + table + " WHERE Name = 'JFB' ; "
        println(sql)
        result = statement.executeQuery(sql)
        while (result.next()) {
            println("${result.getString("Name")} (${result.getInt("Salary")})")
        }

        sql = "SELECT * FROM " + table + " WHERE Name = 'JFR' ; "
        println(sql)
        result = statement.executeQuery(sql)
        while (result.next()) {
            println("${result.getString("Name")} (${result.getInt("Salary")})")
        }

        statement.close()
        connection.close()
    } catch (e: SQLException) {
        println(e.message)
    }


}