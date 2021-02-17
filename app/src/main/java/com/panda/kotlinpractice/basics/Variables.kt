package com.panda.kotlinpractice.basics

lateinit var var_lateinit:String //late init variables are initialised latter
const val name_con:String = "const_name"

fun main() {

    val x = returnValue()
    val name = "hello"
    print(name)
    // name = null // val can not be reassigned.

    var name1:String = "hello1"
    name1 = "Hi"
    print("\n"+name1)
    // name1 = null // null can not be assigned to a variable of non null type

    var name2:String? // "?" is for indicating that the var can be assigned with null
    name2 = null
    print(name2)

    if (::var_lateinit.isInitialized){
        print(var_lateinit)
    }else{
        var_lateinit = "lately initialized"
    }

    println("\n"+ var_lateinit)

}

fun returnValue():Int{
    return 5
}