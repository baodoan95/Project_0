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
  val statement = connection.createStatement()
  //function to get leader board
  def getLeaderboard():Unit={
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
    val words = statement.executeQuery("SELECT * FROM words;")
    val wordLB = new ListBuffer[String]
    while(words.next()){
      wordLB += words.getString(2)
    }
    wordLB
  }

  def submitNickname(str: String):Unit={
    statement.executeUpdate(s"INSERT INTO players VALUES(NULL,'$str');")
  }

  def getPlayerID(nickname: String):ListBuffer[String]={
    val id = statement.executeQuery(s"SELECT player_id FROM players WHERE nickname='$nickname';")
    val idlb = new ListBuffer[String]
    while(id.next()){
      idlb += id.getString(1)
    }
    idlb
  }

  def updateScore(playerid: String, score: Int):Unit={
    statement.executeUpdate(s"UPDATE scores SET score = score + $score WHERE player_id = $playerid;")
  }

  def getLatestID():ListBuffer[String]={
    val maxid = statement.executeQuery("SELECT MAX(player_id) FROM players;")
    val maxidlb = new ListBuffer[String]
    while(maxid.next()){
      maxidlb += maxid.getString(1)
    }
    maxidlb
  }
}
