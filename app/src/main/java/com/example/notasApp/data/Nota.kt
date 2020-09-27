package com.example.notasApp.data

data class Note(var text: String, var title: String)  {

    override fun toString(): String {
        return "$title - $text"
    }
}