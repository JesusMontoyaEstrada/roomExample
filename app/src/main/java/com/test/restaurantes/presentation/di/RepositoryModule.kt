package com.test.restaurantes.presentation.di

import com.test.restaurantes.domain.repository.RepositoryImpl
import com.test.restaurantes.framework.database.IRestaurantDao
import com.test.restaurantes.framework.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(dao : IRestaurantDao) : Repository {
        return RepositoryImpl(dao)
    }
}