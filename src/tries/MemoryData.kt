package tries

import com.google.gson.Gson
import com.google.gson.GsonBuilder

// LINK Gson tutorial : http://www.studytrails.com/java/json/java-google-json-introduction/
fun main( args: Array<String>) {
  val memoryData: MemoryData = MemoryData(1, "Jacke")

  val gb: GsonBuilder = GsonBuilder()
  gb.setPrettyPrinting()
  val gson: Gson = gb.create();
  val result = gson.toJson(memoryData)

  println(result)
}

class MemoryData(val id: Int, val name: String) {

}