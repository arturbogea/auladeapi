package com.example.buscadordecep.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    //Configuração do Retrofit
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(GsonConverterFactory.create())// Conversor para Json ou XML
            .build()
    }


}