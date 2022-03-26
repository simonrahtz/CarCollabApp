package com.test.sharecar.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.test.sharecar.R
import com.test.sharecar.databinding.ActivityBrowseBinding

/**
 * Activity container for browse, car and user fragments with bottom screen navigation
 */
class BrowserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityBrowseBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEvent()

    }

    override fun onResume() {
        super.onResume()
        navController = Navigation.findNavController(binding.fragmentContainerView)
    }

    private fun initEvent() {
        binding.ivBrowser.setOnClickListener(this)
        binding.ivCars.setOnClickListener(this)
        binding.ivUser.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.ivBrowser -> {
                navController.navigate(R.id.browseFragment)
            }
            binding.ivCars -> {
                navController.navigate(R.id.carsFragment)
            }
            binding.ivUser -> {
                navController.navigate(R.id.userFragment)
            }
        }
    }


}