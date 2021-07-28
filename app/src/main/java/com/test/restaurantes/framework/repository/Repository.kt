package com.test.restaurantes.framework.repository

import com.test.restaurantes.framework.database.RestaurantEntity
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getRestaurant(): Flow<List<RestaurantEntity>>

}