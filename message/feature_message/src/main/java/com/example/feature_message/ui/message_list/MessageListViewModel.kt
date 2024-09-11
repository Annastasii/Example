package com.example.feature_message.ui.message_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.util.Assertions
import com.example.feature_message.ui.message_list.models.DialogModel
import com.example.feature_message.ui.message_list.models.MessageModel
import com.example.feature_message.ui.message_list.models.ScreenState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MessageListViewModel @Inject constructor(

) : ViewModel() {
    val dialogList = listOf(
        DialogModel(
            id = 1,
            userName = "Иван Петров",
            messageList = listOf(
                MessageModel(
                    id = 1,
                    date = Date(1723282941),
                    userId = 1,
                    dialogId = 1,
                    message = "Hello. My name is Sandra. What’s your name?"
                ),
                MessageModel(
                    id = 2,
                    date = Date(1723283181),
                    userId = 3,
                    dialogId = 1,
                    message = "Hello. My name is Sandra. What’s your name?"
                ),
                MessageModel(
                    id = 3,
                    date = Date(1723283121),
                    userId = 1,
                    dialogId = 1,
                    message = "Glad to see you too, Jack. Are you alone at this party?"
                )
            )
        ),
        DialogModel(
            id = 2,
            userName = "Петр Сидоров",
            messageList = listOf(
                MessageModel(
                    id = 4,
                    date = Date(1723023921),
                    userId = 2,
                    dialogId = 2,
                    message = "Oh, my god! It’s like a nightmare! The final exams are coming, and I still have not chosen the place to enter."
                ),
                MessageModel(
                    id = 4,
                    date = Date(1723024221),
                    userId = 3,
                    dialogId = 2,
                    message = "Stop to panic. Let's try to determine which profession suits you most of all."
                ),
                MessageModel(
                    id = 6,
                    date = Date(1723024281),
                    userId = 2,
                    dialogId = 2,
                    message = "But how can we do it?"
                )
            ).sortedBy { message -> message.date }
        )
    )

    val sortedDialog =
        dialogList.sortedBy { it.messageList.maxByOrNull { message -> message.date }!!.date }

    val screenState: StateFlow<ScreenState> get() = _screenState.asStateFlow()
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState())

    fun refresh() {
        viewModelScope.launch {
            _screenState.update { it.copy(isRefresh = true) }
            delay(3000)
            _screenState.update { it.copy(isRefresh = false) }

        }
    }
}