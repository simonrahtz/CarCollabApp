package com.test.sharecar.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BoldText(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
}