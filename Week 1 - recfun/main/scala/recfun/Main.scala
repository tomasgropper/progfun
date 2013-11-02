package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == c) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }  

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def f(list: List[Char], x: Int): Boolean = {
      if (x < 0) false
      else if (list.isEmpty) {
        x == 0
      }
      else {
	      list.head match {
	        case '(' => f(list.tail, x + 1)
	        case ')' => f(list.tail, x - 1)
	        case _ => f(list.tail, x)
	      }
      }
    }

    f(chars, 0)
  }  

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
  
		def count(money: Int, coins: List[Int]): Int = {
			if(money == 0) 1
			else if(money <= 0) 0
			else if(coins.isEmpty && money >= 0)  0			
			else count(money, coins.tail) + count(money - coins.head, coins)
		} 	
  	
  	count(money, coins)
  }
}
