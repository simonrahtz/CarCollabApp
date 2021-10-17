package com.test.sharecar.activities.car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.databinding.ActivityCarConfirmationBinding

class CarConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}