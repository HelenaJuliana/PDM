package com.example.cadastrodecidades.DAO

import android.content.ContentValues
import android.content.Context

class CidadeDAO {

    private lateinit var database: DatabaseHelper

    constructor(context: Context) {
        this.database = DatabaseHelper(context)
    }

    fun insert(cid: Cidade): Long {
        val contentValues = ContentValues()
        contentValues.put("nome", cid.nome)
        contentValues.put("codigo", cid.codigo)

        return this.database.writableDatabase.insert("cidade", null, contentValues)
    }

    fun findAll(): ArrayList<Cidade> {
        val list = ArrayList<Cidade>()
        val cidades = arrayOf("id", "nome", "codigo")

        val cursor = this.database.readableDatabase.query("cidade", cidades, null, null, null, null, "nome")
        cursor.moveToFirst()

        return list
    }

}