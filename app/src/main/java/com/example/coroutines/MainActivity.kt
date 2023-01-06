package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TAG = "my activity"
           /*  Log.d(TAG, "this is my second {${Thread.currentThead().name}}")
                val myText = findViewById<TextView>(R.id.textview)*/
              val myjob =   GlobalScope.launch(Dispatchers.Default) {
                  repeat(5){
                      Log.d(TAG,"is still working")


                   /* val answer = myNetworkCall()
                    withContext(Dispatchers.Main) {
                    myText.text = answer*/
            }
        }
        runBlocking {
            myjob.join()

        }

    }

    suspend fun myNetworkCall(): String {
        delay(3000L)
        return "this is my call"
    }
    /* suspend fun myNetworkCall2():String{
         delay(3000L)
         return "this is my call 2"
     }*/
}