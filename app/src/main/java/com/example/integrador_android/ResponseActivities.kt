package com.example.integrador_android
import com.example.integrador_android.model.ActivityClass
import com.google.gson.annotations.SerializedName
    data class ResponseActivities(
        @SerializedName("activity")var name : String,
        @SerializedName("price")var price : Float,
        @SerializedName("activity")var participants : Int)


