package com.test.restaurantes.presentation.di

import com.test.restaurantes.domain.usecase.GetRecordsUseCase
import com.test.restaurantes.framework.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providerGetRecordUseCase(repository : Repository) : GetRecordsUseCase {
        return GetRecordsUseCase(repository)
    }


}