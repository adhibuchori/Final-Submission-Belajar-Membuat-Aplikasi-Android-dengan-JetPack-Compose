package com.adhibuchori.demonslayercharacter.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adhibuchori.demonslayercharacter.di.Injection
import com.adhibuchori.demonslayercharacter.ui.ViewModelFactory
import com.adhibuchori.demonslayercharacter.ui.components.HomeComponent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))),
    navigateToAbout: () -> Unit,
    navigateToDetail: (Long) -> Unit,
    navigateToFavorite: () -> Unit,
){
    val groupedCharacters by homeViewModel.groupedCharacters.collectAsState()

    val query by homeViewModel.query

    HomeComponent(
        groupedCharacters = groupedCharacters,
        query = query,
        onQueryChange = homeViewModel::search,
        navigateToAbout = navigateToAbout,
        navigateToDetail = navigateToDetail,
        navigateToFavorite = navigateToFavorite,
        modifier = modifier
    )
}