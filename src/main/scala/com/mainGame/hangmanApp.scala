package com.mainGame
import com.hangmanMethods._
object hangmanApp {
  def main(args:Array[String]):Unit= {

    //Instantiate hangmanMethods into objects
    val startOptions = new startOptions()
    val welcomeLine = new welcomeLine()

    //Call method from object to print welcome line start game
    welcomeLine.print()
    startOptions.printOptions()
    startOptions.getInput()

  }
}
