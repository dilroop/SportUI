package com.dsb.sports.di

import com.dsb.sports.data.ContentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object NetworkHiltModule {

    @Provides
    @Singleton
    fun provideRepository(): ContentRepository {
        // Build up a complex api
        return ContentRepository()
    }
}