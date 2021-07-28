package com.test.restaurantes.domain.repository

import com.test.restaurantes.framework.database.IRestaurantDao
import com.test.restaurantes.framework.database.RestaurantEntity
import com.test.restaurantes.framework.repository.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val dao: IRestaurantDao): Repository {
    override fun getRestaurant(): Flow<List<RestaurantEntity>> {
        return dao.getAllRestaurants()
    }
}