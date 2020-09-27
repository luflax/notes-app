package com.example.notasApp.ui.notaDetalhada

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notasApp.data.NotaRepository

class NotaDetalhadaViewModelFactory(private val notaRepository: NotaRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotaDetalhadaViewModel(notaRepository) as T
    }
}