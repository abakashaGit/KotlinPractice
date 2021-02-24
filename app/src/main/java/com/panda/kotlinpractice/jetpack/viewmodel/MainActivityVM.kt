package com.panda.kotlinpractice.jetpack.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.panda.kotlinpractice.R
import com.panda.kotlinpractice.databinding.ActivityMainVMBinding

class MainActivityVM : AppCompatActivity() {

    private lateinit var binding:ActivityMainVMBinding
    private lateinit var viewModel: MainActivityVMViewModel
    private lateinit var viewModelFactory: MainActivityVMFactory
    private val startTotal:Int = 50
/*
We can directly use MainActivityVMViewModel, but the factory is for customise the viewModel.

 */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_v_m)
        viewModelFactory = MainActivityVMFactory(startTotal)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainActivityVMViewModel::class.java)
        viewModel.sumTotal.observe(this, Observer {// We can observe the livedata object here
            // and as the value of the livedata changes then this observer will be called and the value
            binding.result.text = it?.toString()
        })
//        binding.result.text = viewModel.sum.toString()

        binding.add.setOnClickListener {
            // viewModel.sum = viewModel.sum + binding.inputValue.text.toString().toInt()
            viewModel.addValue(binding.inputValue.text.toString().toInt())
            // binding.result.text = viewModel.sum.toString()
        }
    }
}