package com.example.notasApp.ui.notaDetalhada

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notasApp.data.Nota
import com.example.notasApp.data.NotaRepository
import com.example.notasApp.ui.notas.NotasActivity


class NotaDetalhadaViewModel(private val notaRepository: NotaRepository) : ViewModel() {

    var nota: LiveData<Nota> = MutableLiveData(Nota("", ""))
    private var editandoNota: Boolean = false

    fun buscar(titulo: String) {
        val buscar = notaRepository.buscar(titulo)
        if (buscar != null) {
            nota = MutableLiveData(buscar)
            editandoNota = true
        }
    }

    fun salvar(view: View) {
        if(nota.value == null || nota.value!!.titulo.isEmpty()){
            enviarMensagemToastCurta(view, "O campo título é obrigatório")
            return
        }

        val buscar = notaRepository.buscar(nota.value!!.titulo)

        if(buscar != null && !editandoNota){
            enviarMensagemToastCurta(view, "Já existe uma nota com esse título")
            return
        }

        nota.value?.let { notaRepository.substituir(it) }
        val intent = Intent(view.context, NotasActivity::class.java)

        view.context.startActivity(intent)

    }

    private fun enviarMensagemToastCurta(view: View, mensagem: String){
        Toast.makeText(
            view.context, mensagem,
            Toast.LENGTH_SHORT
        ).show()
    }
}