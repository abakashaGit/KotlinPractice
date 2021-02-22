package com.panda.kotlinpractice.design_pattern
/*
When we declare a class with "object" keyword then kotlin uses singleton and allocates sinlge memory
Methods and members inside object is accessed directly with dot(.)keyword as done in Singleton.printValue()
 */
object Singleton {
    init {
        
    }
    fun printValue(){
        println("function inside Singleton object")
    }
}

fun main() {
    print("${Singleton.toString()}  ${Singleton.toString()}")
    Singleton.printValue()
}