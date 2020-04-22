package com.zanyzephyr.jsonparsetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.lang.Exception
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            requestJSONDataWithOkHttp()
        }
    }

    private fun requestJSONDataWithOkHttp() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                        .url("http://192.168.3.11/get_data.json")
                        .build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                if (responseData != null) {
                    parJSONWithGson(responseData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun parJSONWithGson(jsonData: String) {
        try {
            val gson = Gson()
            val typeOf = object : TypeToken<List<App>>(){}.type
            val appList = gson.fromJson<List<App>>(jsonData, typeOf)
            for (app in appList) {
                Log.d("MainActivity", "id is ${app.id}")
                Log.d("MainActivity", "name is ${app.name}")
                Log.d("MainActivity", "version is ${app.version}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun parJSONWithJSONObject(jsonData: String) {
        try {
            val jsonArray = JSONArray(jsonData)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val id = jsonObject.getString("id")
                val name = jsonObject.getString("name")
                val version = jsonObject.getString("version")
                Log.d("MainActivity", "id is $id")
                Log.d("MainActivity", "name is $name")
                Log.d("MainActivity", "version is $version")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

class App(val id: String, val name: String, val version: String)

