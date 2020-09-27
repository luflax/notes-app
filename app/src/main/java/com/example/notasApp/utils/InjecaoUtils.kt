package com.example.notasApp.utils

import com.example.notasApp.data.Database
import com.example.notasApp.data.NotaRepository
import com.example.notasApp.ui.notaDetalhada.NotaDetalhadaViewModelFactory
import com.example.notasApp.ui.notas.NotasViewModelFactory

object InjecaoUtils {

    fun recuperarNotasViewModelFactory() : NotasViewModelFactory {
        val notaRepository = NotaRepository.getInstace(Database.getInstance().notaDao)
        return NotasViewModelFactory(notaRepository)
    }

    fun recuperarNotaDetalhadaViewModelFactory() : NotaDetalhadaViewModelFactory {
        val notaRepository = NotaRepository.getInstace(Database.getInstance().notaDao)
        return NotaDetalhadaViewModelFactory(notaRepository)
    }
}