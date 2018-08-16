package tries

fun main(args: Array<String>) {
  var fn: String = "HA"
  val tc = tryClasses(fn)
  println("Hello, " + tc.getFirstName2())
  fn = "Alice"
  println(fn)
  println("Hello again, " + tc.getFirstName2())

  val tc1 = tryClasses2(19,"ABC")
  println("Hello , " + tc1.m_Id + " " + tc1.getFirstName2())
}

class tryClasses constructor(var firstName: String ) {
  private var m_FirstName: String = firstName
  private var m_Id: Int = 0

  constructor(id: Int, firstName: String) : this(firstName) {
    m_Id = id
  }
  public fun getFirstName2(): String {
    return m_FirstName;
  }
}

class tryClasses2 {
  private var m_FirstName: String = ""
  var m_Id: Int = 0

  constructor(firstName: String) {
    m_FirstName = firstName
  }

  constructor(id: Int, firstName: String) {
    m_Id = id
    m_FirstName = firstName
  }

  public fun getFirstName2(): String {
    return m_FirstName;
  }
}