/**
 * Created by J.David González "jdgonzalez@keedio.com" on 31/8/15.
 */
object Execises2 {


  def factorial(n: Int): Int = {

    def go(n: Int, acc: Int): Int = {

      if (n <= 0) acc
      else go(n-1, n*acc)
    }

    go(n,1)
  }

  def fibonacci(n: Int): Int = {

    def go(n: Int, acc: Int): Int = {

      if(n <= 1) acc
      else go(n-1,1) + go(n-2,1)

    }

    go(n,1)

  }

  def findFirst[A](as: Array[A], p: A => Boolean): Int = {

    def loop(n: Int): Int = {
      if(n >= as.length) -1
      else if (p(as(n))) n
      else loop(n+1)

    }

    loop(0)

  }

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {

    def go(n: Int, acc: A): Boolean = {
      if(n == as.length) true
      else if (ordered(acc,as(n))) go(n+1,as(n))
      else false
    }

    go(1,as(0))
  }

  def compose[A,B,C](g: B => C, f: A => B): A => C = {

    (a: A) => g(f(a))

  }

}
