package com.example.notasApp.ui.notas

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notasApp.R
import com.example.notasApp.ui.detailedNote.DetailedNoteActivity
import com.example.notasApp.utils.InjectionUtils
import kotlinx.android.synthetic.main.activity_notes.*


class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        initiateUi()
    }

    private fun initiateUi() {
        val factory = InjectionUtils.provideNotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(NotesViewModel::class.java)

        viewModel.findAll().observe(this, Observer { notes ->
            listCharacters.adapter = ArrayAdapter<String>(
                applicationContext,
                R.layout.note_textview,
                notes.map { note -> note.title }
            )
        })

        listCharacters.onItemClickListener = OnItemClickListener { _, view, _, _ ->
            val textView = view as TextView
            val intent = Intent(this, DetailedNoteActivity::class.java).apply {
                putExtra("action", "update")
                putExtra("title", textView.text)
            }
            startActivity(intent)
        }

        buttonAddNote.setOnClickListener {
            val intent = Intent(this, DetailedNoteActivity::class.java).apply {
                putExtra("action", "create")
            }
            startActivity(intent)
        }
    }
}