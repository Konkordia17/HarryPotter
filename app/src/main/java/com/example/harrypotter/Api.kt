package com.example.harrypotter

import retrofit2.http.GET

interface Api {

    @GET("/api/characters")
    suspend fun getCharacters(): List<Character>
}