package com.hangmanMethods
import scala.collection.mutable.ListBuffer
class gameAlgorithm {

  //Declare start function
  def start():Unit={
    //Declare variables
    val ans: String = "apple" //add database later here
    var countScore:Int = 5
    val indexBuffer = new ListBuffer[Int]
    val ansList = ans.toList
    var ansDisplay = List.tabulate(ans.length)(x => '_').toVector
    var incorrectGuesses = new ListBuffer[Char]
    //Main game start
    println("\nGAME START! \n")
    println(ansDisplay.mkString("")+ s" Remaining attempts: $countScore")
    println("Hint: fruit that keeps doctors away")

    while(countScore >= 0) {
      print("Take your guess: ")
      //Find index of character in answer string
      val userAns = io.StdIn.readChar()
      for (i <- -0 until ansList.length) {
        if (ansList(i) == userAns) indexBuffer += i
      }

      //Check if user has guessed the correct letter

      if (indexBuffer.length == 0) {
        println("Incorrect!")
        countScore -= 1
        incorrectGuesses += userAns
        println(s"\n\n\nIncorrect Guesses: ${incorrectGuesses.mkString(",")}")
      } else {
        println("Correct!")
        for (i <- 0 until indexBuffer.length) {
          ansDisplay = ansDisplay.updated(indexBuffer(i), userAns)
        }
      }
      println(ansDisplay.mkString(""))
      indexBuffer.clear()
      if(ansDisplay.indexOf('_') == -1){
        println("YOU WIN!")
        System.exit(0)
      }
    }




  }
}
