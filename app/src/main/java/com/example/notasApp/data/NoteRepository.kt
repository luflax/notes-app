package com.example.notasApp.data

class NoteRepository(private val noteDao: NoteDao) {

    fun save(note: Note) = noteDao.save(note)

    fun findAll() = noteDao.findAll()

    fun find(title: String) = noteDao.find(title)

    fun update(note: Note) = noteDao.update(note)

    companion object {
        @Volatile private var instance: NoteRepository? = null

        fun getInstance(noteDao: NoteDao) =
            instance ?: synchronized(this){
                instance ?: NoteRepository(noteDao).also { instance = it }
            }
    }
}