package com.example.integrador_android
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface APIService {

    @GET
    suspend fun obtenerActivities(@Url url:String): Response<ResponseActivities>
}



