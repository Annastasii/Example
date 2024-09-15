package com.example.feature_profile.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_database.dao.ProfileDao
import com.example.core_database.dao.UserDao
import com.example.core_network.api.ProfileApi
import com.example.feature_profile.domain.Mapper.mapToEntity
import com.example.feature_profile.domain.Mapper.mapToModel
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
    private val userDao: UserDao,
) : ViewModel() {

    val profileModel = MutableStateFlow<ProfileModel?>(null)

    init {
        downloadProfile()
        subscribeProfile()
    }

    val isEdit = MutableStateFlow(false)

    private fun downloadProfile() {
        viewModelScope.launch {
            runCatching {
                val response = profileApi.getProfile()
                if (response.isSuccessful) {
                    response.body()?.let { item ->
                        dao.insert(item.profileData.mapToEntity())
                    }
                } else {
                    Log.d("ProfileApiError", response.toString())
                }
            }.onFailure { error ->
                Log.d("ProfileApiError", "Failed to fetch data: ${error.message}")
            }
        }
    }

    fun save(){

    }

    private fun subscribeProfile() {
        viewModelScope.launch {
            if (userDao.getActiveUser() != null){
                dao.getProfileFlow(userDao.getActiveUser()!!.id).collect {
                    profileModel.value = it?.mapToModel()
                }
            }
        }
    }

    fun onChangeBirthday(value: String) {
        profileModel.update { it!!.copy(birthday = value) }
        isEdit.value = true
    }

    fun onChangeCity(value: String) {
        profileModel.update { it!!.copy(city = value) }
        isEdit.value = true
    }

    fun onChangeAbout(value: String) {
        profileModel.update { it!!.copy(instagram = value) }
        isEdit.value = true
    }

}