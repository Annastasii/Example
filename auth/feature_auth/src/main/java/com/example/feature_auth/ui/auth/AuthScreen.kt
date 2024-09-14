package com.example.feature_auth.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core_navigation.route.PinCodeDestination
import com.example.core_navigation.route.RegisterDestination
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.core_ui.view.dialog.ProgressDialog
import com.example.feature_auth.R
import com.example.feature_auth.domain.Constants
import com.example.feature_auth.ui.auth.model.NavScreen
import com.example.feature_auth.ui.auth.view.PhoneNumberGroup

@Composable
fun AuthScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
    val phone = viewModel.phoneNumber.collectAsState().value
    val screenState = viewModel.screenState.collectAsState().value
    val code = viewModel.code.collectAsState().value
    if (screenState.isProgress) {
        ProgressDialog()
    }
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
                text = stringResource(id = R.string.auth_title),
                color = CustomColor.TextColor,
                style = FontStyle.medium_24
            )
            Spacer(modifier = Modifier.height(Padding._38))
            PhoneNumberGroup(
                phoneNumber = phone,
                screenState = screenState,
                code = code,
                onButtonClick = {
                    navController.navigate(PinCodeDestination.createRoute(code + phone))
                    viewModel.authorization(code + phone)
                },
                onChangePhone = viewModel::onChangeNumber,
                onChangeCode = viewModel::onChangeCode,
                onChangeFlag = viewModel::onChangeFlag
            )
            Spacer(modifier = Modifier.height(Padding._16))
            val enable = phone.length == Constants.PHONE_COUNT && code.isNotBlank()
            Text(
                text = stringResource(id = R.string.sign_in),
                color = if (enable) CustomColor.LinkColor else CustomColor.Grey,
                style = FontStyle.regular_16,
                modifier = Modifier.clickable {
                    viewModel.authorization(code + phone)
                    navController.navigate(RegisterDestination.createRoute(code + phone))
                }
            )
        }
    }
}