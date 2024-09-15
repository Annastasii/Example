package com.example.feature_profile.domain

import com.example.core_database.entity.ProfileEntity
import com.example.core_network.dto.dtoi.ProfileDTOI

object Mapper {

    fun ProfileDTOI.mapToEntity(): ProfileEntity =
        ProfileEntity(
            name,
            username,
            birthday.toString(),
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
            completedTask
        )
}