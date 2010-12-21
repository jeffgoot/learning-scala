package ph.gutierrez.learning.scala

object Tuples {

  def main(args: Array[String]) {
  	val (first, middle, last) = getFullName()
  	
  	println(first + " " + middle + " " + last)
  }
  
  private def getFullName() = ("Jeff", "E", "Gutierrez")
}