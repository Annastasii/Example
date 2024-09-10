package com.example.feature_auth.ui.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core_navigation.route.PinCodeDestination
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_auth.R
import com.example.feature_auth.ui.register.view.InfoColumn
import java.util.regex.Matcher
import java.util.regex.Pattern

@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel = hiltViewModel()) {
    val name = viewModel.name.collectAsState().value
    val username = viewModel.username.collectAsState().value
    val screenState = viewModel.screenState.collectAsState().value
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(CustomColor.PrimaryBgColor)
            .padding(horizontal = Padding._16)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.register),
                color = CustomColor.TextColor,
                style = FontStyle.medium_24
            )
            Spacer(modifier = Modifier.height(Padding._38))
            InfoColumn(
                phone = viewModel.phone,
                name = name,
                username = username,
                isError = screenState.showMessage,
                onChangeName = viewModel::onChangeName,
                onChangeUsername = viewModel::onChangeUsername
            )
            if (screenState.showMessage) {
                Spacer(modifier = Modifier.height(Padding._8))
                Text(
                    text = stringResource(id = R.string.usernameMessage),
                    color = CustomColor.TextColor,
                    style = FontStyle.regular_14
                )
            }
            Spacer(modifier = Modifier.height(Padding._38))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    enabled = name.isNotBlank() && username.isNotBlank(),
                    onClick = {
                        if (usernameValidator(username)) navController.navigate(
                            PinCodeDestination.createRoute(viewModel.phone)
                        ) else {
                            viewModel.showMessage(true)
                        }
                    },
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
                        text = stringResource(R.string.registration),
                        style = FontStyle.regular_14
                    )
                }
            }
        }
    }
}

fun usernameValidator(username: String): Boolean {
    val pattern: Pattern
    val EMAIL_PATTERN =
        "^[_A-Za-z0-9-_]+$"
    pattern = Pattern.compile(EMAIL_PATTERN)
    val matcher: Matcher = pattern.matcher(username)
    return matcher.matches()
}
