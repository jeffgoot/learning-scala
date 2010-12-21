/**
 * $Header$
 * 
 * Scala-Sandbox - ph.gutierrez.learning.scala
 * 
 * Copyright (C) 2010 gutierrez.ph
 * All Rights Reserved
 * 
 **/
package ph.gutierrez.learning.scala

/**
 * Models a vehicle that can only move.
 * @author <a href="mailto:jeff@gutierrez.ph">Jeff Gutierrez</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
abstract class Vehicle(val numberOfWheels: Int) {
  def forward(distanceFeet: Int): Unit
}

class Car extends Vehicle(4) {
  override def forward(distanceFeet: Int): Unit = {
    println("Vroom, vroom...")
  }

  override def toString(): String = "(Car)"
}

class Motorcycle extends Vehicle(2) {
  override def forward(distanceFeet: Int): Unit = {
    println("Pruuu...")
  }

  override def toString(): String = "(Motorcycle)"
}

/**
 * Companion object used as factory of Vehicles
 * 
 * @author <a href="mailto:jeff@gutierrez.ph">Jeff Gutierrez</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
object Vehicle {

  def apply(numberOfWheels: Int): Vehicle = {
    numberOfWheels match {
      case 4 => new Car()
      case 2 => new Motorcycle()
      case _ => new Car()
    }
  }

  def unapply(target: Vehicle) = Some(target.numberOfWheels)
}

/**
 * A singleton object; not a companion object.
 * @author <a href="mailto:jeff@gutierrez.ph">Jeff Gutierrez</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
object VehicleDemo {
  def main(args: Array[String]): Unit = {
    applyInAction()
    unapplyInAction(Vehicle(4))
  }

  def unapplyInAction(target: Vehicle): Unit = {
    target match {
      case Vehicle(4) => println("It's a Car!")
      case Vehicle(2) => println("It's a Motorcycle!")
    }
  }

  def applyInAction(): Unit = {
    val prius = Vehicle(4)
    println(prius)

    val kawasakiX123 = Vehicle(2)
    println(kawasakiX123)
  }
}