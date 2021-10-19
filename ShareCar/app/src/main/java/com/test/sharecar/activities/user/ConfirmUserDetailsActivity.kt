package com.test.sharecar.activities.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.R
import com.test.sharecar.activities.BrowserActivity
import com.test.sharecar.databinding.ActivityConfirmUserDetailsBinding
import com.test.sharecar.models.Person

class ConfirmUserDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>("user")

        with(binding){
            name.text = person?.name
            address.text = person?.address
            email.text = person?.email
            phone.text = person?.phone}


        binding.confirmDetails.setOnClickListener {

        startActivity(Intent(this, BrowserActivity::class.java))
        }


    }


}