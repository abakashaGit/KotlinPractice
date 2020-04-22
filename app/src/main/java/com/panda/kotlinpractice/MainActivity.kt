package com.panda.kotlinpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panda.kotlinpractice.coroutines_example.BasicCoroutines
import com.panda.kotlinpractice.coroutines_example.HandlingCoroutineJob
import kotlinx.android.synthetic.main.activity_main.*
                                                        // no need to the do findViewById


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //imgview.loadImage() // this will call the loadImage method written in the ExtentionFuntion.kt file


        button_coroutine_basic.setOnClickListener {
            startActivity( Intent(this,BasicCoroutines::class.java))
        }

        button_jobs.setOnClickListener {
            startActivity( Intent(this,HandlingCoroutineJob::class.java))
        }

    }


}
