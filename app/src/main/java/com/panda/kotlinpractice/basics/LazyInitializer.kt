package com.panda.kotlinpractice.basics

class HeavyObject {
    private val lazyInitializer : String by lazy {
        println(" Heavy object initialized  ")
        "heavyObject"
    }

    public fun accessLazyVariable()
    {
        println(lazyInitializer)
    }

    public fun someOtherFuntion(){
        println("  some other funtion")
    }

}


fun main() {
    var heavyObject:HeavyObject = HeavyObject();
    heavyObject.someOtherFuntion()
    heavyObject.accessLazyVariable()
    heavyObject.accessLazyVariable() // this time it will not initialize the lazy variable again but it will get from the cached value
}