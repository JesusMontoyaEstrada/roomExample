package com.test.restaurantes.framework.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "restaurant_data_table")
data class RestaurantEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    val name: String,
    val rating: Float,
    val description: String?,
    val address: String,
    val imageUrl: String
): Serializable {

    companion object {
        fun populateData(): List<RestaurantEntity> {
            return listOf(
                RestaurantEntity(
                    0,
                    "Monte Cristo",
                    4.5f,
                    "Especialidades mexicanas presentadas de forma original en una casona colonial con comedor refinado y terraza.",
                    "Av. Insurgentes Nte. Nº 1980, Lindavista, Gustavo A. Madero, 07300 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1504674900247-0877df9cc836"
                ),
                RestaurantEntity(
                    1,
                    "Quintonil",
                    5f,
                    "Restaurante conocido con menú de degustación que ofrece ambiciosos platos de carne y mariscos, además de vinos.Especialidades mexicanas presentadas de forma original en una casona colonial con comedor refinado y terraza.",
                    "Av. Isaac Newton 55, Polanco, Polanco IV Secc, Miguel Hidalgo, 11560 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1467003909585-2f8a72700288"
                ),
                RestaurantEntity(
                    2,
                    "Azul Histórico",
                    4.5f,
                    "Un espacio clásico con terraza grande en un edificio histórico que sirve alta gastronomía de México.",
                    "Isabel La Católica 30, Centro Histórico de la Cdad. de México, Centro, Cuauhtémoc, 06000 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1484723091739-30a097e8f929"
                ),
                RestaurantEntity(
                    3,
                    "Restaurante Rosetta",
                    4.5f,
                    null,
                    "Colima 166, Roma Nte., Cuauhtémoc, 06700 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1476224203421-9ac39bcb3327"
                ),
                RestaurantEntity(
                    4,
                    "Maximo Bistrot",
                    4.5f,
                    "Platos de brunch y menús degustación, que incluyen tacos, ceviche, cochinillo y vinos mexicanos.",
                    "Av. Álvaro Obregón 65 Bis, Roma Nte., Cuauhtémoc, 06700 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1529042410759-befb1204b468"
                ),
                RestaurantEntity(
                    5,
                    "Merotoro",
                    4f,
                    "Restaurante amplio y moderno con un menú mexicano gourmet usando ingredientes orgánicos y locales.",
                    "Amsterdam 204, Hipódromo, Cuauhtémoc, 06100 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1511690656952-34342bb7c2f2"
                ),
                RestaurantEntity(
                    6,
                    "Restaurante El Cardenal",
                    5f,
                    null,
                    "Avenida de la Paz 32, San Ángel, Álvaro Obregón, 01000 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd"
                ),
                RestaurantEntity(
                    7,
                    "Zéfiro",
                    5f,
                    null,
                    "San Jerónimo 24, Centro Histórico de la Cdad. de México, Centro, Cuauhtémoc, 06000 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1496412705862-e0088f16f791"
                ),
                RestaurantEntity(
                    8,
                    "Garum",
                    4.5f,
                    null,
                    "Av. Pdte. Masaryk 513, Polanco, Polanco II Secc, Miguel Hidalgo, 11560 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1565958011703-44f9829ba187"
                ),
                RestaurantEntity(
                    9,
                    "Restaurante Les Moustaches",
                    5f,
                    "Restaurante de lujo de 1974, ubicado en una mansión, donde se sirven vinos y comida francesa ecléctica.",
                    "Río Sena 88 Entre Paseo dela Reforma, Calle Río Lerma y, Cuauhtémoc, 06500 Ciudad de México, CDMX",
                    "https://images.unsplash.com/photo-1432139555190-58524dae6a55"
                )
            )
        }
    }
}