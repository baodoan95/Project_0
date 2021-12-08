package com.hangmanMethods

class playerHandling {
    val gameAlgorithm = new gameAlgorithm()
    val startOptions = new startOptions()
    var nickname = new String
    def getInfo():Unit= {
      val dbConnect = new dbConnect()
      print("Choose Nickname: ")
      nickname = io.StdIn.readLine()
      dbConnect.submitNickname(nickname)
      gameAlgorithm.start(dbConnect.getPlayerID(nickname).mkString(""))
    }
    def printEndChoices():Unit= {
      println(s"${Console.YELLOW}1. Continue playing")
      println(s"2. To main menu${Console.RESET}")
      print("Please input your choice: ")
    }
    def endChoiceInput():Unit={
      //instantiate game algorithm
      val gameAlgorithm = new gameAlgorithm()
      val input = io.StdIn.readLine()
      var isValid = false
      while(isValid == false) input match{
        case "1" => gameAlgorithm.start("")

        case "2" => startOptions.printOptions()
                    startOptions.getInput()
        case _ => println("Invalid input.  Try again.")
                  endChoiceInput()
      }
    }


}
