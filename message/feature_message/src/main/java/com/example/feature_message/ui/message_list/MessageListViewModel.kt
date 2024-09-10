package com.example.feature_message.ui.message_list

import androidx.lifecycle.ViewModel
import com.example.feature_message.ui.message_list.models.DialogModel
import com.example.feature_message.ui.message_list.models.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessageListViewModel @Inject constructor() : ViewModel() {
    val dialogList = listOf(
        DialogModel(
            id = 1,
            userName = "Иван Петров",
            messageList = listOf(
                MessageModel(
                    id = 1,
                    date = "10.08.2024 10:46",
                    userId = 1,
                    dialogId = 1,
                    message = "Hello. My name is Sandra. What’s your name?"
                ),
                MessageModel(
                    id = 2,
                    date = "10.08.2024 10:47",
                    userId = 3,
                    dialogId = 1,
                    message = "Hello. My name is Sandra. What’s your name?"
                ),
                MessageModel(
                    id = 3,
                    date = "10.08.2024 10:49",
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
                    date = "10.07.2024 10:46",
                    userId = 2,
                    dialogId = 2,
                    message = "Hello. My name is Sandra. What’s your name?"
                ),
                MessageModel(
                    id = 4,
                    date = "10.07.2024 10:47",
                    userId = 3,
                    dialogId = 2,
                    message = "Hello. My name is Sandra. What’s your name?"
                ),
                MessageModel(
                    id = 6,
                    date = "10.07.2024 10:49",
                    userId = 2,
                    dialogId = 2,
                    message = "Glad to see you too, Jack. Are you alone at this party?"
                )
            )
        )
    )
}