package com.test.sharecar.presentation.activities.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.sharecar.databinding.ActivitySignUpBinding
import com.test.sharecar.navigation.BrowserComposeActivity
import com.test.sharecar.presentation.activities.BrowserActivity

/**
 * Handles user input to complete sign up
 */
class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        //create person object from user input
        binding.createUserButton.setOnClickListener()
        {
            viewModel.createPerson(
                binding.name.text.toString(),
                binding.enterEmail.text.toString(),
                binding.enterPhone.text.toString(),
                binding.enterAddress.text.toString())

            startActivity(Intent(this, BrowserComposeActivity::class.java))
            finish()

        }
    }
}