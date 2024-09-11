package com.example.feature_message.ui.message_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import com.example.core_ui.view.bottom_app_bar.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core_navigation.route.ChatDestination
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.Padding
import com.example.feature_message.R
import com.example.feature_message.ui.message_list.view.Item
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun DialogListScreen(
    navController: NavController,
    viewModel: DialogListViewModel = hiltViewModel(),
) {
    val state = viewModel.screenState.collectAsState().value
    val refreshState = rememberSwipeRefreshState(state.isRefresh)
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = CustomColor.BarColor)
            ) {
                Text(
                    text = "Сообщения",
                    color = CustomColor.TextColor,
                    style = FontStyle.medium_16,
                    modifier = Modifier
                        .padding(Padding._16)
                )
            }
        },
        bottomBar = {
            BottomAppBar(navController)
        }
    ) { innerPadding ->
        if (viewModel.sortedDialog.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(id = R.string.empty),
                    color = CustomColor.TextColor,
                    style = FontStyle.medium_16
                )
            }
        } else {
            SwipeRefresh(
                state = refreshState,
                onRefresh = { viewModel.refresh() },
                Modifier.padding(innerPadding)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(CustomColor.PrimaryBgColor)
                ) {
                    viewModel.sortedDialog.forEach {
                        item {
                            Column(
                                modifier = Modifier
                                    .background(CustomColor.SecondaryBgColor)
                                    .clickable {
                                        navController.navigate(
                                            ChatDestination.createRoute(
                                                it.id
                                            )
                                        )
                                    }) {
                                Item(dialogModel = it)
                                Divider(color = CustomColor.PrimaryBgColor)
                            }
                        }
                    }
                }
            }
        }
    }
}