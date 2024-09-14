package com.example.pet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_auth_api.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

}
