package com.fiap.condelivery.network

import com.fiap.condelivery.model.Post
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("/auth/login")
    fun postRequest(@Body requestBody: Post): Call<ResponseBody>
}