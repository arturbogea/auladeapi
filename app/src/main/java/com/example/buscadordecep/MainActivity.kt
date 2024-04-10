package com.example.buscadordecep

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buscadordecep.api.EnderecoAPI
import com.example.buscadordecep.api.RetrofitHelper
import com.example.buscadordecep.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                recuperarEndereco()
            }
        }

    }

    private suspend fun recuperarEndereco(){
        //Aqui passo uma interface para o metodo create, do objeto retrofit. Ele retorna um objeto. Esse objeto retornado, é do tipo endereço api
        //O metodo create recebe uma interface, e no final, a partir da interface, ele cria e retorna um objeto.
        val enderecoAPI = retrofit.create(EnderecoAPI:: class.java)
        val retorno = enderecoAPI.recuperarEndereco() // Dentro da interface EnderecoAPI, que será feito todas as configurações
    }
}