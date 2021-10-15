package com.test.sharecar.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.databinding.Activity4Binding

class Activity4 : AppCompatActivity() {

    private lateinit var binding: Activity4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}