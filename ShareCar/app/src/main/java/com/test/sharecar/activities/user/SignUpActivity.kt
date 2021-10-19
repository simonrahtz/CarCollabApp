package com.test.sharecar.activities.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.sharecar.activities.LogInViewModel
import com.test.sharecar.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(LogInViewModel::class.java)

        binding.createUserButton.setOnClickListener()
        {
            viewModel.createPerson(
                binding.name.text.toString(),
                binding.enterEmail.text.toString(),
                binding.enterPhone.text.toString(),
                binding.enterAddress.text.toString())

            startActivity(Intent(this, ConfirmUserDetailsActivity::class.java))
            finish()

        }
    }
}