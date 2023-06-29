package com.adhibuchori.demonslayercharacter.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adhibuchori.demonslayercharacter.model.DemonSlayerCharacter
import com.adhibuchori.demonslayercharacter.ui.theme.DemonSlayerCharacterTheme

@Composable
fun DemonSlayerListItem(
    demonSlayerCharacter: DemonSlayerCharacter,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = demonSlayerCharacter.imageUrl,
            contentDescription = demonSlayerCharacter.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = demonSlayerCharacter.name,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start= 10.dp)
            )
            Text(
                text = demonSlayerCharacter.characterType,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start= 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemonSlayerListItemPreview() {
    DemonSlayerCharacterTheme {
        DemonSlayerListItem(
            DemonSlayerCharacter(
                1,
                "Tanjiro Kamado",
                "Natsuki Hanae",
                "Male",
                "Main Character",
                "https://i.pinimg.com/736x/b9/5d/61/b95d61532f200c39c95b7a8e7af207af.jpg",
                "Tanjiro Kamado is a determined and kind-hearted young boy who becomes a demon slayer after his family is slaughtered by demons. He possesses a unique sense of smell."
            )
        )
    }
}