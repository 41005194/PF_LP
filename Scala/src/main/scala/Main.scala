object Main extends App {
  val liste: List[Int] = List(1, 2, 3, 4, 5)
  
  def firstwo(l: List[Int]): List[Int] = {
    if (l.length >= 2) l.take(2)
    else l
  }

  def lastwo(l: List[Int]): List[Int] = {
    if (l.length >= 2) l.takeRight(2)
    else l
  }

  def movedFirstTwoToTheEnd(l: List[Int]): List[Int] = {
    if (l.length <= 2) l
    else l.drop(2) ++ l.take(2)
  }

  def insertedBeforeLast(l: List[Int], n: Int): List[Int] = {
    if (l.isEmpty) List(n)
    else l.init ++ List(n) ++ List(l.last)
  }

  // Testing the functions
  println(firstwo(liste))               // Output: List(1, 2)
  println(lastwo(liste))                // Output: List(4, 5)
  println(movedFirstTwoToTheEnd(liste)) // Output: List(3, 4, 5, 1, 2)
  println(insertedBeforeLast(liste, 99)) // Output: List(1, 2, 3, 4, 99, 5)
  val main = new Test()
  main.WordScore.test()
}