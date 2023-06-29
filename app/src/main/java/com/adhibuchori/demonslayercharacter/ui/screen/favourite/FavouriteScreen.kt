package com.adhibuchori.demonslayercharacter.ui.screen.favourite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adhibuchori.demonslayercharacter.di.Injection
import com.adhibuchori.demonslayercharacter.ui.ViewModelFactory
import com.adhibuchori.demonslayercharacter.ui.common.State
import com.adhibuchori.demonslayercharacter.ui.components.FavouriteContent

@Composable
fun FavouriteScreen(
    modifier: Modifier = Modifier,
    favouriteViewModel: FavouriteViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(
                LocalContext.current
            )
        )
    ),
    navigateToDetail: (Long) -> Unit,
) {
    favouriteViewModel.favouriteCharacters.collectAsState(initial = State.Loading).value.let { uiState ->
        when (uiState) {
            is State.Loading -> {
                favouriteViewModel.getFavouriteUser()
            }

            is State.Success -> {
                FavouriteContent(
                    modifier = modifier,
                    favoriteDemonSlayerCharacters = uiState.data,
                    navigateToDetail = navigateToDetail
                )
            }

            is State.Error -> {}
        }
    }

}