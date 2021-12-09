package com.hangmanMethods
class startOptions {
  //Instantiate game start
  val gameAlgorithm = new gameAlgorithm()
  //Declare print function
  def printOptions():Unit={
    println(s"${Console.YELLOW}1. Start New Game")
    println("2. View Leaderboard")
    println("3. Delete Player Records")
    println("4. View Words List")
    println("5. Add New Word")
    println(s"6. Quit Game${Console.RESET}")
    print("Please input your choice: ")
  }
  //Declare get user input function
  def getInput():Unit= {
    //Instantiate database connection for query and update
    val dbConnect = new dbConnect()
    val playerHandling = new playerHandling()
    var input = io.StdIn.readLine()
    var isValid: Boolean = false
    while(isValid == false) {
      input match {
        case "1" => playerHandling.getInfo()
          isValid = true
        case "2" => dbConnect.getLeaderboard()
          printOptions()
          getInput()
        case "3" => print("\nEnter nickname to be deleted from database: ")
          val nickname = io.StdIn.readLine()
          dbConnect.removePlayer(nickname)
          println("Successfully removed nickname and player data from database.\n")
          printOptions()
          getInput()
        case "4" => dbConnect.getWordsList()
          printOptions()
          getInput()
        case "5" => print("\nPlease enter new word: ")
          val newWord = io.StdIn.readLine()
          dbConnect.insertWord(newWord)
          println("Successfully inserted word into database\n")
          printOptions()
          getInput()
        case "6" => System.exit(0)
        case _ => print("Invalid Input.  Please re-enter:  ")
          input = io.StdIn.readLine()
      }
    }
    dbConnect.connection.close() //Close connection to database
  }
}
