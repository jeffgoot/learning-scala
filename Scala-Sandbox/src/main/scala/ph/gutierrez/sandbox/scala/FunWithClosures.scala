package ph.gutierrez.sandbox.scala

object FunWithClosures {

  def main(args: Array[String]): Unit = {
  	// demonstrates the use of anonymous functions. 
    args.filter((arg: String) => arg.startsWith("X"))
    		.foreach((arg: String) => Console.println(arg))
  }
}