package com.example.feature_profile.domain

import com.example.core_database.entity.ProfileEntity
import com.example.core_network.dto.dtoi.ProfileDTOI
import com.example.feature_profile.ui.models.ProfileModel

object Mapper {

    fun ProfileDTOI.mapToEntity(): ProfileEntity =
        ProfileEntity(
            name,
            username,
            birthday,
            city,
            vk,
            instagram,
            status,
            avatar,
            id,
            last.toString(),
            online,
            created.toString(),
            phone,
            completedTask,
        )

    fun ProfileEntity.mapToModel(): ProfileModel =
        ProfileModel(
            name,
            username,
            birthday,
            city,
            vk,
            instagram,
            status,
            id,
            phone,
        )
}