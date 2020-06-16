package com.shinyongsung.practice_200616.util

import android.content.Context
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class ServerUtil {

    companion object {

        val BASE_URL = "http://15.165.177.142"

        fun postRequestLogin(context: Context, id:String, pw:String, handler: JsonResponseHandler?) {

            val client = OkHttpClient()

            val urlString = "${BASE_URL}/user"

            val formData = FormBody.Builder()
                .add("email", id)
                .add("password", pw)
                .build()

            val request = Request.Builder()
                .url(urlString)
                .post(formData)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: java.io.IOException) {

                }

                override fun onResponse(call: Call, response: Response) {

                    val bodyString = response.body!!.string()

                    val json = JSONObject(bodyString)

                    handler?.onResponse(json)

                }
            })
        }

        interface JsonResponseHandler {
            fun onResponse(json: JSONObject)
        }



    }
}