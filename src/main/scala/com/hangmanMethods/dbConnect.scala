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
    println("\n****************************")
    while(scores.next()){
      println(f"RANK $count  ${scores.getString(1)}%10s     ${scores.getString(2)}")
      count += 1
    }
    count = 1
    println("****************************\n")
  }
  //Function to retrieve all words from database and store into ListBuffer
  def getWord():ListBuffer[String]={
    val words = statement.executeQuery("SELECT * FROM words;")
    val wordLB = new ListBuffer[String]
    while(words.next()){
      wordLB += words.getString(1)
    }
    wordLB
  }
  //Function to submit nickname into database
  def submitNickname(str: String):Unit={
    statement.executeUpdate(s"INSERT INTO players VALUES(NULL,'$str');")
  }
  //Function to retrieve playerID
  def getPlayerID(nickname: String):ListBuffer[String]={
    val id = statement.executeQuery(s"SELECT player_id FROM players WHERE nickname='$nickname';")
    val idlb = new ListBuffer[String]
    while(id.next()){
      idlb += id.getString(1)
    }
    idlb
  }
  //Function to add scores into score board after each session
  def addScore(playerid: String, score: Int): Unit ={
    statement.executeUpdate(s"INSERT INTO scores VALUES($playerid,$score);")
  }
  //Function to update score when user continue playing and earn more points
  def updateScore(playerid: String, score: Int):Unit={
    statement.executeUpdate(s"UPDATE scores SET score = score + $score WHERE player_id = $playerid;")
  }
  //Function to get score in highest score ranking so I could use in my leaderboard
  def getLatestID():ListBuffer[String]={
    val maxid = statement.executeQuery("SELECT MAX(player_id) FROM players;")
    val maxidlb = new ListBuffer[String]
    while(maxid.next()){
      maxidlb += maxid.getString(1)
    }
    maxidlb
  }
  //Function to get word list from database
  def getWordsList():Unit={
    val allWords = statement.executeQuery("SELECT * FROM words;")
    var count:Int = 0
    println("\n---WORDS LIST--------TIMES PLAYED--")
    while(allWords.next()){
      count += 1
      println(f"$count. ${allWords.getString(1)}%10s            ${allWords.getString(2)}")
    }
    println("-----------------------------------\n")
    count = 0
  }
  //Function to insert new word into database
  def insertWord(str: String):Unit={
    statement.executeUpdate(s"INSERT INTO words VALUES('$str',0);")
  }
  //Function to add 1 to times_played column in words table each time user choose a word
  def updateWordPlayCount(str:String):Unit={
    statement.executeUpdate(s"UPDATE words SET times_played = times_played + 1 WHERE word = '$str';")
  }
  //Function to remove player from database
  def removePlayer(str: String):Unit={
    statement.executeUpdate(s"DELETE FROM players WHERE nickname = '$str';")
  }
}
