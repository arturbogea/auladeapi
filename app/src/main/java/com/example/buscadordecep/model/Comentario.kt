package com.example.buscadordecep.model

import com.google.gson.annotations.SerializedName

data class Comentario(
    @SerializedName("body")
    val comentario: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)