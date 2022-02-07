package com.example.harrypotter

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity(tableName = "HarryPotter")
@Parcelize
@JsonClass(generateAdapter = true)
data class Character(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "species")
    val species: String,
    @ColumnInfo(name = "house")
    val house: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "patronus")
    val patronus: String
) : Parcelable
