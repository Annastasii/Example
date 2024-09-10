package com.example.feature_auth.ui.auth.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_auth.R
import com.example.feature_auth.domain.Constants.PHONE_COUNT
import com.example.feature_auth.ui.auth.model.Flags
import com.example.feature_auth.ui.auth.model.ScreenState

@Composable
internal fun PhoneNumberGroup(
    screenState: ScreenState,
    phoneNumber: String,
    code: String,
    onButtonClick: () -> Unit,
    onChangePhone: (String) -> Unit,
    onChangeCode: (String) -> Unit,
    onChangeFlag: (Flags) -> Unit,
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
            text = stringResource(id = R.string.enter_phone_number),
            color = CustomColor.TextColor,
            style = FontStyle.regular_16
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            FlagsButton(
                code = code,
                onChangeCode = { onChangeCode(it) },
                onChangeFlag = { onChangeFlag(it) })
            Spacer(modifier = Modifier.width(Padding._12))
            PhoneField(phoneNumber) { onChangePhone(it) }
        }
        Spacer(modifier = Modifier.height(Padding._16))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                enabled = phoneNumber.length == PHONE_COUNT && code.isNotBlank(),
                onClick = { onButtonClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .weight(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = CustomColor.ActiveButtonColor,
                    disabledContainerColor = CustomColor.NotActiveButtonColor,
                    contentColor = CustomColor.TextColor,
                    disabledContentColor = CustomColor.NotActiveTextColor
                )
            ) {
                Text(
                    text = stringResource(R.string.resume),
                    style = FontStyle.regular_14
                )
            }
            Spacer(modifier = Modifier.width(Padding._16))
        }
    }
}
