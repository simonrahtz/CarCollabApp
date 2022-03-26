package com.test.sharecar.presentation.activities.car

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.DataCache
import com.test.sharecar.presentation.activities.BrowserActivity
import com.test.sharecar.databinding.ActivityCarConfirmationBinding

class CarConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val car = DataCache.currentCar[0]


        with(binding){
            regNo.text = car?.regNo
            make.text = car?.make
            model.text = car?.model
            regDueDate.text = car?.getNextRegDueDate().toString()
        }

        binding.addCar.setOnClickListener {

            startActivity(Intent(this, BrowserActivity::class.java))
        }

    }

}