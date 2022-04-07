package com.test.sharecar

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.test.sharecar.R


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //startActivity(Intent(this,LogInActivity::class.java))

        setContent {
            navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }




    }
}



