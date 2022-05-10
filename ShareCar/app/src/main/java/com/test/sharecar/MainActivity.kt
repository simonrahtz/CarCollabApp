package com.test.sharecar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

import com.test.sharecar.presentation.activities.LogInActivity


class MainActivity : ComponentActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        startActivity(Intent(this, LogInActivity::class.java))

    }


}


