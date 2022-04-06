package com.test.sharecar.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.test.sharecar.R
import com.test.sharecar.databinding.ActivityLogInBinding
import com.test.sharecar.databinding.ActivityMainBinding
import com.test.sharecar.presentation.activities.user.SignUpActivity

class ActivityLogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogInBinding.inflate(layoutInflater)
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
            finish()

        }



    }


}