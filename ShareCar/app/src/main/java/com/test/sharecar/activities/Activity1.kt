package com.test.sharecar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.databinding.Activity1Binding

class Activity1 : AppCompatActivity() {

    private lateinit var binding: Activity1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }
    }

}