package com.example.notasApp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.lang.RuntimeException

class NoteDao {
    private var fakeNoteList = mutableListOf<Note>()
    private val noteList = MutableLiveData<List<Note>>()

    init {
        noteList.value = fakeNoteList
    }

    fun save(note: Note) {
        val firstOrNull =
            fakeNoteList.firstOrNull { noteItem -> noteItem.title == note.title }

        if(firstOrNull != null){
            throw RuntimeException("TITULO_CADASTRADO")
        }

        fakeNoteList.add(note)
        noteList.value = fakeNoteList
    }

    fun update(note: Note) {
        fakeNoteList = fakeNoteList.filter { noteItem -> noteItem.title != note.title }
            .toMutableList()

        fakeNoteList.add(note)
        noteList.value = fakeNoteList
    }

    fun findAll(): LiveData<List<Note>> {
        return noteList
    }

    fun find(title: String): Note? {
        return fakeNoteList.firstOrNull { nota -> nota.title == title }
    }

}