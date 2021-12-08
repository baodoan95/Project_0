package com.hangmanMethods

class startOptions {
  //Instantiate game start
  val gameAlgorithm = new gameAlgorithm()

  //Instantiate database connection for query and update
  val dbConnect = new dbConnect()
  //Declare print function
  def printOptions():Unit={
    println(s"${Console.YELLOW}1. Start New Game")
    println("2. View Leaderboard")
    println(s"3. Quit Game${Console.RESET}")
    print("Please input your choice: ")
  }

  //Declare get user input function
  def getInput():Unit= {
    val playerHandling = new playerHandling()
    var input = io.StdIn.readLine()
    var isValid: Boolean = false
    while(isValid == false)
      input match {
        case "1" => playerHandling.getInfo()
          isValid = true
        case "2" => dbConnect.getLeaderboard()
          printOptions()
          getInput()
        case "3" => System.exit(0)
        case _ => print("Invalid Input.  Please re-enter:  ")
          input = io.StdIn.readLine()
      }
  }
}
