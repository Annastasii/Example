package com.example.feature_profile.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_profile.R

@Composable
fun PhoneNumberGroup(
    phone: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.phone_number),
                color = CustomColor.Grey,
                style = FontStyle.regular_12
            )
            Spacer(modifier = Modifier.height(Padding._4))
            TextField(
                readOnly = true,
                value = phone,
                onValueChange = {},
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
                placeholder = {
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            text = stringResource(id = R.string.phone_number),
                            style = FontStyle.regular_14,
                            color = CustomColor.Grey
                        )
                    }
                },
            )
        }
    }
}