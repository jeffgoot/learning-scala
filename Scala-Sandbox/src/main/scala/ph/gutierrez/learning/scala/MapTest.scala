package ph.gutierrez.learning.scala

object MapTest {

  def main(args: Array[String]): Unit = {
    val keyValues = Map(
      "John" -> "Smith",
      "Jane" -> "Done")

    println(keyValues.get("John"))
    println(keyValues.get("John").get)
    println(keyValues.get("Juan").getOrElse("!"))
    val ref : Option[String] = keyValues.get("John")

    if (keyValues.get("Juan").eq(None)) println("None!")
  }
}