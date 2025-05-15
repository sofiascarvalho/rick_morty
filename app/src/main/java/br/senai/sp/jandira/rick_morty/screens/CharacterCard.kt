package br.senai.sp.jandira.rick_morty.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CharacterCard(
    name: String="Nome do personagem",
    species: String="Espécie do personagem",
    status: String="Status do personagem",
    image: String="Url da imagem"
) {
    Card (
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x44ffffff)
        ),
        border = BorderStroke(1.dp, Color.White)
    ){
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Card (
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(90.dp),
                shape = CircleShape
            ){
                AsyncImage(
                    model = image,
                    contentDescription = ""
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = name, color = Color.White)
                Text(text = species, color = Color.White)
                Text(text = status, color = Color.White)
            }
        }
    }
}

@Preview
@Composable
private fun CharacterCardPreview() {
    CharacterCard()
}