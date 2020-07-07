package com.zanyzephyr.httpurlconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.io.StringReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.SAXParserFactory
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendRequestBtn.setOnClickListener {
            requestXMLDataWithOkHttp()
        }
    }

    private fun sendRequestWithHttpURLConnection() {

        thread {
            sendRequestWithOkHttp()
        }
    }

    private fun requestWithHttpURLConnection() {
        // 开启线程发起网络请求
        var connection: HttpURLConnection? = null
        try {
            val response = StringBuilder()
            val url = URL("https://www.baidu.com")
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            /* 给服务器传参 */
            connection.requestMethod = "POST"
            val output = DataOutputStream(connection.outputStream)
            output.writeBytes("username=admin&password=123456")

            connection.connectTimeout = 8000
            connection.readTimeout = 8000
            val input = connection.inputStream
            // 对获取到的数据流进行读取
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    response.append(it)
                }
            }
            showResponse(response.toString())
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()
        }
    }

    private fun sendRequestWithOkHttp() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("https://www.v2ex.com")
                    .build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                if (responseData != null) {
                    showResponse(responseData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun requestXMLDataWithOkHttp() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("http://192.168.3.11/get_data.xml")
                    .build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                if (responseData != null) {
//                    parseXMLWithPull(responseData)
                    parseXMLWithSAX(responseData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun sendRequestWithOkHttpByPost() {
        thread {
            try {
                val client = OkHttpClient()

                val requestBody = FormBody.Builder()
                    .add("username", "admin")
                    .add("password", "123456")
                    .build()

                val request = Request.Builder()
                    .url("https://www.baidu.com")
                    .post(requestBody)
                    .build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                if (responseData != null) {
                    showResponse(responseData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun parseXMLWithPull(xmlData: String) {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val xmlPullParser = factory.newPullParser()
            xmlPullParser.setInput(StringReader(xmlData))
            var eventType = xmlPullParser.eventType
            var id = ""
            var name = ""
            var version = ""
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val nodeName = xmlPullParser.name
                when (eventType) {
                    // 开始解析某个节点
                    XmlPullParser.START_TAG -> {
                        when (nodeName) {
                            "id" -> id = xmlPullParser.nextText()
                            "name" -> name = xmlPullParser.nextText()
                            "version" -> version = xmlPullParser.nextText()
                        }
                    }
                    // 完成解析某个节点
                    XmlPullParser.END_TAG -> {
                        Log.i("MainActivity", "id is $id")
                        Log.i("MainActivity", "name is $name")
                        Log.i("MainActivity", "version is $version")
                    }
                }
                eventType = xmlPullParser.next()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun parseXMLWithSAX(xmlData: String) {
        try {
            val factory = SAXParserFactory.newInstance()
            val xmlReader = factory.newSAXParser().xmlReader
            val handler = ContentHandler()
            // 将ContentHandler的实例设置到XMLReader中
            xmlReader.contentHandler = handler
            // 开始执行解析
            xmlReader.parse(InputSource(StringReader(xmlData)))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            // 在这里进行UI操作，将结果显示到界面上
            responseText.text = response
        }
    }
}
