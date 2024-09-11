package com.example.feature_message.ui.chat.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_message.R

@Composable
internal fun BottomBar(value: String, onChangeValue: (String) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(color = CustomColor.BarColor)
            .padding(Padding._12),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = value,
            onValueChange = { onChangeValue(it) },
            modifier = Modifier
                .background(CustomColor.SecondaryBgColor)
                .clip(RoundedCornerShape(10.dp))
                .height(Padding._48),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = CustomColor.InputTextColor,
                unfocusedContainerColor = CustomColor.InputTextColor,
                focusedTextColor = CustomColor.TextColor,
                unfocusedTextColor = CustomColor.TextColor
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.enter_text),
                    style = FontStyle.regular_14,
                    color = CustomColor.Grey
                )
            }
        )
        Image(
            painter = painterResource(id = R.drawable.ic_send),
            contentDescription = null,
            modifier = Modifier.clickable { onChangeValue("") }.size(Padding._38))
    }
}