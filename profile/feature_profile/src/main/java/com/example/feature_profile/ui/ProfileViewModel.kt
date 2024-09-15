package com.example.feature_profile.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_database.dao.ProfileDao
import com.example.core_network.api.ProfileApi
import com.example.core_network.dto.dtoe.RegisterDTOE
import com.example.feature_profile.domain.Mapper.mapToEntity
import com.example.feature_profile.ui.models.FileModel
import com.example.feature_profile.ui.models.ProfileModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileApi: ProfileApi,
    private val dao: ProfileDao,
) : ViewModel() {
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

    init {
        downloadProfile()
    }

    val isEdit = MutableStateFlow(false)

    private fun downloadProfile() {
        viewModelScope.launch {
            runCatching {
                val response = profileApi.getProfile()
                if (response.isSuccessful) {
                    response.body()?.let { item ->
                        dao.insert(item.profileData.mapToEntity())
                        Log.d("ProfileApiError", item.profileData.toString())
                    }
                } else {
                    Log.d("ProfileApiError", response.toString())
                }
            }.onFailure { error ->
                Log.d("ProfileApiError", "Failed to fetch data: ${error.message}")
            }
        }
    }

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