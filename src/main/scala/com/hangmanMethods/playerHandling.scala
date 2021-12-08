package com.hangmanMethods

class playerHandling {
    val gameAlgorithm = new gameAlgorithm()
    val startOptions = new startOptions()
    var nickname = new String
    def getInfo():Unit= {
      print("Choose Nickname: ")
      nickname = io.StdIn.readLine()
      gameAlgorithm.start()
    }
    def printEndChoices():Unit= {
      println(s"${Console.YELLOW}1. Continue playing")
      println("2. Submit score to database")
      println(s"3. To main menu${Console.RESET}")
      print("Please input your choice: ")
    }
    def endChoiceInput():Unit={
      val dbConnect = new dbConnect()
      val input = io.StdIn.readLine()
      var isValid = false
      while(isValid == false) input match{
        case "1" => println("implement")
                    isValid = true
        case "2" => println("implement")
                    isValid = true
        case "3" => startOptions.printOptions()
                    startOptions.getInput()
        case _ => println("Invalid input.  Try again.")
                  endChoiceInput()
      }
    }
}
