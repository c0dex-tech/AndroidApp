package com.myapp.app

import ApiService
import CountItem
import DataResponse
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://54.160.202.75")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
        )
        .build()

    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fetchDataButton: Button = findViewById(R.id.fetchDataButton)
        fetchDataButton.setOnClickListener {
            makeApiRequest()

        }
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }

    private fun makeApiRequest() {
        val call = apiService.fetchData()

        call.enqueue(object : Callback<List<DataResponse>> {
            override fun onResponse(
                call: Call<List<DataResponse>>,
                response: Response<List<DataResponse>>
            ) {
                if (response.isSuccessful) {
                    val dataResponse: List<DataResponse>? = response.body()

                    dataResponse?.let { dataResponses ->
                        for (dataResponse in dataResponses) {
                            val countItems: List<CountItem> = dataResponse.count
                            for (countItem in countItems) {
                                val countValue = countItem.count
                                Log.d("TAG", "COUNT Value: $countValue")
                            }
                        }
                    }
                } else {
                    Log.e("TAG", "Unsuccessful response: ${response.code()}")
                    Log.e("TAG", "Error Body: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<List<DataResponse>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
