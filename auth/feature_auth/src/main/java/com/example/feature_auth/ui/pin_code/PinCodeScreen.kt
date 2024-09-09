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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_auth.ui.pin_code.view.PinCodeTextField

@Composable
fun PinCodeScreen(navController: NavController) {
////    val pin = viewModel.pin.collectAsState().value
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(CustomColor.PrimaryBgColor),
//    ) {
//        Column(modifier = Modifier.padding(Padding._16)) {
//            Text(
//                text = stringResource(id = R.string.send, viewModel.email),
//                color = CustomColor.TextColor,
//                style = FontStyle.Style_20
//            )
//            Spacer(modifier = Modifier.height(Padding._16))
//            Text(
//                text = stringResource(id = R.string.write_pin_code),
//                color = CustomColor.TextColor,
//                style = FontStyle.Style_14
//            )
//            Spacer(modifier = Modifier.height(Padding._16))
//            PinCodeTextField(pin, viewModel::enterPin)
//            Spacer(modifier = Modifier.height(Padding._16))
//            Button(
//                onClick = { navController.navigate(VacanciesListDestination.route()) },
//                enabled = pin.length == 4,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(Padding._48),
//                shape = RoundedCornerShape(10.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = CustomColor.ActiveButtonColor,
//                    disabledContainerColor = CustomColor.NotActiveButtonColor,
//                    contentColor = CustomColor.TextColor,
//                    disabledContentColor = CustomColor.NotActiveTextColor
//                )
//            ) {
//                Text(
//                    text = stringResource(R.string.confirm),
//                    fontSize = 14.sp
//                )
//            }
//        }
//    }
}