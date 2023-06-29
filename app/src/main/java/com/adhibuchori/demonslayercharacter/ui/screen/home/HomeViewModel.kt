package com.adhibuchori.demonslayercharacter.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.adhibuchori.demonslayercharacter.data.Repository
import com.adhibuchori.demonslayercharacter.model.DemonSlayerCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _groupedCharacters = MutableStateFlow(
        repository.getAllCharacters().sortedBy { it.name }.groupBy { it.name }
    )

    val groupedCharacters: StateFlow<Map<String, List<DemonSlayerCharacter>>> get() = _groupedCharacters

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedCharacters.value = repository.searchCharacters(newQuery).sortedBy { it.name }.groupBy { it.name }
    }
}