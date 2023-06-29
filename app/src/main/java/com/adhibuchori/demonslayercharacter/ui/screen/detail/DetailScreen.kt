package com.adhibuchori.demonslayercharacter.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adhibuchori.demonslayercharacter.di.Injection
import com.adhibuchori.demonslayercharacter.ui.ViewModelFactory
import com.adhibuchori.demonslayercharacter.ui.common.State
import com.adhibuchori.demonslayercharacter.ui.components.DetailComponent

@Composable
fun DetailScreen(
    id: Long,
    detailViewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(
                LocalContext.current
            )
        )
    ),
    navigateBack: () -> Unit,
) {
    detailViewModel.demonSlayerCharacterDetail.collectAsState(initial = State.Loading).value.let { uiState ->
        when (uiState) {
            is State.Loading -> {
                detailViewModel.getCharacterById(id)
            }

            is State.Success -> {
                DetailComponent(
                    demonSlayerCharacter = uiState.data,
                    isFavourite = detailViewModel.isFavorite,
                    addToFavourite = { character -> detailViewModel.addFavouriteUser(character) },
                    deleteFromFavourite = { character ->
                        detailViewModel.deleteFavouriteUser(
                            character.id
                        )
                    }
                )
            }

            is State.Error -> {

            }
        }
    }
}