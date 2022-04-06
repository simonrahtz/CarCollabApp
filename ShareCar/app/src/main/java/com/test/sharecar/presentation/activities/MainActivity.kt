package com.test.sharecar.presentation.activities

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

/**
 * Simple log in screen. No user authentication is being done at this point.
 * It is purely for demonstration.
 */

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this,LogInActivity::class.java))


    }
}


