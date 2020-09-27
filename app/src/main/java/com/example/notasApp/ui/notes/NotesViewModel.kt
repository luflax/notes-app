package com.example.notasApp.ui.notes

import androidx.lifecycle.ViewModel
import com.example.notasApp.data.Note
import com.example.notasApp.data.NoteRepository

class NotesViewModel(private val notasRepository: NoteRepository) : ViewModel() {

    fun findAll() = notasRepository.findAll()

    fun save(note: Note) = notasRepository.save(note)
}