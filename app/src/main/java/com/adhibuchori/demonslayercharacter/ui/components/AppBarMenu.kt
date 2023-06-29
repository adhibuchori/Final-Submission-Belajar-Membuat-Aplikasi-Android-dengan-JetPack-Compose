package com.adhibuchori.demonslayercharacter.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.adhibuchori.demonslayercharacter.ui.theme.DemonSlayerCharacterTheme

@Composable
fun AppBarMenu(
    navigateToAbout: () -> Unit,
    navigateToFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        IconButton(onClick = navigateToFavorite) {
            Icon(
                Icons.Default.Favorite,
                "favourite_character",
                tint = Color.White
            )
        }

        IconButton(onClick = navigateToAbout) {
            Icon(
                Icons.Default.Person,
                "about_page",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun AppBarMenuPreview() {
    DemonSlayerCharacterTheme {
        AppBarMenu(
            navigateToAbout = {},
            navigateToFavorite = {}
        )
    }
}