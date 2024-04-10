package com.example.buscadordecep.api

import com.example.buscadordecep.model.Endereco
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoAPI {

    //BASE URL: https://viacep.com.br/ + ws/01001000/json/
    //No caso da API via CEP, a rota é onde fica depois do +, pois depois do ws, é onde vai o CEP do lugar que estamos buscando
    @GET("ws/{cep}/json/") // aqui eu passo o nome que coloquei no Path
    //A variavel cepDigitado, vou finalizar a configuração aqui dentro da interface
    //Abaixo configurei o cep do tipo string, passando um Path, um caminho.
    //Ao usar o Path, é como se fosse a mesma coisa na classe endereço, onde foi utilizado o @SerializedName
    //O Path está informando que o paramentro cepDigitado, tem o nome de cep
    //Acima vou passar como parametro no GET, passando para o caminho, que é a rota
    suspend fun recuperarEndereco(@Path("cep") cepDigitado: String) : Response<Endereco>

}