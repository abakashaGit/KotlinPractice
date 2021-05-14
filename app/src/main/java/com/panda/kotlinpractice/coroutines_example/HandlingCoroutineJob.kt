package com.panda.kotlinpractice.coroutines_example

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.panda.kotlinpractice.R
import kotlinx.android.synthetic.main.activity_handling_coroutine_job.*
import kotlinx.coroutines.*


class HandlingCoroutineJob : AppCompatActivity() {

    private val PROGRESS_START = 0
    private val PROGRESS_MAX = 100
    private val PROGRESS_TIME = 4000
    private lateinit var job:CompletableJob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handling_coroutine_job)

        if (!::job.isInitialized){ // sysntax for checking a lateinit variable
            initJob()
        }

        button_job_start_end.setOnClickListener {

            job_progress.startOrStopProgress(job)
        }

    }

    fun ProgressBar.startOrStopProgress(job:Job){
        if (this.progress > 0 ){
            println("the job is already active so cancelling")

            resetJob()
        }else{
            button_job_start_end.setText("Cancel the Job")
            CoroutineScope(Dispatchers.IO + job).launch{
                updateTheStatusToTextView("The job is running")
                for (i in PROGRESS_START .. PROGRESS_MAX){
                    delay((PROGRESS_TIME/PROGRESS_MAX).toLong())
                    this@startOrStopProgress.progress = i
                }
                updateTheStatusToTextView("The Job is completed")

            }

        }
    }

    private fun updateTheStatusToTextView(text:String) {
        CoroutineScope(Dispatchers.Main).launch {
            job_status.setText(text)
            button_job_start_end.setText("Reset the Job")
        }
    }

    private fun resetJob(){
        if (job.isActive || job.isCompleted){
            job.cancel(CancellationException("Resetting Job"))
        }
        initJob()
    }

    private fun initJob(){
        button_job_start_end.setText("Start Job")
        job_status.setText("")
        job = Job()
        job.invokeOnCompletion {
            it?.message.let {
                var msg = it
                if (msg.isNullOrBlank()){
                    msg = "Unknown calcellation"
                }
                println("the job $job cancelled because of 'it' ${it.toString()} , msg ${msg}")
            }
        }
        job_progress.max = PROGRESS_MAX
        job_progress.progress = PROGRESS_START
    }

    private fun showToast(str:String){
        Toast.makeText(this@HandlingCoroutineJob,str,Toast.LENGTH_SHORT).show()
    }
}
