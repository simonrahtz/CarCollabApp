package com.test.sharecar.presentation.activities.user

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.sharecar.components.DefaultButton
import com.test.sharecar.components.TitleText

@Composable
fun SignUpScreen() {

    val context = LocalContext.current.applicationContext
    val viewModel = SignUpViewModel(context as Application)
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        TitleText(
            text = "Sign Up",
            padding = 10,
            color = Color.Black
        )
        Spacer(modifier = Modifier.padding(10.dp))
        SignUpField(title = "name", text = name, onTextChange = { name = it })
        SignUpField(title = "email", text = email, onTextChange = { email = it })
        SignUpField(title = "phone number", text = phoneNumber, onTextChange = { phoneNumber = it })
        SignUpField(title = "address", text = address, onTextChange = { address = it })
        DefaultButton(text = "Sign Up", onClick = {
            viewModel.createPerson(name,email,phoneNumber,address)
        })


    }

}

@Composable
fun SignUpField(title: String, text: String, onTextChange: (String) -> Unit) {
    Text(text = title)
    OutlinedTextField(value = text, onValueChange = onTextChange)
    Spacer(modifier = Modifier.padding(10.dp))
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}