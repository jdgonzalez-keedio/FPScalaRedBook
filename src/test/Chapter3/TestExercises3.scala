import org.junit.{Assert, Test}

/**
 * Created by J.David González "jdgonzalez@keedio.com" on 31/8/15.
 */
class TestExercises3 {

  @Test
  def ObjectList() {

    val a1 = List.apply(1, 2, 3)
    val a2 = List.apply(1.0, 2.0, 3.0)

    Assert.assertEquals("sum a1: ", List.sum(a1), 6)
    Assert.assertTrue("product a2: ", List.product(a2) == 6.0)
    Assert.assertEquals("sum a1: ", List.sumR(a1), 6)
    Assert.assertTrue("product a2: ", List.productR(a2) == 6.0)

  }

  @Test
  def tailTest() {

    val l = List(1,2, 3,4,5)
    Assert.assertEquals("tail: ", Execises3.tail(l), List(2,3,4,5))

  }

  @Test
  def setHeadTest() {

    val l = List(1,2, 3,4,5)
    Assert.assertEquals("setHead: ", Execises3.setHead(9,l), List(9,2,3,4,5))

  }

  @Test
  def dropTest() {

    val l = List(1,2, 3,4,5)
    Assert.assertEquals("setHead: ", Execises3.drop(3,l), List(4,5))

  }

  @Test
  def TestDropWhile(): Unit = {

    val l = List(1,2,3,4,5)
    val f = { x: Int => x < 4}

    Assert.assertEquals("dropWhile: ", Execises3.dropWhile(l,f), List(4,5))
    Assert.assertEquals("dropWhile: ", Execises3.dropWhile2(l)(x => x < 4), List(4,5))

  }

  @Test
  def TestFoldLeft() = {

    val l = List(9,8,7,10,14)
    val ll = List(9.0,8.0,7.0,10.0,14.0)

    Assert.assertEquals("sumL: ", Execises3.sumL(l), 48)
    Assert.assertTrue("productL: ", Execises3.productL(ll) == 70560.0)
    Assert.assertEquals("lengthL: ", Execises3.lengthL(l), 5)

  }

  @Test
  def TestReverse() = {

    val l = List(1,2,3,4,5)

    Assert.assertEquals("sumL: ", Execises3.reverseL(l), List(5,4,3,2,1))
    Assert.assertEquals("sumL: ", Execises3.reverseLR(l), List(5,4,3,2,1))
    Assert.assertEquals("sumL: ", Execises3.reverseRL(l), List(5,4,3,2,1))

  }

  @Test
  def TestAppendFoldRight() = {

    val l = List(1,2,3,4,5)
    val r = List(1,2,3,4,5)

    Assert.assertEquals("append: ", Execises3.appendFoldRight(l,r), List(1,2,3,4,5,1,2,3,4,5))

  }


  @Test
  def TestMapFilterFlatMap() = {

    val li = List(1,2,3,4,5)
    val ls = List("Dog", "Cat", "Bird", "Fish", "Horse")

    Assert.assertEquals("append: ", Execises3.map(ls)(_.concat("s")), List("Dogs", "Cats", "Birds", "Fishs", "Horses"))
    Assert.assertEquals("append: ", Execises3.filter(li)({x => x > 3}), List(4,5))
    Assert.assertEquals("append: ", Execises3.flatMap(li)(x => List(x, x) ), List(1,1,2,2,3,3,4,4,5,5))

  }


}
