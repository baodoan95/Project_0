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
    println(s"There are a total of: ${Console.YELLOW}$dbchoiceNum${Console.RESET} word choices.")
    println(s"Please pick from ${Console.YELLOW}1 - $dbchoiceNum${Console.RESET}")
    print("Enter your choice: ")
    var choice = io.StdIn.readInt()
    var choiceCheck = false
    var ans = new String
    while(choiceCheck == false) choice match{
      case x if 1 to dbchoiceNum contains x => ans = dbList(x-1)
        choiceCheck = true
      case _ => println("Invalid input.  Re-enter")
        choice = io.StdIn.readInt()
    }
    //Update chosen word into database as played once and plus 1 to count
    dbConnect.updateWordPlayCount(ans)
    //Code portion to check winner and loser based on score count
    var isWinner:Boolean = false
    var countAttempt:Int = 5
    val indexBuffer = new ListBuffer[Int]
    val ansList = ans.toList
    var ansDisplay = List.tabulate(ans.length)(x => '_').toVector
    var incorrectGuesses = new ListBuffer[Char]
    //Main game start
    println("\nGAME START! \n")
    println(s"${Console.GREEN}${Console.BOLD}${ansDisplay.mkString("")}${Console.RESET}         ${Console.BOLD}Attempts Left: $countAttempt${Console.RESET}")
    //Loop logic until player win or lose
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
      println(s"${Console.GREEN}${Console.BOLD}${ansDisplay.mkString("")}${Console.RESET}         ${Console.BOLD}Attempts Left: $countAttempt${Console.RESET}")
      indexBuffer.clear()
      if(countAttempt == 0){
        println(s"\n${Console.BLUE}YOU LOST!   NO POINTS EARNED THIS ROUND\n${Console.RESET}")
        isWinner = true
      }
      if(ansDisplay.indexOf('_') == -1){
        println(s"\n${Console.RED}YOU WIN!  SCORES YOU EARNED THIS ROUND ARE $countAttempt Points${Console.RESET}\n")
        isWinner = true
      }
    }//while loop end
    //End Match Choices
    dbConnect.updateScore(playerId,countAttempt)
    dbConnect.connection.close() //close connection to database
    countAttempt = 5
    playerHandling.printEndChoices()
    playerHandling.endChoiceInput()
  }
}
