package com.example.integrador_android.data

import com.example.integrador_android.R
import com.example.integrador_android.model.Activity

class Datasource {
    fun loadActivities(): List<Activity> {
        return listOf<Activity>(
            Activity(R.string.education),
            Activity(R.string.recreational),
            Activity(R.string.social),
            Activity(R.string.diy),
            Activity(R.string.charity),
            Activity(R.string.cooking),
            Activity(R.string.relaxation),
            Activity(R.string.music),
            Activity(R.string.busywork)
        )
    }
}