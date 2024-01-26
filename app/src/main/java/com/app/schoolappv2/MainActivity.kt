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
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        findViewById<Button>(R.id.bathroomAvailabilityButton)
            .setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }

        findViewById<Button>(R.id.HTTPTestButton)
            .setOnClickListener{
                makeApiRequest()
            }
    }

    fun makeApiRequest(){
        val apiService = RetrofitClient.getClient().create(ApiService::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response: Response<ApiResponse> = apiService.getSomeData()
                if (response.isSuccessful) {
                    val data: ApiResponse? = response.body()
                    Log.d("HTTP REQUEST", data.toString())
                } else {

                }
            } catch (e: Exception) {
                Log.e("HTTP","(\"`-''-/\").___..--''\"`-._ \n" +
                        " `6_ 6  )   `-.  (     ).`-.__.`) \n" +
                        " (_Y_.)'  ._   )  `._ `. ``-..-' \n" +
                        "   _..`--'_..-_/  /--'_.'\n" +
                        "  ((((.-''  ((((.'  (((.-' ")
            }
        }
    }
}
