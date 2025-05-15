package br.senai.sp.jandira.rick_morty.service

import br.senai.sp.jandira.rick_morty.model.Character
import br.senai.sp.jandira.rick_morty.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    //quando chamar a listall, o retrofit sabe que faremos get na url base com character no final
    @GET("character")
    fun listAll(): Call<Result>

    @GET("character/{id}")
    fun findById(@Path("id") id: Int): Call<Character>
}