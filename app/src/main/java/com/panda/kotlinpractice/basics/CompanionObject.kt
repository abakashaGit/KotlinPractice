package com.panda.kotlinpractice.basics

/*
    - It is same like the static method in jave.
    - You can access the method directly through the class name.
    - Here an object is created as a member variable of the same class.
 */

class A{
    companion object{
        fun showMyName(){
            println("My name is Abakasha")
        }
    }
}

fun main() {
    A.showMyName()
}