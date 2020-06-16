package com.shinyongsung.practice_200616

import android.os.Bundle
import android.util.Log
import com.shinyongsung.practice_200616.util.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import kotlin.math.log

class LoginActivity : BaseAcitivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setupvalues()
    }

    override fun setupEvents() {

        loginBtn.setOnClickListener {
            val inputEmail = emailEdt.text.toString()
            val inputPw = pwEdt.text.toString()

            Log.d("화면에서 보는 11111111111111",toString())

            ServerUtil.postRequestLogin(mContext,inputEmail,inputPw,object : ServerUtil.Companion.JsonResponseHandler {
                override fun onResponse(json: JSONObject) {
                    Log.d("화면에서 보는 응답", json.toString())
                }
            }



            )
        }
    }

    override fun setupvalues() {

    }

}
