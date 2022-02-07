package com.example.harrypotter

import android.util.Log

class HPRepository {
    private val database = HPDataBase.getInstance(DBApp.app.applicationContext)

    suspend fun getCharacters(): List<Character> {
        try {
            return Networking.api.getCharacters()
        } catch (e: Exception) {
            Log.e("QAW", "{$e}")
        }
        return emptyList()
    }

    suspend fun insertCharacters(characters: List<Character>) {
        database.characterDao().insertCharacters(characters)
    }
}