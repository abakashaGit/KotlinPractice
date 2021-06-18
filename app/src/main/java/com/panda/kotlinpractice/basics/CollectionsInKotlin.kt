package com.panda.kotlinpractice.basics

class CollectionsInKotlin {
    var list:MutableList<Int> = mutableListOf()
    val ez: MutableMap<Int, Int> = mutableMapOf()

    fun addToList(a:Int){
        list.add(a)
    }
    fun printList(){
        println(list)
    }

    fun checkPassword(password:String){
        val haveDigits = password.any{it in "0123456789"}
        val haveLowerCase = password.any{it in "abcdefghijklmnopqrstuvwxyz"}
        val haveUpperCase = password.any{it in "ABCDEFGHIJKLMNOPQRSTUVWXYZ"}
        val haveSpecialChar = password.any{it in "!@#\$%^&*()-+"}
        val list = listOf(haveDigits,haveLowerCase,haveUpperCase,haveSpecialChar)
        val countOfRequired = list.count{ !it }
        println("contains digits $haveDigits")
        println("contains lowercase $haveLowerCase")
        println("contains upperCase $haveUpperCase")
        println("contains SpecialChar $haveSpecialChar")
        println("false number $countOfRequired")
    }


    fun superReducedString(s: String): String {
        // Write your code here
        if(s.length < 2) return s
        var result:String = ""

        for( i in 1 .. s.length-1){
            if(s.get(i) != s.get(i-1)){
                result = result + s.get(i-1)
            }else{
                i.plus(1)
            }
        }

        return result
    }

}

fun main() {
   val col:CollectionsInKotlin = CollectionsInKotlin()
    col.addToList(1)
    col.addToList(2)
    col.addToList(3)
    col.printList()
    col.checkPassword("Ab1")
}