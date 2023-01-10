package com.example.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mybutton = findViewById<Button>(R.id.btn1)
        mybutton.setOnClickListener {
lifecycleScope.launch {
    delay(1000L)
    while (true){
        Log.d("activity","still running")
    }
}
            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity,MainActivity2::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}
