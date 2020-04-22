package com.zanyzephyr.jsonparsetest

import okhttp3.EventListener
import okhttp3.HttpUrl
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

interface HttpCallbackListener {
    fun onFinish(response: String)
    fun onError(e: Exception)
}

object HttpUtil {
    fun sendHttpRequest(address: String, listener: HttpCallbackListener) {
        thread {
            var connection: HttpURLConnection? = null
            try {
                val response = StringBuilder()
                val url = URL(address)
                connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                val input = connection.inputStream
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    it.forEachLine {
                        response.append(it)
                    }
                }
                listener.onFinish(response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
                listener.onError(e)
            } finally {
                connection?.disconnect()
            }
        }
    }
}

fun main() {
    val address = "https://www.v2ex.com"
    HttpUtil.sendHttpRequest(address, object : HttpCallbackListener {
        override fun onFinish(response: String) {

        }

        override fun onError(e: Exception) {

        }
    })
}