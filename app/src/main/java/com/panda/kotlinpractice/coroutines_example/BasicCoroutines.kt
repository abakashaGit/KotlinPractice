package com.panda.kotlinpractice.coroutines_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panda.kotlinpractice.R
import kotlinx.android.synthetic.main.activity_basic_coroutines.*
import kotlinx.coroutines.*

class BasicCoroutines : AppCompatActivity() {

    val JOB_TIME_OUT = 100L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_coroutines)

        btn_make_call.setOnClickListener {


            CoroutineScope(Dispatchers.IO).launch {
                fakeApiRequest()
            }
            /*
               - Using CoroutineScope you can create many coroutines and manage them
                 all at once like cancelling them as the user moves away.
               -Dispatchers.IO - is for making some network reqest or doing some small background operation.
               -Dispatchers.Main - is to do things in the main thread like UI operations
               -Dispatchers.Default - is for the heavy compitation work.
               - launch - is like a builder for the coroutine,
             */

            CoroutineScope(Dispatchers.IO).launch {
                fakeApiRequestWithTimeOut()
            }

        }
    }

    private fun setNewText(input: String){
        val newText = text.text.toString() + "\n$input"
        text.text = newText
    }
    private suspend fun setTextOnMainThread(input: String) {
        withContext (Dispatchers.Main) {
            setNewText(input)
        }
    }

    private suspend fun fakeApiRequest() {
        logThread("fakeApiRequest")

        val result1 = getResult1FromApi() // wait until job is done

        if ( result1.equals("Result #1")) {

            setTextOnMainThread("Got $result1")

            val result2 = getResult2FromApi() // wait until job is done

            if (result2.equals("Result #2")) {
                setTextOnMainThread("Got $result2")
            } else {
                setTextOnMainThread("Couldn't get Result #2")
            }
        } else {
            setTextOnMainThread("Couldn't get Result #1")
        }
    }


    private suspend fun getResult1FromApi(): String {
        logThread("getResult1FromApi")
        delay(1000) // Does not block thread. Just suspends the coroutine inside the thread
        return "Result #1"
    }

    private suspend fun getResult2FromApi(): String {
        logThread("getResult2FromApi")
        delay(1000)
        return "Result #2"
    }

    private fun logThread(methodName: String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }

    //Network timeout with coroutine
    private suspend fun fakeApiRequestWithTimeOut(){
        withContext(Dispatchers.IO){
           val job = withTimeoutOrNull(JOB_TIME_OUT){
               val result1 = getResult1FromApi()
               setTextOnMainThread(result1)

               val result2 = getResult2FromApi()
               setTextOnMainThread(result2)

           }
            if (job == null){
                setTextOnMainThread("time out")
                logThread("time out the job took longer than $JOB_TIME_OUT")
            }
        }
    }
}
