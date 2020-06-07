package com.panda.kotlinpractice.basics

class Account() {
    var name: String = "Abcd"
    var contactNumber: String = "1234567890"
    var address: String = "xyz"
    fun displayInfo()  = print("\n Name: $name\n " +
            "Contact Number: $contactNumber\n " +
            "Address: $address")

}

fun main() {
//    val account = Account().let {
//        it.name = "Abakasha"
//    }
//    //println(account)
//
//    val numbers = mutableListOf("One", "Two", "Three", "Four", "Five")
//    numbers.map { it }.filter { it.length > 3 }.let {
//        print(it)
//    }

    Account().run {
        name = "Asdf"
        contactNumber = "0987654321"
        return@run "The details of the Person is: ${displayInfo()}"
    }



}