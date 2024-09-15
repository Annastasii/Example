package com.example.feature_profile.ui

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.core_ui.view.bottom_app_bar.BottomAppBar
import com.example.feature_profile.R
import com.example.feature_profile.ui.view.AboutMeGroup
import com.example.feature_profile.ui.view.BirthdayGroup
import com.example.feature_profile.ui.view.CityGroup
import com.example.feature_profile.ui.view.MainInfoGroup
import com.example.feature_profile.ui.view.PhoneNumberGroup

@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel = hiltViewModel()) {
    val profile = viewModel.profileModel.collectAsState().value
    Scaffold(bottomBar = { BottomAppBar(navController) }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(CustomColor.PrimaryBgColor)
                .padding(innerPadding)
        ) {
            profile?.let {
                MainInfoGroup(profile = profile)
                Spacer(modifier = Modifier.height(Padding._16))
                Box(
                    Modifier
                        .padding(Padding._12)
                        .background(CustomColor.SecondaryBgColor, RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                ) {
                    Column(
                        Modifier
                            .padding(Padding._16)
                            .fillMaxWidth()
                    ) {
                        PhoneNumberGroup(phone = "7868665")
                        Spacer(modifier = Modifier.height(Padding._12))
                        BirthdayGroup(
                            date = profile.birthday ?: ""
                        ) { viewModel.onChangeBirthday(it) }
                        Spacer(modifier = Modifier.height(Padding._12))
                        CityGroup(city = profile.city ?: "") { viewModel.onChangeCity(it) }
                        Spacer(modifier = Modifier.height(Padding._12))
                        AboutMeGroup(about = profile.instagram ?: "") { viewModel.onChangeAbout(it) }
                        Spacer(modifier = Modifier.height(Padding._12))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Button(
                                enabled = viewModel.isEdit.collectAsState().value,
                                onClick = { },
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
                                    text = stringResource(R.string.save),
                                    style = FontStyle.regular_14
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}