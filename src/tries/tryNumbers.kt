package tries

fun main(args: Array<String>) {
  println("Hello:")
  getArrays()
}

fun genNumbers() {
  val oneMil = 1_000_000
  println(oneMil)
  val oneMilL = 1_000_000L
  println(oneMilL)
  val oneMil2: Int = 1000000
  println(oneMil2)
  val oneMilL2: Long = 100000_0
  println(oneMilL2)
  val oneMil3: Int? = 1000000
  println(oneMil3)
  val oneMilL4: Long = 2_000_000L
  println(oneMilL4)

  println(oneMil == oneMil2)
  println(oneMil === oneMil2)
  println(oneMil == oneMil3)
  println(oneMil === oneMil3)

  println(1 in oneMilL..oneMilL4)

  val b1 = 0b01
  val b2 = b1 shl 2
  println(b2)


}

fun getArrays() {
  val ar1 = IntArray(5, { it })
  println(ar1.joinToString());
}

fun <T> arrayToString(a: Array<T>) : String {
  return "{" + a.joinToString() + "}"
}