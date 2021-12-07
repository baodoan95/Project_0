package com.mainGame

import com.hangmanMethods.{gameAlgorithm, startOptions, welcomeLine}

object hangmanApp {
  def main(args: Array[String]): Unit = {

    //Instantiate hangmanMethods into objects
    val gameAlgorithm = new gameAlgorithm()
    val startOptions = new startOptions()
    val welcomeLine = new welcomeLine()

    //print welcome line
    welcomeLine.print()
    //Game start option
    startOptions.printOptions()
    //Taking in user input for start option
    startOptions.getInput()
  }
}
