package com.example.integrador_android
import com.google.gson.annotations.SerializedName
class ResponseActivities {



    data class ResponseActivities(
        @SerializedName("status") var status : String,
        @SerializedName("activity")var name: List<String>)

}


