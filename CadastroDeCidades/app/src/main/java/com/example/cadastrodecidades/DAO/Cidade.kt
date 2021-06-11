package com.example.cadastrodecidades.DAO

import java.io.Serializable

class Cidade : Serializable {
    var id: Int
    var nome : String
    var codigo :  Int


    constructor(nome: String, codigo: Int) {
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
