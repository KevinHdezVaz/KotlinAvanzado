package com.example.kotlinavanzado.api

import com.example.kotlinavanzado.api.responses.dogListApiResponses
import com.example.kotlinavanzado.model.Dog
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val retrofit =  Retrofit.Builder()
        .baseUrl("https://todogs.herokuapp.com/api/v1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

interface ApiService{
        @GET("dogs")
        suspend fun getAllDogs(): dogListApiResponses
}

object DogsApi{
        val retrofitService: ApiService by lazy {
                retrofit.create(ApiService::class.java)
        }
}
