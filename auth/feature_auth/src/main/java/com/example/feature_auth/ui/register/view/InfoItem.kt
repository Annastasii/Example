package com.example.feature_auth.ui.register.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding

@Composable
internal fun InfoItem(
    value: String,
    placeholder: Int,
    onChange: (String) -> Unit,
    readOnly: Boolean = false,
    isError: Boolean = false,
) {
    TextField(
        value = value,
        onValueChange = { onChange(it) },
        modifier = Modifier
            .background(CustomColor.SecondaryBgColor)
            .clip(RoundedCornerShape(10.dp))
            .height(Padding._48)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = CustomColor.InputTextColor,
            unfocusedContainerColor = CustomColor.InputTextColor,
            focusedTextColor = CustomColor.TextColor,
            unfocusedTextColor = CustomColor.TextColor,
            errorContainerColor = CustomColor.InputTextColor,
            errorTextColor = CustomColor.TextColor
        ),
        placeholder = {
            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = placeholder),
                    style = FontStyle.regular_14,
                    color = CustomColor.Grey
                )
            }
        },
        readOnly = readOnly,
        isError = isError
    )
}