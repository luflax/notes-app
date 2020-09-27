package com.example.notasApp.ui.notas

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notasApp.R
import com.example.notasApp.ui.notaDetalhada.NotaDetalhadaActivity
import com.example.notasApp.utils.InjecaoUtils
import kotlinx.android.synthetic.main.activity_notas.*


class NotasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        inicializarUi()
    }

    private fun inicializarUi() {
        val factory = InjecaoUtils.recuperarNotasViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(NotasViewModel::class.java)

        viewModel.buscarTodos().observe(this, Observer { notas ->
            listCharacters.adapter = ArrayAdapter<String>(
                applicationContext,
                R.layout.nota_textview,
                notas.map { nota -> nota.titulo }
            )
        })

        listCharacters.onItemClickListener = OnItemClickListener { _, view, _, _ ->
            val textView = view as TextView
            val intent = Intent(this, NotaDetalhadaActivity::class.java).apply {
                putExtra("acao", "editar")
                putExtra("titulo", textView.text)
            }
            startActivity(intent)
        }

        buttonAddNota.setOnClickListener {
            val intent = Intent(this, NotaDetalhadaActivity::class.java).apply {
                putExtra("acao", "criar")
            }
            startActivity(intent)
        }
    }
}