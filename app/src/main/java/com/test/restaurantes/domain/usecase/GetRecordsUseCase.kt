package com.test.restaurantes.domain.usecase

import com.test.restaurantes.framework.database.RestaurantEntity
import com.test.restaurantes.framework.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetRecordsUseCase(private val repository : Repository) {
    fun execute(): Flow<List<RestaurantEntity>> = repository.getRestaurant()
}