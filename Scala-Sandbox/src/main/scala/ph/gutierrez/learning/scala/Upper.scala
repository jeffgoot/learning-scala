package ph.gutierrez.learning.scala

import java.util.{Map, HashMap}

object Upper {
	
	val cache: Map[String,Any] = new HashMap
	
	val SOME_CONST : Seq[String] = upper("x")

  def upper(strings: String*) = strings.map(_.toUpperCase())

  def main(args: Array[String]): Unit = {
   	Upper.enclosing("123")
  }
	
	def enclosing(value : String) : Unit = {
		var another = "XXX"
			
		def enclosed() : Unit = {
			val another = "test"
			def crazy() : Unit = println("Internal: " + value + " " + another)
			
			crazy()
		}
		
		enclosed()
	}
}