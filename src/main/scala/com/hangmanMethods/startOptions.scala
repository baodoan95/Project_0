package com.hangmanMethods

class startOptions {
  //Instantiate game start
  val gameAlgorithm = new gameAlgorithm

  //Declare print function
  def printOptions():Unit={
    println(s"${Console.YELLOW}1. Launch Game")
    println(s"2. Quit Game${Console.RESET}")
    print("Please input your choice: ")
  }

  //Declare get user input function
  def getInput():Unit= {
    var input = io.StdIn.readLine()
    var isValid: Boolean = false
    while(isValid == false)
      input match {
        case "1" => gameAlgorithm.start()
          isValid = true
        case "2" => System.exit(0)
        case _ => print("Invalid Input.  Please re-enter:  ")
          input = io.StdIn.readLine()
      }
  }
}
