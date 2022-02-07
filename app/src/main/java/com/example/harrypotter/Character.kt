package com.example.harrypotter

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Character(
    val name: String,
    val species: String,
    val house: String,
    val image: String,
    val patronus: String
) : Parcelable
