package com.example.harrypotter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HPViewModel : ViewModel() {
    private val repository = HPRepository()

    private val charactersHP = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>>
        get() = charactersHP

    fun getCharacters() {
        viewModelScope.launch {
            val characters = repository.getCharacters()
            charactersHP.value = characters
            repository.insertCharacters(characters)
        }
    }
}