package com.example.notasApp.ui.notas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notasApp.data.NotaRepository

class NotasViewModelFactory(private val notasRepository: NotaRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotasViewModel(notasRepository) as T
    }
}