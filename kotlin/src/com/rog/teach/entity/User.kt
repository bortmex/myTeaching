package com.rog.teach.entity

class User {
    var firstName: String = "Alex"
    var secondName: String = "Malaxols"

    constructor(firstName: String, secondName: String) {
        this.firstName = firstName
        this.secondName = secondName
    }

    constructor()

    var login: String? = null
    set(value) {
        if(value == "Codi")
            field = "None"
        else
            field = value
        println("Значение переменной: $field")
    }
    get(){
        val loginField = field ?: "неизвестно" //<- если стояло нулевое значение то поставить что указано после ?:
        println("Значение: $loginField")
        return loginField
    }

    fun printInfo(){
        println("User(firstName='$firstName', secondName='$secondName', login=$login)")
    }

    override fun toString(): String {
        return "User(firstName='$firstName', secondName='$secondName', login=$login)"
    }
}