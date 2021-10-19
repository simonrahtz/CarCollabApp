package com.test.sharecar.activities

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.test.sharecar.activities.user.SignUpActivity
import com.test.sharecar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = binding.username
        val logIn = binding.loginButton

        //disable log in button unless input exists
        logIn.isEnabled = false

        //enables log in button if log in is not empty
        userName.doAfterTextChanged {
            logIn.isEnabled = userName.text.isNotEmpty() }


        logIn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))

        }





    }
}


