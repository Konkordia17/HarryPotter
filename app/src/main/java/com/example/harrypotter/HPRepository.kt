package com.example.harrypotter

import android.util.Log
import java.lang.Exception

class HPRepository {

    suspend fun getCharacters(): List<Character> {
        try {
            return Networking.api.getCharacters()
        } catch (e: Exception) {
            Log.e("QAW", "{$e}")
        }
        return emptyList()
    }
}