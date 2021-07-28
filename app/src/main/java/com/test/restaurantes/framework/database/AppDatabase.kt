package com.test.restaurantes.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [RestaurantEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val restaurantDao: IRestaurantDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "test_database"
                    )
                        .build()
                    INSTANCE = instance
                }
                instance.populateData()
                return instance
            }
        }
    }

    private fun populateData() {
        Thread {
            for (r in RestaurantEntity.populateData()) {
                val restaurant = RestaurantEntity(
                    r.id,
                    r.name,
                    r.rating,
                    r.description,
                    r.address,
                    r.imageUrl
                )
                restaurantDao.insert(restaurant)
            }
        }.start()
    }
}