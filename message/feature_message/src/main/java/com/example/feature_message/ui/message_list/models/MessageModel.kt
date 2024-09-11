package com.example.feature_message.ui.message_list.models

import java.util.Date


data class MessageModel(
    val id: Int,
    val date: Date,
    val dialogId: Int,
    val userId: Int,
    val message: String,
)