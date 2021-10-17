package com.test.sharecar.activities.car

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.databinding.ActivityEnterCarBinding

class EnterCarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnterCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, CarConfirmationActivity::class.java))
        }
    }

}