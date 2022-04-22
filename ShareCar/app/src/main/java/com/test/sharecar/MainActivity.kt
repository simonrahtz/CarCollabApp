package com.test.sharecar

import android.content.ContentProvider
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.R
import com.test.sharecar.presentation.FuelPriceScreen
import com.test.sharecar.presentation.UserDetailsScreen
import com.test.sharecar.presentation.activities.LogInActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //startActivity(Intent(this, LogInActivity::class.java))
        setContent { MaterialTheme{
            UserDetailsScreen()
        } }

    }
}




