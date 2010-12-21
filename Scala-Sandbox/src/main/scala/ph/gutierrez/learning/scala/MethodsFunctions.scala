package ph.gutierrez.learning.scala

object MethodsFunctions {

	// Multi-line string literals.
  def main(args: Array[String]): Unit = {
    val message = """This is a test...
...of the support for multi-line strings
"""

    println(message)
    println(doubleMethod(10))
    println(doubleFunction(10))
  }

  // Method with inferred Unit return type even though last expression has a diff type
  def doubleMethod(value: Int) { value * 2 }

  // Function return type inferred from the last statement
  def doubleFunction(value: Int) = { value * 2 }

}