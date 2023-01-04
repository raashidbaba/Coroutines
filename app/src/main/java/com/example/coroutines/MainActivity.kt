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
      GlobalScope.launch(Dispatchers.IO) {
          Log.d(TAG,"this is my first {${Thread.currentThread().name}}")
          val answer = myNetworkCall()
          withContext(Dispatchers.Main){
              Log.d(TAG,"this is my second {${Thread.currentThread().name}}")
              val myText = findViewById<TextView>(R.id.textview)
              myText.text = answer
          }
      }

    }
   suspend fun myNetworkCall():String{
        delay(3000L)
        return "this is my call"
    }
   /* suspend fun myNetworkCall2():String{
        delay(3000L)
        return "this is my call 2"
    }*/
}