package com.test.sharecar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    private lateinit var binding: Activity3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnConfirm.setOnClickListener {
            startActivity(Intent(this, Activity4::class.java))
        }
    }

}