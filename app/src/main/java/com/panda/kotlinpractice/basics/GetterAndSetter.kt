package com.panda.kotlinpractice.basics

private var rating = 15 // this is enough in Kotlin we do not explicitly require to define getter
    // and setter for a property
get() { // this block executes when we access the value rating
    if (field < 5)
        print( "This is a terible book")
    return field
}
set(value) { // this block executes when we assign a value to rating
    field = when{
        value > 10 -> 10
        value < 0 -> 0
        else -> value
    }
}// the keyword "field" is used to set the value to avoid recursive call to the set() method.

fun main() {
    rating = 15
    print(rating)
}