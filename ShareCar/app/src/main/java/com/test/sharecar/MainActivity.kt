package com.test.sharecar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.appcompat.app.AppCompatActivity
import com.test.sharecar.presentation.EnterTripDetails
import com.test.sharecar.presentation.activities.LogInActivity
import com.test.sharecar.ui.theme.ShareCarTheme


class MainActivity : ComponentActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContent(){
                ShareCarTheme {
                    Navigation()
                }
            }

        //startActivity(Intent(this, LogInActivity::class.java))

    }


}


