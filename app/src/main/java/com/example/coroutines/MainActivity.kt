package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val tag = "mainactivity"
        GlobalScope.launch {
           val firstCall = myNetworkCall()
            val secondCall = myNetworkCall2()
            Log.d(tag, firstCall)
            Log.d(tag,secondCall)

        }

    }
    suspend fun myNetworkCall():String{
        delay(3000L)
        return "this is my call"
    }
    suspend fun myNetworkCall2():String{
        delay(3000L)
        return "this is my call 2"
    }
}