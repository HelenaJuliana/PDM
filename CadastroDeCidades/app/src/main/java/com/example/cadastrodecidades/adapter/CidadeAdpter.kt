package com.example.cadastrodecidades.adapter

import android.widget.BaseAdapter
import com.example.cadastrodecidades.DAO.Cidade

abstract class CidadeAdpter(private var cadastro: Cadastro): BaseAdapter() {
    fun add(cidade: Cidade) {
        this.cadastro.add(cidade)
    }
    fun setList(newList: ArrayList<Cidade>) {
        this.cadastro.set(newList)
    }
    fun updateItem(cidadeUP: Cidade) {
        this.cadastro.update(cidadeUP)
    }
    fun removeItem(id: Int) {
        this.cadastro.remove(id)
    }
}