package com.app.schoolappv2

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/data/getspecificdata/")
    suspend fun getSomeData(): Response<ApiResponse>
}


data class ApiResponse(
    val count: Int
)