package com.example.notasApp.ui.notas

import androidx.lifecycle.ViewModel
import com.example.notasApp.data.Nota
import com.example.notasApp.data.NotaRepository

class NotasViewModel(private val notasRepository: NotaRepository) : ViewModel() {

    fun buscarTodos() = notasRepository.buscarTodos()

    fun salvar(nota: Nota) = notasRepository.salvar(nota)
}