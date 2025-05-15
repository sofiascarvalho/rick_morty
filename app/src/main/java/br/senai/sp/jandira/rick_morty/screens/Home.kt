package br.senai.sp.jandira.rick_morty.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.rick_morty.R
import br.senai.sp.jandira.rick_morty.model.Character
import br.senai.sp.jandira.rick_morty.model.Result
import br.senai.sp.jandira.rick_morty.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Home(modifier: Modifier = Modifier) {

    //variavel que guarda a lista de personagens devolvida pela api
    var characterList= remember{
        mutableStateOf(listOf<Character>())
    }

    //obter um Retrofit Factory
    //fazendo requisicao para o endpoint listAl
    var callCharacters=RetrofitFactory()
        .getCharacterService()
        .listAll()

    //enviar a requisicao
    //fazer a chamada e devolver o result (listAll)
    callCharacters.enqueue(object : Callback<Result> {
        override fun onResponse(p0: Call<Result>, response: Response<Result>) {
            characterList.value = response.body()!!.results
        }

        override fun onFailure(p0: Call<Result>, p1: Throwable) {
            TODO("Not yet implemented")
        }

    })

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(
                R.drawable.rick_morty),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xbb000000))
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ){
            Text(
                text = "Rick & Morty",
                color = Color.White,
                fontSize = 48.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                //trailing é no final da linha
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Characters List",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            //monta a quantidade de cards de acordo com a rolagem
            //abaixando a tela, ela vai criando mais cards
            //repete os items especificados
            LazyColumn {
                items(characterList.value){
                    CharacterCard(
                        name = it.name,
                        status = it.status,
                        species = it.species,
                        image = it.image
                    )
                }
            }

        }
    }
}


@Preview
@Composable
private fun HomePreview() {
    Home()
}