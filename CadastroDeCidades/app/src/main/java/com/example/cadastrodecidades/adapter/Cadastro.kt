package com.example.cadastrodecidades.adapter

import com.example.cadastrodecidades.DAO.Cidade

class Cadastro {

    private lateinit var list: ArrayList<Cidade>

    init {
        this.list = arrayListOf()
    }

    fun add(cid: Cidade) {
        this.list.add(cid)
    }

    fun set(newList: ArrayList<Cidade>) {
        this.list = newList
    }

    fun get(): ArrayList<Cidade> {
        return this.list
    }

    fun update(cid: Cidade, index: Int) {
        this.list[index] = cid
    }

    fun remove(index: Int) {
        this.list.removeAt(index)
    }

    fun get(index: Int): Cidade {
        return this.list[index]
    }

    fun count(): Int {
        return this.list.count()
    }

    fun update(cidadeUP: Cidade) {
        TODO("Not yet implemented")
    }


}

