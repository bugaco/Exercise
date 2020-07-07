package com.zanyzephyr.okhttptest

import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://www.v2ex.com")
        .build()
    val response = client.newCall(request).execute()
    val resonseData = response.body?.string()
    println(resonseData)
}