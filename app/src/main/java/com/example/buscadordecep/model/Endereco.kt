package com.example.buscadordecep.model

import com.google.gson.annotations.SerializedName

data class Endereco(

    /*
    O nome da variavel, deve ser o mesmo que está na api, pois ele vai associar o valor.
    Caso o valor que estamos passando, seja diferente, ele não retorna. Caso queiramos passar o nome diferente, devemos utilizar o @SerializedName.
    Como se eu estivesse dizendo que o atributo logradouro no json, corresponde ao atributo rua no meu codigo.
    Vou passar 3 exemplos abaixo
     */
    val cep: String,
    @SerializedName("logradouro")
    val rua: String,
    val bairro: String,
    @SerializedName("localidade")
    val cidade: String,
    @SerializedName("uf")
    val estado: String,

)
