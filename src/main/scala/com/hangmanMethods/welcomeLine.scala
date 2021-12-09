package com.hangmanMethods
class welcomeLine {
  def print():Unit={
    println(s"${Console.YELLOW}${Console.BOLD}~~~~~~~~~~~~~~~Welcome to Hangman Game~~~~~~~~~~~~~~~")
    println(" _^_   _^_   _^_   _^_   _^_   _^_   _^_   _^_   _^_")
    println("(._.) (._.) (._.) (._.) (^_^) (._.) (._.) (._.) (._.)")
    println(s"_/P\\_  /R\\   /O\\   /J\\   /E\\   /C\\   /T\\   /-\\  _/0\\_")
    println(" / \\   / \\   / \\   / \\   / \\   / \\   / \\   / \\   / \\")
    println(s"                  One Man 5 Tries${Console.RESET}")
    println(s"${Console.BLUE}RULES:\n1. START WITH 5 POINTS," +
      s" EACH INCORRECT GUESS LOSE 1 POINT." +
      s"\n2. WHEN POINT REACH 0, YOU LOSE THE ROUND." +
      s"\n3. ENJOY!!!${Console.RESET}\n")
  }
}
