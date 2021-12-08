package com.hangmanMethods
import scala.collection.mutable.ListBuffer

class gameAlgorithm {
  // Instantiate

  //Declare start function
  def start():Unit={
    //Instantiate
    val playerHandling = new playerHandling()


    //Declare variables
    val ans: String = "bao"//Database query parse into string

    var isWinner:Boolean = false
    var countAttempt:Int = 5
    val indexBuffer = new ListBuffer[Int]
    val ansList = ans.toList
    var ansDisplay = List.tabulate(ans.length)(x => '_').toVector
    var incorrectGuesses = new ListBuffer[Char]
    //Main game start
    println("\nGAME START! \n")
    println(ansDisplay.mkString("")+ s" Attempt Left: $countAttempt")

    while(isWinner != true) {
      print("Take your guess (1-quit): ")
      //Find index of character in answer string
      val userAns = io.StdIn.readChar()
      if(userAns == '1')System.exit(0)
      for (i <- -0 until ansList.length) {
        if (ansList(i) == userAns) indexBuffer += i
      }

      //Check if user has guessed the correct letter

      if (indexBuffer.length == 0) {
        println("Incorrect!")
        countAttempt -= 1
        incorrectGuesses += userAns
        println(s"\nIncorrect Guesses: ${incorrectGuesses.mkString(",")}")
      } else {
        println("Correct!\n")
        for (i <- 0 until indexBuffer.length) {
          ansDisplay = ansDisplay.updated(indexBuffer(i), userAns)
        }
      }
      println(ansDisplay.mkString("")+ s" Attempts Left: $countAttempt")
      indexBuffer.clear()
      if(countAttempt == 0){
        println("YOU LOST!")
        countAttempt = 5
        isWinner = true
      }
      if(ansDisplay.indexOf('_') == -1){
        println("YOU WIN!")
        isWinner = true
      }
    }//while loop end

    //End Match Choices
    playerHandling.printEndChoices()
    playerHandling.endChoiceInput()

  }

}
