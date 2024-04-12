package com.example.buscadordecep

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buscadordecep.api.EnderecoAPI
import com.example.buscadordecep.api.PostagemAPI
import com.example.buscadordecep.api.RetrofitHelper
import com.example.buscadordecep.databinding.ActivityMainBinding
import com.example.buscadordecep.model.Comentario
import com.example.buscadordecep.model.Endereco
import com.example.buscadordecep.model.Postagem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val retrofit by lazy {
        RetrofitHelper.retrofit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnIniciar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                //recuperarEndereco()
                //recuperarPostagens()
                //recuperarPostagemUnica()
                //recuperarComentarioParaPostagem()
            }
        }

    }

    private suspend fun salvarPostagem() {
        var retorno: Response<Postagem>? = null
        val postagem = Postagem("Corpo da postagem", -1, "Titulo da postagem", 1090)


        try {
            val postagemAPI = retrofit.create(PostagemAPI::class.java)

            retorno = postagemAPI.salvarPostagem(postagem)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_jsonPlace", "Erro ao recuperar")
        }

        if (retorno != null) {
            /*
            Se deu tudo certo para pegar os dados acima, ele vai entrar no if para ver se é diferente de nulo.
            Caso seja diferente de nulo, ele entra no outro if, para ver se o retorno foi feito com sucesso.
            Caso deu tudo certo, crio uma variavel endereço, pois o retorno é um endereço.
            Como o retorno é um response de endereço, coloco o retorno.body. Pois ele pega o retorno do response
            O response é um objeto especial da propria retrofit, para que possamos ter o retorno da requisição
             */
            if (retorno.isSuccessful) {
                val postagem = retorno.body()
                val id = postagem?.id
                val title = postagem?.title
                val idUsiario = postagem?.userId
                val resultado = "id: $id - Tittle: $title - User: $idUsiario"

                withContext(Dispatchers.Main) {
                    binding.textResultado.text = resultado
                }

            }

        }
    }

    /*private suspend fun recuperarComentarioParaPostagem() {
        var retorno: Response<List<Comentario>>? = null


        try {
            val postagemAPI = retrofit.create(PostagemAPI:: class.java)
            //O cepDigitado, vou passar como parametro abaixo e vou configurar na interface
            //retorno = postagemAPI.recuperarComentariosParaPostagem(1) Aqui se usa o Path
            retorno = postagemAPI.recuperarComentariosParaPostagemQuery(1) // Query
        }catch (e: Exception){
            e.printStackTrace()
            Log.i("info_jsonPlace", "Erro ao recuperar")
        }

        if (retorno != null){
            *//*
            Se deu tudo certo para pegar os dados acima, ele vai entrar no if para ver se é diferente de nulo.
            Caso seja diferente de nulo, ele entra no outro if, para ver se o retorno foi feito com sucesso.
            Caso deu tudo certo, crio uma variavel endereço, pois o retorno é um endereço.
            Como o retorno é um response de endereço, coloco o retorno.body. Pois ele pega o retorno do response
            O response é um objeto especial da propria retrofit, para que possamos ter o retorno da requisição
             *//*
            if (retorno.isSuccessful){
                val listaComentario = retorno.body()
                var resultado = ""
                listaComentario?.forEach { comentario ->
                    val idComentario = comentario.id
                    val email = comentario.email
                    val comentarioResultado = "$idComentario - $email \n"
                    resultado += comentarioResultado
                }


                withContext(Dispatchers.Main){
                    binding.textResultado.text = resultado
                }

            }

        }
    }*/


    /*private suspend fun recuperarPostagemUnica() {
        var retorno: Response<Postagem>? = null


        try {
            val postagemAPI = retrofit.create(PostagemAPI:: class.java)
            //O cepDigitado, vou passar como parametro abaixo e vou configurar na interface
            retorno = postagemAPI.recuperarPostagemUnica(4) // Dentro da interface EnderecoAPI, que será feito todas as configurações
        }catch (e: Exception){
            e.printStackTrace()
            Log.i("info_jsonPlace", "Erro ao recuperar")
        }

        if (retorno != null){
            *//*
            Se deu tudo certo para pegar os dados acima, ele vai entrar no if para ver se é diferente de nulo.
            Caso seja diferente de nulo, ele entra no outro if, para ver se o retorno foi feito com sucesso.
            Caso deu tudo certo, crio uma variavel endereço, pois o retorno é um endereço.
            Como o retorno é um response de endereço, coloco o retorno.body. Pois ele pega o retorno do response
            O response é um objeto especial da propria retrofit, para que possamos ter o retorno da requisição
             *//*
            if (retorno.isSuccessful){
                val postagem = retorno.body()
                val resultado = "${postagem?.id} - ${postagem?.title}"
                Log.i("info_jsonPlace", "$resultado")


                withContext(Dispatchers.Main){
                    binding.textResultado.text = resultado
                }

                }

                //Depois que usamos o body, temos acesso aos dados da api
                //Para poder usar a API, preciso da permissão de acesso a internet. Será configurado no manifest
            }
        }
    }*/

    /*private suspend fun recuperarPostagens() {
        var retorno: Response<List<Postagem>>? = null


        try {
            val postagemAPI = retrofit.create(PostagemAPI:: class.java)
            //O cepDigitado, vou passar como parametro abaixo e vou configurar na interface
            retorno = postagemAPI.recuperarPostagens() // Dentro da interface EnderecoAPI, que será feito todas as configurações
        }catch (e: Exception){
            e.printStackTrace()
            Log.i("info_jsonPlace", "Erro ao recuperar")
        }

        if (retorno != null){
            *//*
            Se deu tudo certo para pegar os dados acima, ele vai entrar no if para ver se é diferente de nulo.
            Caso seja diferente de nulo, ele entra no outro if, para ver se o retorno foi feito com sucesso.
            Caso deu tudo certo, crio uma variavel endereço, pois o retorno é um endereço.
            Como o retorno é um response de endereço, coloco o retorno.body. Pois ele pega o retorno do response
            O response é um objeto especial da propria retrofit, para que possamos ter o retorno da requisição
             *//*
            if (retorno.isSuccessful){
                val listaPostagens = retorno.body()
                listaPostagens?.forEach { postagem ->
                    val id = postagem.id
                    val tittle = postagem.title

                    Log.i("info_jsonPlace", "$id - $tittle")
                }

                //Depois que usamos o body, temos acesso aos dados da api
                //Para poder usar a API, preciso da permissão de acesso a internet. Será configurado no manifest
            }
        }
    }*/

    /*private suspend fun recuperarEndereco(){
        //Aqui passo uma interface para o metodo create, do objeto retrofit. Ele retorna um objeto. Esse objeto retornado, é do tipo endereço api
        //O metodo create recebe uma interface, e no final, a partir da interface, ele cria e retorna um objeto.

        var retorno: Response<Endereco>? = null
        //Abaixo, vou passar dados do cep, por enquanto sem o editText, para poder passar como parametro para a api
        val cepDigitado = "81320330"

        try {
            val enderecoAPI = retrofit.create(EnderecoAPI:: class.java)
            //O cepDigitado, vou passar como parametro abaixo e vou configurar na interface
            retorno = enderecoAPI.recuperarEndereco(cepDigitado) // Dentro da interface EnderecoAPI, que será feito todas as configurações
        }catch (e: Exception){
            e.printStackTrace()
            Log.i("info_endereco", "Erro ao recuperar endereço")
        }

        if (retorno != null){
            *//*
            Se deu tudo certo para pegar os dados acima, ele vai entrar no if para ver se é diferente de nulo.
            Caso seja diferente de nulo, ele entra no outro if, para ver se o retorno foi feito com sucesso.
            Caso deu tudo certo, crio uma variavel endereço, pois o retorno é um endereço.
            Como o retorno é um response de endereço, coloco o retorno.body. Pois ele pega o retorno do response
            O response é um objeto especial da propria retrofit, para que possamos ter o retorno da requisição
             *//*
            if (retorno.isSuccessful){
                val endereco = retorno.body()
                val rua = endereco?.rua
                val cidade = endereco?.cidade
                val estado = endereco?.estado
                Log.i("info_endereco", "Endereço: $rua, $cidade - $estado")
                //Depois que usamos o body, temos acesso aos dados da api
                //Para poder usar a API, preciso da permissão de acesso a internet. Será configurado no manifest
            }
        }

*/}

