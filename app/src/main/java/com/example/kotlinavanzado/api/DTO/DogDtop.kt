package com.example.kotlinavanzado.api.DTO

import com.squareup.moshi.Json
  class DogDtop (  @field:Json(name = "id") val id:Long,
                  @field:Json(name = "index")val index:Int,
                  @field:Json(name = "name_es") val name:String,
                  @field:Json(name = "dog_type") val type:String,
                  @field:Json(name = "height_female")    val heightFemale: String,
                  @field:Json(name = "height_male") val heightMale: String,
                  @field:Json(name = "image_url") val imageUrl: String,
                  @field:Json(name = "life_expectancy")   val lifeExpectancy: String,
                  @field:Json(name = "temperament") val temperament:String,
                  @field:Json(name = "weight_female") val weightFemale:String,
                  @field:Json(name = "weight_male") val weighMale:String)
