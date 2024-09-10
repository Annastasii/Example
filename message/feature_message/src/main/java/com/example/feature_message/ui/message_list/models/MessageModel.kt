package com.example.feature_message.ui.message_list.models

data class MessageModel(
    val id: Int,
    val date: String,
    val dialogId: Int,
    val userId: Int,
    val message: String,
)