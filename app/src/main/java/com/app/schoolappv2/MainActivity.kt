package com.app.schoolappv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.widget.Button
import retrofit2.Response
import android.content.Intent
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button click listener to navigate to SecondActivity
        findViewById<Button>(R.id.bathroomAvailabilityButton)
            .setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }

        // Button click listener to make an API request
        findViewById<Button>(R.id.HTTPTestButton)
            .setOnClickListener{
                makeApiRequest()
            }
    }

    // Function to make an asynchronous API request using Retrofit and coroutines
    fun makeApiRequest(){
        // Creating an instance of ApiService using RetrofitClient
        val apiService = RetrofitClient.getClient().create(ApiService::class.java)

        // Using GlobalScope.launch to launch a coroutine on the main thread
        GlobalScope.launch(Dispatchers.Main) {
            try {
                // Making an API request to get some data
                val response: Response<ApiResponse> = apiService.getSomeData()

                // Checking if the response is successful
                if (response.isSuccessful) {
                    // Parsing the response body
                    val data: ApiResponse? = response.body()
                    // Logging the data
                    Log.d("HTTP REQUEST", data.toString())
                } else {
                    // Handle unsuccessful response (optional)
                }
            } catch (e: Exception) {
                // Handling exceptions and logging an ASCII art error message
                Log.e("HTTP","(\"`-''-/\").___..--''\"`-._ \n" +
                        " `6_ 6  )   `-.  (     ).`-.__.`) \n" +
                        " (_Y_.)'  ._   )  `._ `. ``-..-' \n" +
                        "   _..`--'_..-_/  /--'_.'\n" +
                        "  ((((.-''  ((((.'  (((.-' ")
            }
        }
    }
}
