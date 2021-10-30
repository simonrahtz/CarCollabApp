package com.test.sharecar.activities.car

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.sharecar.databinding.ActivityEnterCarBinding

/**
 * Handles UI to add a car
 */
class EnterCarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnterCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(EnterCarViewModel::class.java)

        binding.btnAdd.setOnClickListener {

            viewModel.createCar(
                binding.etRegNo.text.toString(),
                binding.etMake.text.toString(),
                binding.etModel.text.toString(),
                binding.etRegDueDate.text.toString()
            )

            startActivity(Intent(this, CarConfirmationActivity::class.java))
        }
    }

}