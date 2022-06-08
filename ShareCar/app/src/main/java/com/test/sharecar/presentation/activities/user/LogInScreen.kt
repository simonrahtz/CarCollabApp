package com.test.sharecar.presentation.activities.user

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.sharecar.R
import com.test.sharecar.UserState
import com.test.sharecar.data.DataCache
import com.test.sharecar.data.User
import com.test.sharecar.presentation.activities.BrowserActivity
import com.test.sharecar.presentation.activities.LogInViewModel
import com.test.sharecar.presentation.bottomnavigation.BrowserComposeActivity
import com.test.sharecar.ui.theme.Purple700
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {

    val context = LocalContext.current
    val viewModel = LogInViewModel(context.applicationContext as Application)
    val userList by viewModel.allUsers.observeAsState(listOf())
    var userName by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val vm = UserState.current



    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (vm.isBusy) {
            CircularProgressIndicator()
        } else {
            val password = remember { mutableStateOf(TextFieldValue()) }

            Image(
                painter = painterResource(id = R.drawable.car_collab_banner),
                contentDescription = "location",
                modifier = Modifier.padding(top = 20.dp)

            )

            Spacer(modifier = Modifier.height(100.dp))


            Text(text = "Login", style = TextStyle(fontSize = 40.sp))

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = userName,
                onValueChange = { userName = it })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Password") },
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {
                        if (viewModel.searchForUser(userName, userList)) {
                            coroutineScope.launch {
                                vm.signIn()
                            }
                        } else Toast.makeText(context, "User doesn't exist", Toast.LENGTH_LONG)
                            .show()
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Login")
                }

            }

            ClickableText(
                text = AnnotatedString("Sign up here"),
                modifier = Modifier
                    .padding(20.dp),
                onClick = {
                    context.startActivity(Intent(context, SignUpActivity::class.java))
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                    color = Purple700
                )
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogIn() {
    LoginScreen()
}