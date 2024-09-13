package com.example.feature_profile.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_profile.R

@Composable
fun AboutMeGroup(about: String, onChange: (String) -> Unit) {
    Text(
        text = stringResource(id = R.string.about),
        color = CustomColor.Grey,
        style = FontStyle.regular_12
    )
    Spacer(modifier = Modifier.height(Padding._4))
    TextField(
        value = about,
        onValueChange = { onChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        modifier = Modifier
            .background(CustomColor.SecondaryBgColor)
            .clip(RoundedCornerShape(10.dp))
            .height(Padding._48)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = CustomColor.InputTextColor,
            unfocusedContainerColor = CustomColor.InputTextColor,
            focusedTextColor = CustomColor.TextColor,
            unfocusedTextColor = CustomColor.TextColor
        ),
        trailingIcon = {
            if (about.isNotBlank()) {
                Icon(
                    painter = painterResource(id = R.drawable.union),
                    contentDescription = null,
                    tint = CustomColor.GreyLight,
                    modifier = Modifier.clickable { onChange("") }
                )
            }
        },
        placeholder = {
            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.about),
                    style = FontStyle.regular_14,
                    color = CustomColor.Grey
                )
            }
        },
    )
}