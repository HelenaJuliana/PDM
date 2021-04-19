package com.example.minhascores.dao

import android.content.ContentValues
import android.content.Context
import com.example.minhascores.Cor
import com.example.minhascores.migrations.coresHelper

class corDAO {
    private var database: coresHelper;
    constructor(context: Context){
        this.database = coresHelper(context)
    }

    fun insert(cor: Cor){
        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)
        this.database.writableDatabase.insert("cores",null,cv)

    }

    fun delete(id: Int){
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())
        this.database.writableDatabase.delete("cores", where,pwhere)
    }

    fun update (cor: Cor) {
        val where = "id = ?"
        val pWhere = arrayOf(cor.id.toString())
        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)
        this.database.writableDatabase.update("colors", cv, where, pWhere)
    }
}