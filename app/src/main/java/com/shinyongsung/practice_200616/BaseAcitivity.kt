package com.shinyongsung.practice_200616

import androidx.appcompat.app.AppCompatActivity

abstract class BaseAcitivity : AppCompatActivity() {

    val mContext = this

    abstract fun setupEvents()
    abstract fun setupvalues()

}