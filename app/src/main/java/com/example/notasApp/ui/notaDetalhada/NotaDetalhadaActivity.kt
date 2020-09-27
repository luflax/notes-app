package com.example.notasApp.ui.notaDetalhada

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notasApp.R
import com.example.notasApp.databinding.ActivityNotaDetalhadaBinding
import com.example.notasApp.utils.InjecaoUtils
import kotlinx.android.synthetic.main.activity_nota_detalhada.*

class NotaDetalhadaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_detalhada)

        inicializarUi()
    }

    fun inicializarUi(){
        val factory = InjecaoUtils.recuperarNotaDetalhadaViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(NotaDetalhadaViewModel::class.java)

        DataBindingUtil.setContentView<ActivityNotaDetalhadaBinding>(
            this, R.layout.activity_nota_detalhada
        ).apply {
            this.lifecycleOwner = this@NotaDetalhadaActivity
            this.viewModel = viewModel
        }

        val acao = intent.getStringExtra("acao")
        val titulo = intent.getStringExtra("titulo")

        if(acao.equals("editar")){
            viewModel.buscar(titulo)
            editTextTitulo.isEnabled = false
        }
    }
}