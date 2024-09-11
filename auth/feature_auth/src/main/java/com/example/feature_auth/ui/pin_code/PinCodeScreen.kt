package com.example.feature_auth.ui.pin_code

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core_navigation.route.MessageListDestination
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_auth.R
import com.example.feature_auth.domain.Constants.CORRECT_PIN
import com.example.feature_auth.domain.Constants.PIN_COUNT
import com.example.feature_auth.ui.pin_code.view.PinCodeTextField

@Composable
fun PinCodeScreen(navController: NavController, viewModel: PinCodeViewModel = hiltViewModel()) {
    val pin = viewModel.pin.collectAsState().value
    val isPinCorrect = pin == CORRECT_PIN
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(CustomColor.PrimaryBgColor),
    ) {
        Column(modifier = Modifier.padding(Padding._16)) {
            Text(
                text = stringResource(id = R.string.send, viewModel.phone),
                color = CustomColor.TextColor,
                style = FontStyle.medium_16
            )
            Spacer(modifier = Modifier.height(Padding._16))
            Text(
                text = stringResource(id = R.string.write_pin_code),
                color = CustomColor.TextColor,
                style = FontStyle.regular_14
            )
            Spacer(modifier = Modifier.height(Padding._16))
            PinCodeTextField(pin, viewModel::enterPin)
            if (!isPinCorrect && pin.length == PIN_COUNT) {
                Spacer(modifier = Modifier.height(Padding._8))
                Text(
                    text = stringResource(id = R.string.incorrect_pin),
                    color = CustomColor.Cherry,
                    style = FontStyle.regular_12
                )
            }
            Spacer(modifier = Modifier.height(Padding._16))
            Button(
                onClick = { navController.navigate(MessageListDestination.route()) },
                enabled = isPinCorrect,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Padding._48),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = CustomColor.ActiveButtonColor,
                    disabledContainerColor = CustomColor.NotActiveButtonColor,
                    contentColor = CustomColor.TextColor,
                    disabledContentColor = CustomColor.NotActiveTextColor
                )
            ) {
                Text(
                    text = stringResource(R.string.confirm),
                    fontSize = 14.sp
                )
            }
        }
    }
}