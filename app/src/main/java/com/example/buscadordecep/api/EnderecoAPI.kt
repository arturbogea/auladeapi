package com.example.buscadordecep.api

import retrofit2.http.GET

interface EnderecoAPI {

    //BASE URL: https://viacep.com.br/
    @GET
    suspend fun recuperarEndereco()

}