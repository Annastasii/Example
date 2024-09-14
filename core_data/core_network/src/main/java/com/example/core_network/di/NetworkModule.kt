package com.example.core_network.di

import com.example.core_network.api.AuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

        @Provides
        @Singleton
        fun provideGoogleDriveApi(retrofit: Retrofit): AuthApi {
            return retrofit.create(AuthApi::class.java)
        }
}