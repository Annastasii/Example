package com.example.feature_message.ui.chat

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.core_navigation.route.ChatDestination
import com.example.feature_message.domain.Constants
import com.example.feature_message.ui.message_list.models.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var id = savedStateHandle.get<Int>(ChatDestination.ID)!!
    val name = MutableStateFlow("")
    val messageList = MutableStateFlow<List<MessageModel>>(emptyList())
    val messageValue = MutableStateFlow<String>("")

    init {
        val sortedDialog = Constants.dialogList.first { it.id == id }
        messageList.value = sortedDialog.messageList.sortedBy { it.date }.reversed()
        name.value = sortedDialog.userName
    }

    fun onChangeValue(str: String) {
        messageValue.value = str
    }

}