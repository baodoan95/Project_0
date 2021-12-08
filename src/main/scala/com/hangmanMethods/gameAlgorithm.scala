package com.hangmanMethods
import scala.collection.mutable.ListBuffer

class gameAlgorithm {

  //Declare start function
  def start(player_id: String):Unit={
    val playerId = player_id
    //Instantiate
    val playerHandling = new playerHandling()
    val dbConnect = new dbConnect()

    //Declare variables
    val dbList = dbConnect.getWord()//Database query parse into ListBuffer with all answers

    //Let user pick word choice
    val dbchoiceNum = dbList.length
    println(s"Database return total: $dbchoiceNum word choices.")
    println(s"Please pick from 1 - $dbchoiceNum")
    print("Enter your choice: ")
    var choice = io.StdIn.readInt()
    var choiceCheck = false
    var ans = new String
    while(choiceCheck == false) choice match{
      case x if 1 until dbchoiceNum contains x => ans = dbList(x-1)
                    choiceCheck = true
      case _ => println("Invalid input.  Re-enter")
                choice = io.StdIn.readInt()
    }




    //ans
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
        println("YOU LOST!   NO POINTS EARNED THIS ROUND")
        isWinner = true
      }
      if(ansDisplay.indexOf('_') == -1){
        println(s"YOU WIN!  SCORES YOU EARNED THIS ROUND IS $countAttempt Points")
        isWinner = true
      }
    }//while loop end

    //End Match Choices
    dbConnect.updateScore(playerId,countAttempt)
    countAttempt = 5
    playerHandling.printEndChoices()
    playerHandling.endChoiceInput()

  }

}
