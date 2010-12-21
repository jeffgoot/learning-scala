package ph.gutierrez.learning.scala

object Match {

  def main(args: Array[String]): Unit = {

    matchTuple(("one", "two"))
    matchTuple(("three", "two"))

    // matchASequence(List(1, 2, 3))
    // matchASequence(List(3, 2, 1))

    // matchOnVariable(10)
    // justLikeJava(1)
    // justLikeJava(10)
  }

  def matchTuple(tuple: Tuple2[String, String]): Unit = tuple match {
    case (one, two) if one == "one" => println("Tuple match and first element is one!")
    case (one, two) => println("Tuple match: " + one + ", " + two)
  }

  def matchASequence(values: List[Int]) {
    values match {
      case List(1, _*) => println("List starts with one.")
      case List(_*) => println("List did not match.")
    }
  }

  def matchOnVariable(value: Int) {
    // How is otherValue defined and what's the scope? Looks like the scope's just within the match block as
    // the variable isn't available outside of match.
    value match {
      case 1 => println("1")
      case otherValue => println("default: " + otherValue)
    }
  }

  def justLikeJava(value: Int) {
    value match {
      case 1 => println("1")
      case 2 => println("2")
      case 3 => println("3...")
      case _ => println("defualt: " + value)
    }
  }
}