package ph.gutierrez.sandbox.scala


trait Eater {
	def eat() : Unit
	
	def capacity : Int = 0
}

class Person(fname: String, mname: String, lname: String) extends AnyRef with Eater {

  private var _firstName: String = fname

  private var _middleName: String = mname

  private var _lastName: String = lname
  
  require(_lastName != null && _lastName.length > 0, "'lastName' is required.")

  // Setters and getters, ala C# properties
  def firstName : String = _firstName
  def firstName_=(fname: String): Unit = _firstName = fname
  
  def lastName : String = _lastName
  
  def middleName : String = _middleName
  
  def this(fname: String, lname: String) {
    this(fname, "", lname)
  }

  override def toString() = firstName + " " + lastName

  override def equals(rhs: Any): Boolean = {
    rhs.isInstanceOf[Person] && {
      val other = rhs.asInstanceOf[Person]
      firstName == other.firstName && lastName == other.lastName && middleName == other.middleName
    }
  }
  
  def eat() : Unit = {
	  
  }
}

class TroubleMaker(firstName: String, middleName: String, lastName:String) extends Person (firstName: String, middleName: String, lastName:String) {
	override def eat() : Unit = {
		// eat a lot
	}
}


object PersonRunner {
  def main(args: Array[String]): Unit = {
    var me = new Person("Jeff", "Gutierrez")
    var her = new Person("Gutierrez", "Gutierrez")
    var alias = new Person("Jeff", "Gutierrez")

    if (me eq alias) {
      println("me eq alias")
    }

    if (me == her) {
      println("me eq her")
    }

    if (me == alias) {
      println("me == alias")
    }

    if (me == me) {
      println("me == me")
    }

    val error = new Person("Jeff", "")
    
  }
}