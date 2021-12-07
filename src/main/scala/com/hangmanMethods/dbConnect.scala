package com.hangmanMethods
import java.sql.DriverManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
class dbConnect {
  //Connection to database
  val driver = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/project_0"
  val username = "root"
  val password = "BaodoaN95"
  var connection:Connection = DriverManager.getConnection(url, username, password)
  val statement = connection.createStatement()
  val resultSet = statement.executeQuery("SELECT * FROM words;")
  while ( resultSet.next() ) {
    println(resultSet.getString(1)+", " +resultSet.getString(2))
  }
  connection.close()
}
