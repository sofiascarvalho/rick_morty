package br.senai.sp.jandira.rick_morty.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitFactory {
    private val BASE_URL = "https://rickandmortyapi.com/api/"

    private val RETROFIT_FACTORY = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        //criando o conversor
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCharacterService(): CharacterService{
        return  RETROFIT_FACTORY
            .create(CharacterService::class.java)
            //::class.java é um atalho para criacao de objeto sem ter que declarar ele
    }
}

//retrofit factory tem a funcao de chamar o servico, sem a obrigacao de faze-lo