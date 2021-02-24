package com.panda.kotlinpractice.jetpack.databinding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.panda.kotlinpractice.R
import com.panda.kotlinpractice.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {
    /*
    DataBinding happens at compile time so you will not get runtime error while accessing views
    easy to code
    good suit for architecture design
    We can also bind object directly to views in xml file
     */

    lateinit var bindingActivity: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)

        bindingActivity.student = getStudent() // this will directly assign the respective components
        // of the Student object to views defined in the xml file

        bindingActivity.submit.setOnClickListener {
           // bindingActivity.message.text = "hello ${bindingActivity.personName.text}"
            bindingActivity.apply {
                message.text = "Hello ${personName.text}"
            }
        }

        bindingActivity.start.setOnClickListener {
            bindingActivity.apply {
                if (progressBar.isShown){
                    progressBar.visibility = View.GONE
                    start.text = "Start"
                }else{
                    progressBar.visibility = View.VISIBLE
                    start.text = "Stop"
                }
            }
        }


    }
    fun getStudent():Student{
        return Student("Abakash",29,1)
    }
}

data class Student(val name:String,val age:Int, val rank:Int){

}