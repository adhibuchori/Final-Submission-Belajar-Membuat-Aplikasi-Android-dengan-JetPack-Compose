package com.adhibuchori.demonslayercharacter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adhibuchori.demonslayercharacter.R
import com.adhibuchori.demonslayercharacter.model.DemonSlayerCharacter
import com.adhibuchori.demonslayercharacter.ui.theme.DemonSlayerCharacterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailComponent(
    demonSlayerCharacter: DemonSlayerCharacter,
    isFavourite: Boolean,
    addToFavourite: (DemonSlayerCharacter) -> Unit,
    deleteFromFavourite: (DemonSlayerCharacter) -> Unit,
    modifier: Modifier = Modifier,
) {
    val detailCharacterText = stringResource(R.string.detail_character)

    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {

        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.Transparent
            ),

            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = detailCharacterText,
                        style = typography.titleLarge,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        )

        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = demonSlayerCharacter.imageUrl,
                contentDescription = demonSlayerCharacter.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(200.dp)
                    .clip(CircleShape)
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = demonSlayerCharacter.name,
                style = typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            val isFavouriteState = remember { mutableStateOf(isFavourite) }

            ElevatedButton(
                onClick = {
                    if (isFavouriteState.value) {
                        deleteFromFavourite(demonSlayerCharacter)
                    } else {
                        addToFavourite(demonSlayerCharacter)
                    }
                    isFavouriteState.value = !isFavouriteState.value
                },
                modifier = Modifier.padding(top = 15.dp)
            ) {
                Icon(
                    imageVector = if (isFavouriteState.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = if (isFavouriteState.value) "Delete from Favourite" else "Add to Favourite"
                )
                Text(
                    text = "Favourite",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Column(
            modifier = modifier
                .padding(start = 20.dp)
                .padding(end = 20.dp),
        ) {
            Text(
                text = "Voice Actor",
                style = typography.bodyMedium,
                modifier = Modifier.padding(top = 15.dp)
            )
            Text(
                text = demonSlayerCharacter.voiceActor,
                style = typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 5.dp)
            )

            Text(
                text = "Character Type",
                style = typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = demonSlayerCharacter.characterType,
                style = typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 5.dp)
            )

            Text(
                text = "Gender",
                style = typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = demonSlayerCharacter.gender,
                style = typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 5.dp)
            )

            Text(
                text = demonSlayerCharacter.description,
                style = typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailComponentPreview() {
    DemonSlayerCharacterTheme {
        DetailComponent(
            DemonSlayerCharacter(
                1,
                "Tanjiro Kamado",
                "Natsuki Hanae",
                "Male",
                "Main Character",
                "https://i.pinimg.com/736x/b9/5d/61/b95d61532f200c39c95b7a8e7af207af.jpg",
                "Tanjiro Kamado is a determined and kind-hearted young boy who becomes a demon slayer after his family is slaughtered by demons. He possesses a unique sense of smell."
            ),
            isFavourite = false,
            addToFavourite = {},
            deleteFromFavourite = {}
        )
    }
}