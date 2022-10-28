package com.example.kotlinavanzado.model

import com.squareup.moshi.Json

data class Dog (  @field:Json(name = "id") val id:Long,
                 @field:Json(name = "index")val index:Int,
                 @field:Json(name = "name_es") val name:String,
                @field:Json(name = "dog_type") val type:String,
                 @field:Json(name = "height_female")    val heightFemale: Double,
                 @field:Json(name = "height_male") val heightMale: Double,
                 @field:Json(name = "image_url") val imageUrl: String,
                 @field:Json(name = "life_expectancy")   val lifeExpectancy: String,
                 @field:Json(name = "temperament") val temperament:String,
                 @field:Json(name = "weight_female") val weightFemale:String,
                 @field:Json(name = "weight_male") val weighMale:String)
