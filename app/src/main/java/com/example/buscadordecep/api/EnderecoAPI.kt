package com.example.buscadordecep.api

import retrofit2.http.GET

interface EnderecoAPI {

    //BASE URL: https://viacep.com.br/ + ws/01001000/json/
    //No caso da API via CEP, a rota é onde fica depois do +, pois depois do ws, é onde vai o CEP do lugar que estamos buscando
    @GET("ws/01001000/json/")
    suspend fun recuperarEndereco()

}