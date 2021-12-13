fun printArray(items: List<Any>) {
    items.forEach { el ->
        println(el)
    }
}

fun main(args: Array<String>) {
    val array: Array<Int> = arrayOf(1,2,3,4,5,6)
    println(array.set(1, 123213))
    println(array[1])
    println(array.get(3))

//    for (i in array) {
//        println(i)
//    }

    var someArray = arrayOf(true, false)
    someArray.forEach {
        el -> println(el)
    }

    val lists = listOf(5,3,1,342)
    lists[1]
    val user: Map<String, String> = mapOf("name" to "qwer", "name1" to "asdf")
//    val users: Map<String, Any> = mapOf("name" to "qwer", "name1" to 123)
    val users = mutableMapOf("name" to "qwer", "name1" to 123)
    users["name"] = "qwer1"
    user.forEach { (key, value) -> println("$key -> $value")}

    var mul_list = mutableListOf<Any>(12,123,24,34)
    mul_list.add(1,"123")
//    mul_list.forEach { qwe -> println("$qwe")}
    printArray(mul_list)
}