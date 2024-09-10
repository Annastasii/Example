package com.example.pet

import androidx.lifecycle.ViewModel
import com.example.core_database.dao.MessageDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dao: MessageDao,
) : ViewModel() {

}