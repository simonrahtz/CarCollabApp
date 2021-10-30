package com.test.sharecar.activities.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.activities.car.EnterCarActivity
import com.test.sharecar.databinding.ActivityUserCarsBinding

/**
 * Display cars that belong to user. This version of the project will only use one registered car
 */
class UserCarsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserCarsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, EnterCarActivity::class.java))
        }
    }

}