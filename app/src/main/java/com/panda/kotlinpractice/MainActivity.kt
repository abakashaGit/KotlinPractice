package com.panda.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.panda.kotlinpractice.basics.loadImage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView : ImageView = findViewById(R.id.imgview)
        imageView.loadImage() // this will call the loadImage method written in the ExtentionFuntion.kt file

    }
}
