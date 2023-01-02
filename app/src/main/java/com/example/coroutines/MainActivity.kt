package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val tag = "mainactivity"
        GlobalScope.launch {
            Log.d(tag,"coroutine says hello ${Thread.currentThread().name}")
        }
        Log.d(tag,"main thread says hello ${Thread.currentThread().name}")

    }

}