package com.example.feature_message.domain

import com.example.feature_message.ui.message_list.models.DialogModel
import com.example.feature_message.ui.message_list.models.MessageModel

object Constants {

    val dialogList = listOf(
        DialogModel(
            id = 1,
            userName = "Иван Петров",
            messageList = listOf(
                MessageModel(
                    id = 1,
                    date = stringToDate("11.07.2024 12:45"),
                    userId = 1,
                    dialogId = 1,
                    message = "Hello. My name is Sandra. What’s your name?"
                ),
                MessageModel(
                    id = 2,
                    date = stringToDate("11.07.2024 12:47"),
                    userId = 3,
                    dialogId = 1,
                    message = "Hello. My name is Jack. What’s your name?"
                ),
                MessageModel(
                    id = 3,
                    date = stringToDate("11.07.2024 12:48"),
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
                    date = stringToDate("12.07.2024 10:45"),
                    userId = 2,
                    dialogId = 2,
                    message = "Oh, my god! It’s like a nightmare! The final exams are coming, and I still have not chosen the place to enter."
                ),
                MessageModel(
                    id = 4,
                    date = stringToDate("12.07.2024 10:50"),
                    userId = 3,
                    dialogId = 2,
                    message = "Stop to panic. Let's try to determine which profession suits you most of all."
                ),
                MessageModel(
                    id = 6,
                    date = stringToDate("12.07.2024 11:34"),
                    userId = 2,
                    dialogId = 2,
                    message = "But how can we do it?"
                )
            )
        )
    )

    const val ACTIVE_USER = 3
}