package com.example.notasApp.ui.detailedNote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notasApp.R
import com.example.notasApp.databinding.ActivityDetailedNoteBinding
import com.example.notasApp.utils.InjectionUtils
import kotlinx.android.synthetic.main.activity_detailed_note.*

class DetailedNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_note)

        initiateUi()
    }

    private fun initiateUi(){
        val factory = InjectionUtils.provideDetailedNoteViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(DetailedNoteViewModel::class.java)

        DataBindingUtil.setContentView<ActivityDetailedNoteBinding>(
            this, R.layout.activity_detailed_note
        ).apply {
            this.lifecycleOwner = this@DetailedNoteActivity
            this.viewModel = viewModel
        }

        val action = intent.getStringExtra("action")
        val title = intent.getStringExtra("title")

        if(action == "update"){
            viewModel.find(title)
            editTextTitle.isEnabled = false
        }
    }
}