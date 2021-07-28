package com.test.restaurantes.presentation.di

import android.app.Application
import androidx.room.Room
import com.test.restaurantes.domain.repository.RepositoryImpl
import com.test.restaurantes.framework.database.AppDatabase
import com.test.restaurantes.framework.database.IRestaurantDao
import com.test.restaurantes.framework.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {


    @Singleton
    @Provides
    fun providesDB(app: Application): AppDatabase {
        return AppDatabase.getInstance(app)
    }

    @Singleton
    @Provides
    fun provideDAO(appDataBase: AppDatabase): IRestaurantDao {
        return appDataBase.restaurantDao
    }

}