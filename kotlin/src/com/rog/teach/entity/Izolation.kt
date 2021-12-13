package com.rog.teach.entity

class Izolation {
    companion object {  //<-- аналог статика в java
        var count = 0
    }

    init {
        count++
        println("Создано: $count")
    }
}

fun filterList(list: List<String>, filter: (String) -> Boolean) {
    list.forEach { el ->  //чтото типа функциональных интерфейсов и лямбд
        if(filter(el))
            println(el)
    }
}

val filter: (String) -> Boolean = {
    it.startsWith("J")
}

fun main() {
//    var test = Izolation()
//    var test1 = Izolation()
//    var test2 = Izolation()
//    var test3 = Izolation()

    val db = Db.MongoDb(5, "mongo")
    val db_2 = Db.PostgreSQL(6, "postgres")

    val db_copy = db.copy(conn = "CopyPostgress")
    if(db == db_copy)
        println("Они равны")
    else
        println("Они не равны")

    db.printInfo()

    val list = listOf("Java", "PHP", "Perl", "JavaScript", "C++")
    filterList(list, /*{it.startsWith("P")}*/filter)
}