package com.test.restaurantes.framework.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IRestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(restaurantEntity: RestaurantEntity)

    @Query("SELECT * FROM restaurant_data_table")
    fun getAllRestaurants(): Flow<List<RestaurantEntity>>

}