package com.panda.kotlinpractice.basics

//Question 1
open class Shoe(val size:Long){
    protected fun printShowSize(){
        print(size) // this will print 41
    }
}

//class AddidasShoe: Shoe {
//    constructor(size: Long) : super(size + 3) {
//
//    }
//}
// the above declaration is same as the bellow declaration
// you can either declare as primary constructor or secondary constructor with super
class AddidasShoe(size: Long) : Shoe(size + 3) {
    init {
        print(printShowSize())
    }
}

fun main() {
    AddidasShoe(38)
}

//Question 2
open class Component{
    open fun click(){
        println("Clicking from component")
    }
}
abstract class Mouse:Component(){
    abstract override fun click()
}

