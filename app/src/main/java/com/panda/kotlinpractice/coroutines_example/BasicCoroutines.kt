package com.panda.kotlinpractice.coroutines_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panda.kotlinpractice.R
import kotlinx.android.synthetic.main.activity_basic_coroutines.*
import kotlinx.coroutines.*

class BasicCoroutines : AppCompatActivity() {

    val JOB_TIME_OUT = 1000L

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

//            CoroutineScope(Dispatchers.IO).launch {
//                fakeApiRequestWithTimeOut()
//            }

            /*
             - make parallel request in coroutine there are basically two ways
             - 1 is making job object.
             - 2 is using "async" and "await()"
             */
//            CoroutineScope(Dispatchers.IO).launch { // Parent job
//
//                val startTime = System.currentTimeMillis()
//                    var job1 = launch { // children job
//                        val time1 = measureTimeMillis {
//                            getResult1FromApi()
//                        }
//                        logThread("time taken $time1")
//
//                    }
//                    var job2 = launch {
//                        val time2= measureTimeMillis {
//                            getResult2FromApi()
//                        }
//                        logThread("time taken $time2")
//                    }
//
//
//                logThread("total time taken by two ${System.currentTimeMillis() - startTime}")// time taked is 6015
//
//            }
            CoroutineScope(Dispatchers.IO).launch {
                getResult1FromApi()
                getResult2FromApi()
            } // this will execute one by one taking a+b time

//            CoroutineScope(Dispatchers.IO).launch {
//
//                val startTime = System.currentTimeMillis()
//                val totalTime = measureTimeMillis {
//                    val result1: Deferred<String> = async {
//                        getResult1FromApi()
//                    }
//                    val result2: Deferred<String> = async {
//                        getResult2FromApi()
//                    }
//
//                    setTextOnMainThread(result1.await()) // await() will wait till the job finishes
//                    setTextOnMainThread(result2.await())
//                }
//
//                logThread("start time $startTime")
//                logThread("total time taken by two ${totalTime}") // as parallel run the time taken is 5064L which is alsomt same as result1 time taken
//
//            }
            /*
             - for sequencial execution of the jobs where one job depends on the result of other job
             - for this we can use async await
             */
            CoroutineScope(Dispatchers.IO).launch {

                val result1 = async {
                    getResult1FromApi()
                }.await()
                val restult2 = async {
                    try {
                        requestApiWithResult1(result1) // passing the result1 as parameter.
                    }catch (e:CancellationException){
                        e.message
                    }

                }.await()

                logThread(restult2.toString())
            runBlocking { // it will block all the coroutine till it ends.

            }
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
        delay(5000) // Does not block thread. Just suspends the coroutine inside the thread
        return "Resul"
    }

    private suspend fun getResult2FromApi(): String {
        logThread("getResult2FromApi")
        delay(1000)
        return "Result #2"
    }
    private suspend fun requestApiWithResult1(result:String): String {
        logThread("requestApiWithResult1")
        delay(1000)
        if (result.equals("Result #1")){
            return "Result #2"
        }
        throw CancellationException("Wrong result1")
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
