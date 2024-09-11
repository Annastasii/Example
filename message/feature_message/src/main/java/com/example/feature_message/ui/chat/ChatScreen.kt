package com.example.feature_message.ui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_message.R
import com.example.feature_message.ui.chat.view.BottomBar
import com.example.feature_message.ui.chat.view.MessageItem

@Composable
fun ChatScreen(navController: NavController, viewModel: ChatViewModel = hiltViewModel()) {
    val name = viewModel.name.collectAsState().value
    val messageList = viewModel.messageList.collectAsState().value
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = CustomColor.BarColor)
                    .padding(Padding._12),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = null,
                    tint = CustomColor.TextColor,
                    modifier = Modifier.clickable { navController.navigateUp() }
                )
                Spacer(modifier = Modifier.width(Padding._12))
                Text(
                    text = name,
                    color = CustomColor.TextColor,
                    style = FontStyle.medium_16,
                )
            }
        },
        bottomBar = {
            BottomBar(
                viewModel.messageValue.collectAsState().value,
                onChangeValue = viewModel::onChangeValue
            )
        }
    ) { innerPadding ->
        LazyColumn(
            reverseLayout = true,
            contentPadding = innerPadding,
            modifier = Modifier
                .background(CustomColor.PrimaryBgColor)
                .fillMaxSize()
        ) {
            messageList.forEach {
                item {
                    MessageItem(messageModel = it)
                }
            }
        }
    }
}