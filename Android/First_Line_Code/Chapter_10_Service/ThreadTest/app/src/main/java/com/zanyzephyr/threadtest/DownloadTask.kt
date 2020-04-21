package com.zanyzephyr.threadtest

import android.os.AsyncTask
import android.util.Log
import android.widget.Toast

class DownloadTask: AsyncTask<Unit, Int, Boolean>() {

    private val TAG = "DownloadTask"

    override fun onPreExecute() {
//        progressDialog.show() //显示进度对话框
    }

    override fun doInBackground(vararg params: Unit?): Boolean {

        return true
    }

    override fun onProgressUpdate(vararg values: Int?) {
        Log.i(TAG, "onProgressUpdate: $values")
        // 在这里更新下载进度
//        progressDialog.setMessage("Downloaded ${values[0]}%")
    }

    override fun onPostExecute(result: Boolean?) {
        Log.i(TAG, "onPostExecute, result: $result")
        // 在这里提示下载结果
        if (result == true) {
//            Toast.makeText(context, "Download successed", Toast.LENGTH_SHORT).show()
        } else {
//            Toast.makeText(context, "Download failed", Toast.LENGTH_SHORT).show()
        }
    }
}
