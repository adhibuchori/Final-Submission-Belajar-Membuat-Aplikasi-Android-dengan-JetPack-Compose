package com.adhibuchori.demonslayercharacter.ui.screen.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adhibuchori.demonslayercharacter.data.Repository
import com.adhibuchori.demonslayercharacter.model.DemonSlayerCharacter
import com.adhibuchori.demonslayercharacter.ui.common.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavouriteViewModel(private val repository: Repository) : ViewModel() {

    private val _favouriteCharacters: MutableStateFlow<State<List<DemonSlayerCharacter>>> = MutableStateFlow(State.Loading)
    val favouriteCharacters: StateFlow<State<List<DemonSlayerCharacter>>>
        get() = _favouriteCharacters

    fun getFavouriteUser(){
        viewModelScope.launch{
            _favouriteCharacters.value = State.Loading
            repository.getFavouriteChar().collect{_favouriteCharacters.value = State.Success(it)}
        }
    }
}