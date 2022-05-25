package com.test.sharecar.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit,
    onClickCancel: () -> Unit

) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textState,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = onClickCancel) {
                Icon(imageVector = Icons.Default.Cancel, contentDescription = "cancel")
            }
        },
        label = { Text(title) },
        textStyle = TextStyle(
            fontSize = 15.sp
        )
    )

}