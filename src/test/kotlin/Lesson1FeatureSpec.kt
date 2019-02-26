import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.numerics.shouldBeLessThan
import io.kotlintest.shouldBe
import io.kotlintest.specs.FeatureSpec

class BasicsFeatureSpec : FeatureSpec({
    feature("functions") {
        scenario("sum1 and sum2 works the same") {
            val a = 1
            val b = 2
            sum1(a, b) shouldBe 3
            sum1(a, b) shouldBeLessThan 4
            sum1(0, 3) shouldBe 3
            sum1(-1, 1) shouldBe 0
            // Add greater less checks
        }
    }

    feature("variables") {

        val readOnly = 11
        var reassignable = 3
//            scenario("val can not be reassigned") {
//                readOnly = 12
//            }

        scenario("can be reassigned") {
            reassignable = 6
            reassignable shouldBe 6
        }
    }

    feature("strings") {
        val toge = "toge"
        val ther = "ther"
        val together = "together"

        scenario("concatenation works") {
            toge + ther shouldBe together
        }

        scenario("string interpolation works") {
            "$toge$ther" shouldBe together
        }

        scenario("is not empty") {
            together.isNotBlank() shouldBe true
        }
    }

    feature("conditional expressions") {
        val max = 100
        val min = 0

        scenario("returns max") {
            maxOf(min, max) shouldBe max
        }

        scenario("") {
            minOf(1, 2)
        }
    }

    // Write minOff function

    feature("when expression") {
        describe(1) shouldBe "One"
        describe("hello") shouldBe "Unknown"
        // Add other checks
    }

    feature("collections") {
        val fruits = arrayListOf("Apple", "Orange", "Grapes", "Cherry")

        scenario("") {
            fruits.count() shouldBe 4
            fruits shouldContain "Apple"

            count(fruits) shouldBe 4
        }
    }
})

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun minOf(a: Double, b: Double): Any {
    if (a < b) return a
    return Unit
}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun count(list: ArrayList<String>): Int {
    var counter = 0
    for (i in list) {
        counter += 1
    }
    return counter
}

//home work minOf
fun minOf1(list: List<Int>): Int? {
    var min = list[0]
    for (i in list) {
        if (min > i) min = i
    }
    return min
}

//home work mapOf
val map = mutableMapOf<String, Int>()
val strings = arrayOf("banan","banan","apple","banan","apple","orange","kiwi")

fun count(args : Array<String>): MutableMap<String, Int> {
    for (item in args){
        if(map.containsKey(item)){
            map[item] = map.getValue(item) + 1
        }else{
            map[item] = 1
        }
    }
    return map
    
}


fun main(args : Array<String>) {
    println (count(strings))
}

//home work minOf with vararg
@Throws(IllegalArgumentException::class)
fun minOfVarArg(vararg list:Int):Int  {
    if (list.isEmpty()) {
        throw IllegalArgumentException
    }
    var min = list[0]
    for (i in list) {
        if (i < min) {
            min = i
        }
    }
    return min
}

//home work class
open class Engineer(var name: String, var department: String) {}
class QA(name: String, department: String) : Engineer (name, department) {
    fun releaseTesting(releasedate: Int, releasedfunction: ArrayList<String>) : Boolean {
        if (releasedfunction.size * 2 > releasedate) {
            return false
        } else {
            return true
        }
    }
}
//home work two strings
fun twoStrings (str1:String, str2:String): Boolean{

    val l1 = str1.length
    val l2 = str2.length
    if (l1 <= 1) {
        println("l1  less than 1")
        return false
    }
    if (l1 != l2) 
    {
        println("Str1 не повторяет Str2")
        return false
    }

    val s1 = str1.toLowerCase()
    val s2 = str2.toLowerCase()


    var newString: String
    for (i in 1 until s1.length) {
        newString = s1.takeLast(i) + s1.take(l1 - i)

        if (newString == s2) {
            println("$str2 повторяет $str1")
            return true
        }
    }
    return false
}

//home work one string
fun isUnique(str: String): Boolean {
    if (str.length == 1) 
    return true
    for (a in 0..str.length) {
        for (element in a + 1..str.length) {
            if(str[a] == str[element])
                return false
        }
    }
    return true
}

//home work swift
fun swift(strOne: String, strTwo: String) -> Bool {
    let rotate = {(a: String) -> String in
        return a.substring(to: a.index(a.startIndex, offsetB))
    return false
}
