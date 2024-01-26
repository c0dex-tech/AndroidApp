package com.app.schoolappv2

import retrofit2.Response
import retrofit2.http.GET

// Retrofit API service interface defining the endpoint for getting specific data
interface ApiService {
    @GET("/data/getspecificdata/")
    suspend fun getSomeData(): Response<ApiResponse>
}

// Data class representing the response from the API
data class ApiResponse(
    val count: Int  // A simple data field indicating the count received in the API response
)
