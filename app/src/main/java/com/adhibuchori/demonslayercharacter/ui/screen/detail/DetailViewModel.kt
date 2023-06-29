package com.adhibuchori.demonslayercharacter.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adhibuchori.demonslayercharacter.data.Repository
import com.adhibuchori.demonslayercharacter.ui.common.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.adhibuchori.demonslayercharacter.model.DemonSlayerCharacter

class DetailViewModel(private val repository: Repository) : ViewModel() {

    private val _DemonSlayer_characterDetail: MutableStateFlow<State<DemonSlayerCharacter>> = MutableStateFlow(State.Loading)
    val demonSlayerCharacterDetail: StateFlow<State<DemonSlayerCharacter>>
        get() = _DemonSlayer_characterDetail

    var isFavorite = false

    fun getCharacterById(id: Long){
        viewModelScope.launch {
            repository.getFavouriteCharById(id).collect{
                _DemonSlayer_characterDetail.value = State.Loading
                isFavorite = it != null
                _DemonSlayer_characterDetail.value = State.Success(repository.getCharacterById(id))
            }
        }
    }

    fun addFavouriteUser(demonSlayerCharacter: DemonSlayerCharacter){
        viewModelScope.launch {
            repository.addFavouriteChar(demonSlayerCharacter)
        }
    }

    fun deleteFavouriteUser(id: Long){
        viewModelScope.launch {
            repository.deleteFavouriteChar(id)
        }
    }
}