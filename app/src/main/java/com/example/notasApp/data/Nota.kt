package com.example.notasApp.data

data class Nota(var texto: String, var titulo: String)  {

    override fun toString(): String {
        return "$titulo - $texto"
    }
}