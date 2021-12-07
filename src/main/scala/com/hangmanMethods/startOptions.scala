package com.hangmanMethods

class startOptions {
  //Instantiate game start
  val gameAlgorithm = new gameAlgorithm
  val Login = new Login
  val Leaderboard = new Leaderboard

  //Declare print function
  def printOptions():Unit={
    println(s"${Console.YELLOW}1. Login")
    println("2. Create Account")
    println("3. Leaderboard")
    println("4. Upload CSV Words/Hints File")
    println(s"5. Quit Game${Console.RESET}")
    print("Please input your choice: ")
  }

  //Declare get user input function
  def getInput():Unit= {
    var input = io.StdIn.readLine()
    var isValid: Boolean = false
    while(isValid == false)
      input match {
        case "1" => Login.login()
          isValid = true
        case "2" => Login.createAccount()
          isValid = true
        case "3" => Leaderboard.start()
          isValid = true
        case "4" => println("Successfully Quit Game")
          System.exit(0)
          isValid = true
        case _ => print("Invalid Input.  Please re-enter:  ")
          input = io.StdIn.readLine()
      }
  }
}
