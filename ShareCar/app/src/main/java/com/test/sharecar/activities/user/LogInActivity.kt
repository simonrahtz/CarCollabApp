package com.test.sharecar.activities.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.R
import com.test.sharecar.databinding.ActivityLogInBinding
import com.test.sharecar.databinding.ActivityMainBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}