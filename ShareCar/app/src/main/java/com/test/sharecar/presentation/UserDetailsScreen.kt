package com.test.sharecar.presentation

import android.view.Surface
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import java.lang.reflect.Modifier

@Composable
fun UserDetailsScreen(userDetailsViewModel: UserDetailsViewModel = viewModel()) {
    Scaffold {
        val text = userDetailsViewModel.getName()
        Text(text = text,style = TextStyle(
            fontSize =MaterialTheme.typography.h2.fontSize
        ))
    }

}

@Preview
@Composable
fun UserDetailsScreenPreview() {
    MaterialTheme {
        UserDetailsScreen()        
    }
}



