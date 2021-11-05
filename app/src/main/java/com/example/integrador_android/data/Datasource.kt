package com.example.integrador_android.data

import com.example.integrador_android.R
import com.example.integrador_android.model.ActivityModel

class Datasource() {
    fun loadActivities(): List<ActivityModel> {
        return listOf(
            ActivityModel(R.string.education),
            ActivityModel(R.string.recreational),
            ActivityModel(R.string.social),
            ActivityModel(R.string.diy),
            ActivityModel(R.string.charity),
            ActivityModel(R.string.cooking),
            ActivityModel(R.string.relaxation),
            ActivityModel(R.string.music),
            ActivityModel(R.string.busywork)
        )
    }
}