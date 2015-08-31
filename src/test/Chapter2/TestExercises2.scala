import org.junit.{Assert, Test}

/**
 * Created by J.David González "jdgonzalez@keedio.com" on 31/8/15.
 */
class TestExercises2 extends Lesson2 {

  @Test
  def factorialTest() = {

    Assert.assertEquals("fibonacci(1): ", Execises2.factorial(0), 1)
    Assert.assertEquals("fibonacci(2): ", Execises2.factorial(1), 1)
    Assert.assertEquals("fibonacci(3): ", Execises2.factorial(4), 24)

  }

  @Test
  def fibonacciTest() = {

    Assert.assertEquals("fibonacci(1): ", Execises2.fibonacci(1), 1)
    Assert.assertEquals("fibonacci(4): ", Execises2.fibonacci(4), 5)
    Assert.assertEquals("fibonacci(6): ", Execises2.fibonacci(6), 13)

  }

  @Test
  def findFirstTest() = {

    val a1 = Array(9, 2, 8, 3, 7, 4, 6, 5, 1)
    val a2 = Array(9)
    val a3 = Array(9, 1)
    val a4 = Array(6, 5, 1, 6, 5, 1)
    val p1 = { (x: Int) => x == 1 }

    Assert.assertEquals("findFirst(a1,p1): ", Execises2.findFirst(a1, p1), 8)
    Assert.assertEquals("findFirst(a2,p1): ", Execises2.findFirst(a2, p1), -1)
    Assert.assertEquals("findFirst(a3,p1): ", Execises2.findFirst(a3, p1), 1)
    Assert.assertEquals("findFirst(a4,p1): ", Execises2.findFirst(a4, p1), 2)

  }

  @Test
  def isSortedTest() = {

    val b1 = Array(Array(1, 9), Array(1, 1))
    val b2 = Array(Array(1, 1), Array(1, 9))
    val b3 = Array(Array(1, 1), Array(1, 9), Array(2, 8))
    val o1 = { (x: Array[Int], y: Array[Int]) => (x(0) <= y(0) && x(1) < y(1)) ||  (x(0) < y(0) && x(1) <= y(1))}

    Assert.assertEquals("isSorted(b1,o1): ", Execises2.isSorted(b1, o1), false)
    Assert.assertEquals("isSorted(b2,o1): ", Execises2.isSorted(b2, o1), true)
    Assert.assertEquals("isSorted(b3,o1): ", Execises2.isSorted(b3, o1), false)

  }

  @Test
  def lessThanTest() = {

    Assert.assertEquals("10 <? 20", lessThan.apply(10, 20), true)
    Assert.assertEquals("19 <? 9", lessThan.apply(19, 9), false)
    Assert.assertEquals("19 <? 19", lessThan.apply(19, 19), false)

  }

  @Test
  def composeTest() = {

    val f = { (x: Int) => x * 5 }
    val g = { (x: Int) => x - 2 }

    Assert.assertEquals("(f·g)(6)", Execises2.compose(g, f)(10), 48)

  }

}
