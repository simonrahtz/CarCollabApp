package com.test.sharecar.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LightGreyDivider(padding: Int) {
    Divider(
        modifier = Modifier.padding(vertical = padding.dp),
        color = Color.LightGray
    )
}