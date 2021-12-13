fun printSome(item: String = "Hi", vararg word: /*String*/Any) { //если не известно сколько параметров
    print("$item: ")
    word.forEach { el -> print("$el ") }
    println("")
}
fun main() {
    val names = arrayOf("Bob", "Dima" , 123)
    printSome()
//    printSome("one")
//    printSome("one", "two")
//    printSome("one", "two", "three")
//    printSome("Hi", *names)
    printSome(word = arrayOf("123"))

    for (i in 0..3){
        println(i)
    }

    for (i in 10 downTo 0 step 2){
        println(i)
    }

    for (i in 'z' downTo 'a'){
        println(i)
    }

}