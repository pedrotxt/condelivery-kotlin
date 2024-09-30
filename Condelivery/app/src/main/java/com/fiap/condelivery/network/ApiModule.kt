package com.fiap.condelivery.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://backend-condelivery.onrender.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val services = retrofit.create(ApiService::class.java)

val body = mapOf(
    "email" to "teste@teste.com",
    "password" to "testando"
)
