//
//  Cadastro.swift
//  CadastroCidadeIOS
//
//  Created by IFPB on 11/06/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

Class Cadastro{
    
    private var lista: Array<Cidade>
    
    init(){
        self.lista = Array()
    }
    
    func add(cidade: Cidade){
        self.lista.append(cidade)
    }
    
    func get(index: Int)-> Cidade{
        return self.lista(index)
    }
    func get()-> Array<Cidade>{
        return self.lista
    }
}


