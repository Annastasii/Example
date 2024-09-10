package com.example.feature_auth.ui.pin_code.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding

@Composable
fun CharView(
    index: Int,
    text: String,
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }
    Box(
        modifier = Modifier
            .width(Padding._44)
            .background(CustomColor.InputTextColor, RoundedCornerShape(8.dp))
            .height(Padding._48)
            .border(
                width = Padding._1,
                color = when {
                    isFocused -> CustomColor.InputTextColor
                    else -> CustomColor.InputTextColor
                },
                shape = RoundedCornerShape(Padding._8)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .padding(Padding._12),
            text = char,
            style = FontStyle.regular_16,
            color = CustomColor.TextColor,
            textAlign = TextAlign.Center,
        )
    }
}