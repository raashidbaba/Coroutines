package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
        /* api.getComments().enqueue(object : Callback<List<Comment>> {
             override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                 Log.e("main", "ERROR: $t")
             }

             override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                 if (response.isSuccessful){
                     response.body()?.let {
                         for (comment in it){
                             Log.d("main",comment.toString())
                         }

                     }
                 }
             }
         })
 */
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getComments()
            if (response.isSuccessful) {
                for (comment in response.body()!!) {
                    Log.d("activity", comment.toString())
                }
            }
        }
    }
}