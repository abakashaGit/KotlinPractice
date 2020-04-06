package com.panda.kotlinpractice.basics

/*
- Interface in Kotlin can have both abstract and concrete method like java 8
- An Interface in kotlin may or may not have an abstract method
- No need to override the concrete method, though you can directly access the concrete method directly
- the abstract property variable can also be assigned in the child class which implement the Interface.
 */

interface ExampleInterface  {
    var myVar: Int            // abstract property can be assigned in child class
    fun absMethod():String    // abstract method, needs to provide implementation

    fun hello() {
        println("Hello there, this is panda ")
    }
}

class InterfaceImp : ExampleInterface {
    override var myVar: Int = 25
    override fun absMethod() = "Happy Learning "
}

fun main(args: Array<String>) {
    val obj = InterfaceImp()
    println("My Variable Value is = ${obj.myVar}")
    print("Calling hello(): ")
    obj.hello()

    print("Message from the Website-- ")
    println(obj.absMethod())
}
