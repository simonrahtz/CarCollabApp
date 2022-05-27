package com.test.sharecar.components

import android.widget.ImageButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CloseIcon(onIconClick: () -> Unit,color: Color) {

    IconButton(onClick = onIconClick) {
        Icon(imageVector = Icons.Default.Close, contentDescription = "cancel_icon", tint = color)
    }
}