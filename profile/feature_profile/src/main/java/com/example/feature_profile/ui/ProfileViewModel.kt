package com.example.feature_profile.ui

import androidx.lifecycle.ViewModel
import com.example.feature_profile.ui.models.FileModel
import com.example.feature_profile.ui.models.ProfileModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {
    val model = MutableStateFlow(
        ProfileModel(
            name = "Петр Афанасьев",
            username = "rus_af",
            birthday = "2024-10-12",
            city = "Moscow",
            aboutMe = "Инфо",
            avatar = FileModel(
                filename = "",
                base64 = ""
            )
        )
    )

    val isEdit = MutableStateFlow(false)

    fun onChangeBirthday(value: String) {
        model.update { it.copy(birthday = value) }
    }

    fun onChangeCity(value: String) {
        model.update { it.copy(city = value) }
    }

    fun onChangeAbout(value: String) {
        model.update { it.copy(aboutMe = value) }
    }

}