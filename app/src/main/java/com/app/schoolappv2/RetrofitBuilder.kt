package com.app.schoolappv2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton object responsible for creating and managing the Retrofit client
object RetrofitClient {
    // Retrofit instance variable, initially set to null
    private var retrofit: Retrofit? = null

    // Base URL for the API
    private const val BASE_URL = "https://bantingassist.mnode.net"

    // Function to get the Retrofit client instance
    fun getClient(): Retrofit {
        // Check if the retrofit instance is null
        if (retrofit == null) {
            // If null, create a new instance of Retrofit
            retrofit = Retrofit.Builder()
                // Set the base URL for the API
                .baseUrl(BASE_URL)
                // Add Gson converter factory to handle JSON responses
                .addConverterFactory(GsonConverterFactory.create())
                // Build the Retrofit instance
                .build()
        }
        // Return the Retrofit instance
        return retrofit!!
    }
}
