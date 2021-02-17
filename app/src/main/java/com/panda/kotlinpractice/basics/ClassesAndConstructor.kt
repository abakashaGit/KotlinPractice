package com.panda.kotlinpractice.basics

fun main() {
    var student = Student("Abakasha") // for creating object we dont need to use new keyword
//    println(student.sName)
//    println(student.sAddress)
    var user = User("Abakas",29)
    user.show()
    var user1 = User("smita") // creating object with just one parameter the second will be default
    user1.show()                    // In this case if the default value is not set and you are calling with
                                    // one parameter then compile time error "No value for the parameter"

}

class Student{

    var sName:String = "empty"
    var sAge:Int = 2
    var sAddress:String = ""

    constructor(name:String,age:Int){ // This is secondary constructor
        sName = name
        sAge = age
    }
    constructor(address:String){ // one string parameter will call this one
        sAddress = address
    }
}

//Another call with primary constructor

class User(private val name:String,private val age:Int = 25){ // the value 25 is the default value for the parameter and this is optional
    // you can make the parameters private so that it can not be accessed outside the class

    init { // the block is executed as soon as the constructor is created,
        // you can do any operation needed when the constructor is created
    }
    fun show(){
        println("$name is $age years old") // $ symbol can be used to print string text, no need to concatenation
    }
}