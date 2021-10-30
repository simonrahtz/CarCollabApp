package com.test.sharecar.activities.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.sharecar.DataCache
import com.test.sharecar.R
import com.test.sharecar.activities.BrowserActivity
import com.test.sharecar.databinding.ActivityConfirmUserDetailsBinding
import com.test.sharecar.models.Person
/**
 * Class that handles displaying details back to the user for confirmation
 */
class ConfirmUserDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get current user
        val person = DataCache.currentUser[0]

        //Display current user to screen
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