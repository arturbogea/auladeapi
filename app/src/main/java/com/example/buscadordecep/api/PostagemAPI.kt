package com.example.buscadordecep.api

import com.example.buscadordecep.model.Comentario
import com.example.buscadordecep.model.Postagem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PostagemAPI {


    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")

    suspend fun recuperarPostagens(): Response<List<Postagem>>

    @GET("posts/{id}")

    suspend fun recuperarPostagemUnica(@Path("id") id: Int): Response<Postagem>

    @GET("posts/{id}/comments")

    suspend fun recuperarComentariosParaPostagem(@Path("id") id: Int): Response<List<Comentario>>

    //Usando Query
    /*
    O Query é diferente do Path. Quando defino o Query id, ele não vai para o GET.
    O postId como está abaixo, é o Query que vai criar o postId. Mas não posso passar apenas id, pois tem que ser o mesmo nome da api.
    No link da api, tem o ?. Mas serve apenas para separar os paramentros
     */

    @GET("comments") //comments?postId=1. Por baixo dos panos, quando o retrofit for criar a requisição, ela irá colocar o ?

    suspend fun recuperarComentariosParaPostagemQuery(@Query("postId") id: Int): Response<List<Comentario>>


    /*
    O Path tem que passar o parametro dentro da rota. @GET("posts/{id}/comments") @Path("id") id: Int
    Já o Query, o parametro é passado automaticamente  @GET("comments") @Query("postId") id: Int

    O Path tem que passar um paramentro, não pode se deicar vazio. Ex: @GET("posts//comments")
    Se eu tirar o id e ficar 2 //, não vai retornar nada
    Ao usar a Query, é mais flexivel, pois ele passa automaticamente o parametro que queremos. Ele que vai criar

    Mas ambos fazem a mesma coisa. Ambos trazem o mesmo resultado.

     */

    //O post é uma requisição que serve para salvar dados na API
    @POST("post")
    suspend fun salvarPostagem(@Body postagem: Postagem): Response<Postagem>

    /*
    Requisição Put serve para atualizar dados no servidor(modificação completa).
    @PUT("posts/{id}")
    É utilizado o @Path id: Int e o @Body postagem: Postagem
    O Path é para definir o id, que será redirecionado na rota ao lado de post
    O Body é para atualizar o corpo do item que que quero atualizar.
     */


    @PUT("posts/{id}") //Atualicação completa
    suspend fun atualizarPostagemPut(@Path("id")  id: Int, @Body postagem: Postagem): Response<Postagem>


    /*
    Requisição Patch serve também para atualizar dados no servidor(Aplicando modificações parciais)
    @PATCH("posts/{id}")
    É utilizado o @Path id: Int e o @Body postagem: Postagem
    O Path é para definir o id, que será redirecionado na rota ao lado de post
    O Body é para atualizar o corpo do item que que quero atualizar.
     */

    @PATCH("posts/{id}") //Atualicação parcial
    suspend fun atualizarPostagemPatch(@Path("id")  id: Int, @Body postagem: Postagem): Response<Postagem>

    /*
    Requisição Delete serve para remover dados do servidor.
    @DELETE("posts/{id}")
     */

    @DELETE("posts/{id}")
    suspend fun removerPostagem(@Path("id") id: Int): Response<Unit> //Aqui no tipo, pode deixar o Unit, pois como vai deletar, não vai retornar nada. Pois ao apagar a postagem, ela não vai existir mais. Posso deixar sem o Unit também.



}