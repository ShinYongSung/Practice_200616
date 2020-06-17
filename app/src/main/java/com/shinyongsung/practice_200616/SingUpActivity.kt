package com.shinyongsung.practice_200616

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sing_up.*

class SingUpActivity : BaseAcitivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        setupEvents()
        setupvalues()
    }

    override fun setupEvents() {
        emailCheckBtn.setOnClickListener {
            val inputemail = emailEdt.text.toString()

        }

    }

    override fun setupvalues() {

    }


}
