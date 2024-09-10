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
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_auth.R
import com.example.feature_auth.ui.auth.view.PhoneNumberGroup

//import com.example.core_navigation.routes.PinCodeDestination
//import com.example.core_ui.Padding
//import com.example.core_ui.view.bottom_app_bar.BottomAppBar
//import com.example.feauture_auth.R
//import com.example.feauture_auth.view.first_auth.ui.first_auth.view.FindEmployeeColumn
//import com.example.feauture_auth.view.first_auth.ui.first_auth.view.FindWorkColumn

@Composable
fun AuthScreen(navController: NavController, viewModel: AuthScreenViewModel = hiltViewModel()) {
    val phone = viewModel.phoneNumber.collectAsState().value
    val screenState = viewModel.screenState.collectAsState().value
    val code = viewModel.code.collectAsState().value
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
                onButtonClick = { navController.navigate(PinCodeDestination.createRoute(phone)) },
                onChangePhone = viewModel::onChangeNumber,
                onChangeCode = viewModel::onChangeCode,
                onChangeFlag = viewModel::onChangeFlag
            )
            Spacer(modifier = Modifier.height(Padding._16))
            Text(
                text = stringResource(id = R.string.sign_in),
                color = CustomColor.LinkColor,
                style = FontStyle.regular_16,
                modifier = Modifier.clickable {
                    navController.navigate(
                        PinCodeDestination.createRoute(phone)
                    )
                }
            )
        }
    }
}