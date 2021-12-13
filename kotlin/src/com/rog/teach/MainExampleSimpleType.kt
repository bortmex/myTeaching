fun main() {
    println("Hello world")
    var number: Int = 21

    println("Переменная = " + number)
    println("Переменная = $number")

    var name: String = "John"
    var name1 = "John"
    var charExample: Char = 's'

    var isTrue: Boolean = false
    var floatExample = 4.999f
    var doubleExample: Double = 4.4523542423424234234

    val numbers: Int = 4//типа finaly

    var resultname = name + name1
    println(resultname)

    var word: String? = null
    var numberEXample1 = 5
    when(numberEXample1) {
        null -> println("null")
        10 -> println("10")
        5 -> println("5")
    }

    println(if (numberEXample1 > 5) 1 else 0)

    sayHello()

    sayManyStr("second", 12)
    println(sum(1,2))
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun sayHello() {
    println("Hello world")
}

fun sayManyStr(first:String, number: Int) {
    println("$first - $number")
}

fun saySomething():String = "Hi" // функция в одну строку