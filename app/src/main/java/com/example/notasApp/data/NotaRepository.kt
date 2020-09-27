package com.example.notasApp.data

class NotaRepository(private final val notaDao: NotaDao) {

    fun salvar(nota: Nota) = notaDao.salvar(nota)

    fun buscarTodos() = notaDao.buscarTodos()

    fun buscar(titulo: String) = notaDao.buscar(titulo)

    fun substituir(nota: Nota) = notaDao.substituir(nota)

    companion object {
        @Volatile private var instace: NotaRepository? = null

        fun getInstace(notaDao: NotaDao) =
            instace ?: synchronized(this){
                instace ?: NotaRepository(notaDao).also { instace = it }
            }
    }
}