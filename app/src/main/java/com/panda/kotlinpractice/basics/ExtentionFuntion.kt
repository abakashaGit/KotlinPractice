package com.panda.kotlinpractice.basics

import android.graphics.Color
import android.widget.ImageView

/*- Extension Functions are the functions which can add a new funtion to a class without
    the need to extend or modify the original class.
  - Extension functions can be accessed statically.
  -
*/

class Candidate {
    var skills : String = "null"

    fun printMySkills() {
        print(skills)
    }
}

fun main(args: Array<String>) {
    var  a1 = Candidate()
    a1.skills = "JAVA"
    //a1.printMySkills()

    var  a2 = Candidate()
    a2.skills = "SQL"
    //a2.printMySkills()

    var  a3 = Candidate()
    a3.skills = a1.addMySkills(a2) // here addMySkills is an extended function mentioned bellow
    a3.printMySkills()
}

fun Candidate.addMySkills(c :Candidate) :String{
    return "skills are ${this.skills } and ${c.skills} "
}


// here is an example of extension funtion which extends the android.widget.ImageView class without extending it.
fun ImageView.loadImage(){
    this.setBackgroundColor(Color.BLACK)
}





