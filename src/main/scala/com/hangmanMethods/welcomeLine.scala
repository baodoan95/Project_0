package com.hangmanMethods
class welcomeLine {
  def print():Unit={
    println(s"${Console.YELLOW}${Console.BOLD}~~~Welcome to Hangman Game~~~")
    println(" /=\\   /=\\   /=\\   /=\\   /=\\")
    println("(^_^) (^_^) (^_^) (^_^) (^_^)")
    println(" /|\\   /|\\   /|\\   /|\\   /|\\")
    println(" / \\   / \\   / \\   / \\   / \\")
    println("       One Man 5 Tries")
    println(s"RULES:\n1. START WITH 5 POINTS, EACH INCORRECT GUESS LOSE 1 POINT.\n2. WHEN POINT REACH 0, YOU LOSE THE ROUND.\n3. ENJOY!!!${Console.RESET}\n")
  }
}
