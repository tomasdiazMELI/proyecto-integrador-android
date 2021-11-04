package com.example.integrador_android
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface APIService {

    @GET("activity")
    suspend fun obtenerActivities(@Query("type") url:String): Response<String>
}



