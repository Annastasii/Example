package com.example.feature_message.ui.message_list.models

data class DialogModel (
    val id: Int,
    val userName: String,
    val messageList: List<MessageModel>,
)