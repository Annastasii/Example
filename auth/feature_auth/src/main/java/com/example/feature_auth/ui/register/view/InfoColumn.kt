package com.example.feature_auth.ui.register.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_auth.R

@Composable
internal fun InfoColumn(
    phone: String,
    name: String,
    username: String,
    isError: Boolean,
    onChangeName: (String) -> Unit,
    onChangeUsername: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .background(CustomColor.SecondaryBgColor, RoundedCornerShape(10.dp))
            .padding(
                vertical = Padding._18,
                horizontal = Padding._12
            ),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(id = R.string.phone_number),
            color = CustomColor.TextColor,
            style = FontStyle.regular_14
        )
        Spacer(modifier = Modifier.height(Padding._8))
        InfoItem(
            value = phone,
            placeholder = R.string.empty,
            onChange = { /*ignore*/ },
            readOnly = true,
        )
        Spacer(modifier = Modifier.height(Padding._12))
        InfoItem(
            value = name,
            placeholder = R.string.name,
            onChange = onChangeName
        )
        Spacer(modifier = Modifier.height(Padding._12))
        InfoItem(
            value = username,
            placeholder = R.string.username,
            onChange = onChangeUsername,
            isError = isError
        )
    }
}

