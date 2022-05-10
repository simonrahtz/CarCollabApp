package com.test.sharecar.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TitleText(text: String, padding: Int, color: Color) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(padding.dp),
        color = color
    )

}