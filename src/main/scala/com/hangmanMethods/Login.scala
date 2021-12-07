package com.hangmanMethods

class Login {
  val gameAlgorithm = new gameAlgorithm()
  def login(): Unit ={
    //test area
    val s = "bao"
    //end test area
    var isValid = false
    while(isValid == false) {
      print("Username: ")
      val username = io.StdIn.readLine()
      print("Password: ")
      val password = io.StdIn.readLine()
      if(username != s) {
        println("\nInvalid login credentials.  Please try again.")
        isValid = false
      } else{
        isValid = true
        println(s"\nLogin Successfully\nWelcome $username!")
        gameAlgorithm.start()
      }
    }
  }
  def createAccount(): Unit ={
    println("create account")
  }

}
