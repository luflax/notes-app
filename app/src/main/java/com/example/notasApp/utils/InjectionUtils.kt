package com.example.notasApp.utils

import com.example.notasApp.data.Database
import com.example.notasApp.data.NoteRepository
import com.example.notasApp.ui.detailedNote.DetailedNoteViewModelFactory
import com.example.notasApp.ui.notas.NotesViewModelFactory

object InjectionUtils {

    fun provideNotesViewModelFactory() : NotesViewModelFactory {
        val noteRepository = NoteRepository.getInstance(Database.getInstance().noteDao)
        return NotesViewModelFactory(noteRepository)
    }

    fun provideDetailedNoteViewModelFactory() : DetailedNoteViewModelFactory {
        val noteRepository = NoteRepository.getInstance(Database.getInstance().noteDao)
        return DetailedNoteViewModelFactory(noteRepository)
    }
}