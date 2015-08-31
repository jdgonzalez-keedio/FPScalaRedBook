/**
 * Created by J.David González "jdgonzalez@keedio.com" on 31/8/15.
 */
object MainObject {
  
  def main (args: Array[String]) {

    val li = List(1,2,3,4,5)
    val lli = List(List(1,1),List(2,2),List(3,3))
    val ld = List(1.0,2.0,3.0,4.0,5.0)
    val ls = List("Dog", "Cat", "Bird", "Fish", "Horse")


    println("\n map:" +Execises3.map(ls)(_.concat("s")))
    println("\n filter:" +Execises3.filter(li)({x => x > 3}))
    println("\n Map:" +Execises3.map(li)(x => List(x, x) ) )
    println("\n flatMap:" +Execises3.flatMap(li)(x => List(x, x) ) )
    println("\n flatMap:" +Execises3.flatMap(lli)(x => List(x, x) ) )

  }

}
