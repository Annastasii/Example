package com.example.feature_message.ui.message_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_message.domain.Constants.dialogList
import com.example.feature_message.ui.message_list.models.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DialogListViewModel @Inject constructor(

) : ViewModel() {

    val sortedDialog =
        dialogList.sortedBy { it.messageList.minByOrNull { message -> message.date }!!.date }

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