package com.hangmanMethods
import java.sql.DriverManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
import scala.collection.mutable.ListBuffer
class dbConnect {
  //Connection to database
  val driver = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/project_0"
  val username = "root"
  val password = "BaodoaN95"
  var connection:Connection = DriverManager.getConnection(url, username, password)

  //function to get leader board
  def getLeaderboard():Unit={
    val statement = connection.createStatement()
    val scores = statement.executeQuery("SELECT nickname, score FROM players INNER JOIN scores ON players.player_id = scores.player_id ORDER BY score DESC")
    var count = 1
    while(scores.next()){
      println(s"RANK $count  ${scores.getString(1)}  ${scores.getString(2)}")
      count += 1
    }
    count = 1
    println("\n")
  }

  def getWord():ListBuffer[String]={
    val statement = connection.createStatement()
    val words = statement.executeQuery("SELECT * FROM words;")
    val wordLB = new ListBuffer[String]
    while(words.next()){
      wordLB += words.getString(2)
    }
    wordLB
  }

  def submitData(str: String):Unit={
    val statement = connection.createStatement()
    statement.executeUpdate(s"INSERT INTO players VALUES(NULL,'$str');")
  }
}
