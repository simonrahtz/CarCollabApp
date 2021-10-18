package com.test.sharecar.activities.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.test.sharecar.R
import com.test.sharecar.databinding.ActivityLogInBinding
import com.test.sharecar.databinding.ActivityMainBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.name
        val email = binding.enterEmail
        val address = binding.enterAddress
        val phone = binding.enterPhone

        var viewModel = ViewModelProvider(this).get(LoginActivityViewModel::class.java)

        binding.createUserButton.setOnClickListener()
        {
            val person = viewModel.createPerson(
                name.text.toString(),
                email.text.toString(),
                phone.text.toString(),
                address.text.toString())

        }
    }
}