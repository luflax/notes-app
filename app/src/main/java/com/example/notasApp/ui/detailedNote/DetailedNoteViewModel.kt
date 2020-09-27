package com.example.notasApp.ui.detailedNote

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notasApp.data.Note
import com.example.notasApp.data.NoteRepository
import com.example.notasApp.ui.notes.NotesActivity


class DetailedNoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {

    var note: LiveData<Note> = MutableLiveData(Note("", ""))
    private var editing: Boolean = false

    fun find(title: String) {
        val noteItem = noteRepository.find(title)
        if (noteItem != null) {
            note = MutableLiveData(noteItem)
            editing = true
        }
    }

    fun save(view: View) {
        if (note.value == null || note.value!!.title.isEmpty()) {
            sendShortToastMessage(view, "O campo título é obrigatório")
            return
        }

        val noteItem = noteRepository.find(note.value!!.title)

        if (noteItem != null && !editing) {
            sendShortToastMessage(view, "Já existe uma nota com esse título")
            return
        }

        note.value?.let { noteRepository.update(it) }

        val intent = Intent(view.context, NotesActivity::class.java)
        view.context.startActivity(intent)
    }

    private fun sendShortToastMessage(view: View, message: String) {
        Toast.makeText(
            view.context, message,
            Toast.LENGTH_SHORT
        ).show()
    }
}