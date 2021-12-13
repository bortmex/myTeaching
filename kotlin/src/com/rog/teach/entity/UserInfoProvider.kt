package com.rog.teach.entity

interface UserInfoProvider {
    val info: String
    fun printInfo(user: User)
}

interface DbConnection {
    fun getConnection() : String
}

open class MainProvider : UserInfoProvider, DbConnection {
    open val db : String = "Db Connected"
    override val info: String
        get() = "Hello"

    override fun printInfo(user: User) {
        println("Hello")
        user
    }

    override fun getConnection(): String {
        return "DbConnection"
    }
}

fun main() {
    val user = NewClass()
    user.printInfo(User())
    println(user.getConnection())
}