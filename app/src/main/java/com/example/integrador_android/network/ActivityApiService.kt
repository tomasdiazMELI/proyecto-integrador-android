package com.example.integrador_android.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private const val BASE_URL =
    "http://www.boredapi.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// Singleton
object ActivityApi {
    val retrofitService: IActivityApiService by lazy {
        retrofit.create(IActivityApiService::class.java)
    }
}

interface IActivityApiService {
    @GET("activity?")
    suspend fun getActivity(
        @Query("participants") participants: String,
        @Query("type") type: String,
    ) : ActivityResponse

    @GET("activity?")
    suspend fun getActivityRandom(
        @Query("participants") participants: String,
    ) : ActivityResponse

    /* suspend fun getActivity(
        @Query("participants") participants: String,
    ) : ActivityResponse */

    /* suspend fun getActivity(
        @QueryMap Options: Map<String, String>
    ) : ActivityResponse */

    /*suspend fun getActivity(
        @Query("participants") participants: String,
        @Query("type") activityType: String
    ) : ActivityResponse */
}
