package com.panda.kotlinpractice.basics

class Person(val first_name:String,val last_name:String){
    var mobile:String = "Unknown"
    var address:String = "Unknown"
    fun getInfo() = " name = $first_name $last_name \n mobile = $mobile \n address = $address "


}
class Person1() {
    var name: String = "Abcd"
    var contactNumber: String = "1234567890"
    var address: String = "xyz"
    fun displayInfo()  = print("\n Name: $name\n " +
            "Contact Number: $contactNumber\n " +
            "Address: $address")

}

fun main() {

    //Use of "let" and "also"

    val numbers = mutableListOf<String>("one","two","three","four")
    numbers.map { it.length }
            .also { // also can just be used to print the result in the intermediate state without breaking the chain
                // it can be used for debuging and logging
                println("inside also")
                println(it)
            }
            .filter { it > 3 }
            .let {
        //println(it)
    }
    /*
    -The output is [5,4]
    -the expression inside the map will create an iterable with "it.length" which is the length of the string
    -filter will filter out the items from the iterable which does not satisfy the condition
    -println(it) here "it" refers to the result
     */
    var output = numbers.map { it.length }.filter { it > 3 }.let {
        it
    } // you can also save the result in a variable and latter use it.
   // println(output)

    // null check with let
    var nullable_var:String? = "empty"
    nullable_var?.let {
        //println(it)
    }

    //End of "let"

    //start of "run"

    var person = Person("abakas","panda").run {
       // println(getInfo()) // priror to adding  the fields the values are unknown

        address = "mahadev"
        mobile = "123" // adding this two will not change the object

        //println(getInfo())
        getInfo()// The last statement of the run block will return the value to the varialble
        //the default return type in kotlin is Kotlin.Unit
    }
    //println("print outside run")
    //println(person)

    // start of apply
    // apply is used to simply initialize the object
//    val person2 = Person("Amir", "khan").apply {
//        address = "aksha"
//        mobile = "12344"
//    }// no matter what is the last statement of the block, it will always return the same Object
//    println(person2.getInfo())
//    person2.address = "bang"
//    println(person2.getInfo())

}