package com.rog.teach.entity

sealed class Db {
    data class MySQL(val id: Int, val conn: String): Db()
    data class MongoDb(val id: Int, val conn: String): Db()
    data class PostgreSQL(val id:   Int, val conn: String): Db()

    object Help : Db() {
        val conn = "Connection done"
    }
}

val Db.MongoDb.info: String
        get() = "Функция находится вне класса, но есть доступ к внутренним переменным класса ->>> изолированные классы. id = $id и conn = $conn"

fun Db.MongoDb.printInfo() {
    println(info)
}
