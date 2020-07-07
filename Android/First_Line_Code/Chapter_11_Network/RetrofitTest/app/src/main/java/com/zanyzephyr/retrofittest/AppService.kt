package com.zanyzephyr.retrofittest

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface AppService {
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>

    /* 动态路径：传入page
    * 对比硬编码的路径："1/get_data.json"、"2/get_data.json"
    *  */
    @GET("{page}/get_data.json")
    fun getData(@Path("page") page: Int): Call<Data>

    /* 在url路径中传入多个参数
    * 对比硬编码的写法：get_data.json?u=<user>&t=<token> */
    @GET("get_data.json")
    fun getData(@Query("u") user: String, @Query("t") token: String): Call<Data>

    /* 删除指定id的数据
    * ResponseBody 表示对服务器响应的数据不关心 */
    @DELETE("data/{id}")
    fun deleteData(@Path("id") id: String): Call<ResponseBody>

    /* 使用body传参数 */
    @POST("data/create")
    fun createData(@Body data: Data): Call<ResponseBody>

    /* 固定header的请求 */
    @Headers("user-agent:okhttp", "Cache-Control:max-age=0")
    @GET("get_data.json")
    fun getData(): Call<Data>

    /* 动态header的请求 */
    @Headers("user-agent:okhttp", "Cache-Control:max-age=0")
    @GET("get_data.json")
    fun getDataWithHeader(@Header("user-agent") userAgent: String,
                          @Header("Cache-Control") cacheControl: String): Call<Data>
}

fun main() {

}