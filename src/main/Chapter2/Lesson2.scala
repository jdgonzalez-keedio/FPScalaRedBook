/**
 * Created by J.David González "jdgonzalez@keedio.com" on 31/8/15.
 */
trait Lesson2 {

  //Functions as values in Scala
  val lessThan = new Function2[Int, Int, Boolean] {
    def apply(a: Int, b: Int) = a < b
  }

}
