package com.example.notasApp.data

class Database private constructor(){

    var noteDao = NoteDao()
        private set

    companion object{
        @Volatile private var instance: Database? = null

                fun getInstance() = instance ?: synchronized(this) {
                    instance ?: Database().also { instance = it }
                }
    }
}