package ph.gutierrez.learning.scala

import scala.collection.mutable._

abstract class Animal {
  def makeSound(): Unit

  def test(): Unit = {}

  def <--+(mate: Animal) {
    println("--buntis!")
  }

}

class Mammal extends Animal {
	override def test(): Unit ={}
  def makeSound(): Unit = { println("Moo...") }
}

class Aves extends Animal {
  def makeSound(): Unit = { println("Tweet, tweet") }
}

object AbstractClasses {

  def main(args: Array[String]): Unit = {
    val gorilla: Mammal = new Mammal()
    val whale: Mammal = new Mammal()
    val sparrow: Aves = new Aves()

    // `` allow for naming identifiers using arbitrary characters.
    val `val`: Aves = new Aves()
    val `ijslfk2o34972ojm2lk4nj2i40928402938409283  234 23 ` = new Aves()

    // Initializing a list
    val animals: Seq[Animal] = LinkedList(gorilla, whale, sparrow, `val`)
    this rattleCage animals

    // Since operator chars can be used in method names, new operators can be introducted. 
    // Operator chars must be followed by other chars as well.
    gorilla <--+ whale
    `ijslfk2o34972ojm2lk4nj2i40928402938409283  234 23 ` <--+ sparrow
  }

  def rattleCage(animals: Seq[Animal]) {
    animals.foreach(_.makeSound());
  }

  def $(): Int = {
    println("$$$")
    10
  }

}