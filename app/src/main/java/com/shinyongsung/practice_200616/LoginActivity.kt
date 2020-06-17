package com.shinyongsung.practice_200616

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.shinyongsung.practice_200616.util.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseAcitivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setupvalues()
    }

    override fun setupEvents() {

        singUpBtn.setOnClickListener {
            val myIntent = Intent(mContext, SingUpActivity::class.java)
            startActivity(myIntent)
        }

        loginBtn.setOnClickListener {
            val inputEmail = emailEdt.text.toString()
            val inputPw = pwEdt.text.toString()


            ServerUtil.postRequestLogin(mContext, inputEmail, inputPw, object : ServerUtil.Companion.JsonResponseHandler {
                override fun onResponse(json: JSONObject) {
                    val codeNum = json.getInt("code")

                    if (codeNum == 200){

                        val data = json.getJSONObject("data")
                        val user = json.getJSONObject("user")
                        val loginUserEmail = user.getString("email")
//                        val message = json.getString("message")

                        runOnUiThread {
                            Toast.makeText(mContext,"${loginUserEmail}님 환영합니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else {
                        val message = json.getString("message")
                        runOnUiThread {
                            Toast.makeText(mContext, message,Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            })
        }
    }

    override fun setupvalues() {

    }

}
