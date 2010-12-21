package ph.gutierrez.learning.scala

object WeekDay extends Enumeration {
	type WeekDay = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}
import WeekDay._

object Enum {

	def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)
	
  def main(args: Array[String]): Unit = {  

		// The following are equivalent with each other
		WeekDay.filter((value: WeekDay) => isWorkingDay(value)).foreach((element:WeekDay) => println(element))
		println("---")
		WeekDay.filter(isWorkingDay(_)).foreach(println(_))
		println("---")
		WeekDay filter isWorkingDay foreach println		
  }

}