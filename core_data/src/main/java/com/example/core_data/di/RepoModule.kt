package com.example.core_data.di

import com.example.core_auth_api.repository.AuthRepository
import com.example.core_data.repo.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}
