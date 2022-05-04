package com.test.sharecar

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.test.sharecar.presentation.activities.LogInActivity


class MainActivity() : AppCompatActivity(){


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, LogInActivity::class.java))

    }


}


