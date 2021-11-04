package com.example.integrador_android.network

data class ActivityResponse (
    val activity: String,
    val type: String,
    val participants: Int,
    val price: Float,
    val link: String,
    val key: String,
    val accessibility: Float
)

/* {
"activity":"Start a blog for something you're passionate about",
"type":"recreational",
"participants":1,
"price":0.05,
"link":"",
"key":"8364626",
"accessibility":0.1}
*/