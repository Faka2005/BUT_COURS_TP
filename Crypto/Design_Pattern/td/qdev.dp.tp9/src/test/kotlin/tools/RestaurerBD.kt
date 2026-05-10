package tools

import java.sql.DriverManager

fun main() {
    val basedir = "./data/"

    val prefixH2 = "jdbc:h2:"
    val prefigSQLite = "jdbc:sqlite:"

    val basenameH2 = "fruits.h2"
    val basenameSQLite = "fruits.sqlite"

    restaureBD(prefixH2, basedir, basenameH2)
    restaureBD(prefigSQLite, basedir, basenameSQLite)
}

fun restaureBD(prefix: String, basedir: String, basename: String) {

    val table = "DB_Fruits"

    val connection = DriverManager.getConnection(prefix + basedir + basename)
    println("Connexion établie : $connection")

    val statement = connection.createStatement()
    lateinit var sql: String

    sql = "DROP TABLE " + table
    println(sql)
    try {
        statement.executeUpdate(sql)
    } catch (e: Exception) {
        println("Table $table inexistante")
    }


    sql = "CREATE TABLE DB_Fruits (Nom VARCHAR(200) PRIMARY KEY NOT NULL, Prix REAL NOT NULL, Quantite INT NOT NULL);"
    println(sql)
    statement.executeUpdate(sql)


    sql = "INSERT INTO DB_Fruits VALUES ('Abricot', 18.4, 80);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Ananas', 30.4, 140);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Banane', 8.4, 30);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Fraise', 8.7, 25);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Framboise', 12.4, 50);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Goyave', 24.4, 0);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Kiwi', 4.5, 10);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Melon', 28.4, 130);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Mûre', 14.4, 60);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Nectarine', 22.4, 100);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Orange', 26.4, 120);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Poire', 10.4, 30);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Pomme', 6.4, 20);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Pêche', 16.4, 70);"
    println(sql)
    statement.executeUpdate(sql)
    sql = "INSERT INTO DB_Fruits VALUES ('Raisin', 20.4, 90);"
    println(sql)
    statement.executeUpdate(sql)
}
