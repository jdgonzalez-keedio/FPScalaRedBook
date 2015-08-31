/**
 * Created by J.David González "jdgonzalez@keedio.com" on 31/8/15.
 */
object Execises3 {

  // Removing the first element of a List
  def tail[A](l: List[A]): List[A] = l match {

    case Nil => Nil
    case Cons(_, t) => t

  }

  // Replacing the first element of a List with a different value
  def setHead[A](as: A, l: List[A]): List[A] = l match {

    case Nil => Nil
    case Cons(_, t) => Cons(as, t)

  }

  // Removes the first n elements from a list
  def drop[A](n: Int, l: List[A]) : List[A] =

    if (n <= 0) l
    else
      l match {
        case Nil => Nil
        case Cons(_, t) => drop(n - 1, t)
      }


  // Removes elements from the List prefix as long as they match a predicate
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {

    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => l

  }

  // Version 2: Removes elements from the List prefix as long as they match a predicate
  def dropWhile2[A](l: List[A])(f: A => Boolean): List[A] = l match {

    case Cons(h, t) if f(h) => dropWhile2(t)(f)
    case _ => l

  }

  // Return a List consisting of all but the last element of a List
  def init[A](l: List[A]): List[A] = l match {

    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))

  }

  // Length of a list using foldRight
  def lengthR[A](l: List[A]): Int = List.foldRight(l, 0)((x, y) => y+1)

  //
  def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B =
    l match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z,x))(f)
    }

  // Sum, product, length list using foodLeft
  def sumL(l: List[Int]): Int = foldLeft(l, 0)(_ + _)

  def productL(l: List[Double]): Double = foldLeft(l, 1.0)(_ * _)

  def lengthL[A](l: List[A]): Int = foldLeft(l, 0)((x,y) => x+1)

  // Return the reverse of a list
  def reverseL[A](l: List[A]): List[A] = foldLeft(l, Nil: List[A])( (e, h) => Cons(h, e) )

  // foldLeft in terms of foldRight and conversely
  def foldLeftR[A,B](l: List[A], z: B)(f: (B, A) => B): B = List.foldRight(reverseL(l), z)( (x,y) => f(y,x) )
  def foldRightL[A,B](l: List[A], z: B)(f: (B, A) => B): B = foldLeft(l, z)( (x,y) => f(x,y) )

  // Return the reverse of a list
  def reverseLR[A](l: List[A]): List[A] = foldLeftR(l, Nil: List[A])( (e, h) => Cons(h, e) )
  def reverseRL[A](l: List[A]): List[A] = foldRightL(l, Nil: List[A])( (e, h) => Cons(h, e) )

  // Implement append in terms of either foldLeft or foldRight
  def appendFoldRight[A](l: List[A], r: List[A]): List[A] = List.foldRight(l, r)(Cons(_,_))

  // Function that transforms a list of integers by adding 1 to each element
  def add1(l: List[Int]): List[Int] = List.foldRight(l, Nil: List[Int])( (h, t) => Cons(h+1, t) )

  // Function that turns each value in a List[Double] into a String
  def doubleToString(l: List[Double]): List[String] = List.foldRight(l, Nil: List[String])( (h, t) => Cons(h.toString, t) )

  // Function map that generalizes modifying each element in a list while maintaining the structure of the list
  def map[A,B](l: List[A])(f: A => B): List[B] = List.foldRight(l, Nil: List[B])( (h, t) => Cons(f(h), t) )

  // Function filter the removes elements from a list unless the satisfy a give predicate
  def filter[A](l: List[A])(f: A => Boolean): List[A] = List.foldRight(l, Nil: List[A])( (h, t) => if (f(h)) Cons(h, t) else t)

  // Function flatMap that works like map except that the function given will return a list instead of
  // a single result, and that list should be inserted into the final result list
  def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = List.foldRight(l, Nil: List[B])( (h, t) => appendFoldRight(f(h), t) )

  // Use flatMap to implement filter
  def filterByFlatMap[A](l: List[A])(f: A => Boolean): List[A] = flatMap(l)( x => if (f(x)) List(x) else Nil )

  // Function that accepts two list and constructs a new list by adding corresponding elements
  def zipWith[A,B,C](l1: List[A], l2: List[B])(f: (A,B) => C): List[C] =
    (l1, l2) match {

      case (Nil, _) => Nil
      case (_, Nil) => Nil
      case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1,h2), zipWith(t1, t2)(f))

    }

  //

  //----------------

  // TO DO

  // Function that concatenates a list of lists into a single list


  // Removes elements from the List that satisfying a precondition
  //def dropIf[A](l: List[A])(f: A => Boolean): List[A] = l match {}

}
