package com.example.notasApp.ui.detailedNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notasApp.data.NoteRepository

class DetailedNoteViewModelFactory(private val noteRepository: NoteRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailedNoteViewModel(noteRepository) as T
    }
}