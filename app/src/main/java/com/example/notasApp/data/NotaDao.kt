package com.example.notasApp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.lang.RuntimeException

class NotaDao {
    private var fakeListaNota = mutableListOf<Nota>()
    private val listaNota = MutableLiveData<List<Nota>>()

    init {
        listaNota.value = fakeListaNota
    }

    fun salvar(nota: Nota) {
        val firstOrNull =
            fakeListaNota.firstOrNull { notaLista -> notaLista.titulo.equals(nota.titulo) }

        if(firstOrNull != null){
            throw RuntimeException("TITULO_CADASTRADO")
        }

        fakeListaNota.add(nota)
        listaNota.value = fakeListaNota
    }

    fun substituir(nota: Nota) {
        fakeListaNota = fakeListaNota.filter { notaLista -> !notaLista.titulo.equals(nota.titulo) }
            .toMutableList()

        fakeListaNota.add(nota)
        listaNota.value = fakeListaNota
    }

    fun buscarTodos(): LiveData<List<Nota>> {
        return listaNota
    }

    fun buscar(titulo: String): Nota? {
        return fakeListaNota.firstOrNull { nota -> nota.titulo == titulo }
    }

}