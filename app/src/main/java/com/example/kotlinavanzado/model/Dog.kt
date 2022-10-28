package com.example.kotlinavanzado.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dog (  val id:Long,
                 val index:Int,
                 val name:String,
                 val type:String,
                    val heightFemale: String,
                  val heightMale: String,
                 val imageUrl: String,
                   val lifeExpectancy: String,
                  val temperament:String,
                 val weightFemale:String,
                  val weighMale:String) : Parcelable
