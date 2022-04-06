package com.test.sharecar.presentation.activities

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.test.sharecar.presentation.activities.user.SignUpActivity
import com.test.sharecar.databinding.ActivityMainBinding
/**
 * Simple log in screen. No user authentication is being done at this point.
 * It is purely for demonstration.
 */

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this,ActivityLogIn::class.java))


    }
}


