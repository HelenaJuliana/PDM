package com.example.cadastrodecidades.DAO

import java.io.Serializable

class Cidade : Serializable {
    var id: Int = 0
    lateinit var nome : String
    var codigo :  Int = 0


    constructor(nome: String, codigo: Int) {
        this.id = 1
        this.nome = nome
        this.codigo = codigo
    }

    constructor(id: Int, nome: String, codigo: Int) {
        this.id = id
        this.nome = nome
        this.codigo = codigo
    }

    override fun toString(): String {
        return "${id} - ${nome} - ${codigo} }"
    }


}
