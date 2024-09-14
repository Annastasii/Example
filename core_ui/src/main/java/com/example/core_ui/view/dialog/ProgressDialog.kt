package com.example.core_ui.view.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.core_ui.CustomColor

@Composable
fun ProgressDialog() =
    Dialog(
        onDismissRequest = {
            // ignore
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Box(
            contentAlignment = Center,
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = CustomColor.SecondaryBgColor,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            CircularProgressIndicator()
        }
    }

@Preview(locale = "ru")
@Composable
private fun ProgressIndicatorPreview() {
    ProgressDialog()
}
