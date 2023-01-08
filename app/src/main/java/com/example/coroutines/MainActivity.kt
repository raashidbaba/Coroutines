package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TAG = "my activity"
           /*  Log.d(TAG, "this is my second {${Thread.currentThead().name}}")
                val myText = findViewById<TextView>(R.id.textview)*/
                 GlobalScope.launch(Dispatchers.IO) {
                 val time = measureTimeMillis {
                     val answer1 = async { myNetworkCall() }
                     val answer2 = async { myNetworkCall2() }
                     Log.d(TAG,"answer 1 ${answer1.onAwait}")
                     Log.d(TAG,"answer 2 ${answer2.onAwait}")
                 }
                     Log.d(TAG,"request took $time")

                   /* val answer = myNetworkCall()
                    withContext(Dispatchers.Main) {
                    myText.text = answer*/
            }

        }


    }

    suspend fun myNetworkCall(): String {
        delay(3000L)
        return "this is my call"
    }
     suspend fun myNetworkCall2():String{
         delay(3000L)
         return "this is my call 2"
     }
