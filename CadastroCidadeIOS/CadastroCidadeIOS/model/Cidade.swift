//
//  Cidade.swift
//  CadastroCidadeIOS
//
//  Created by IFPB on 11/06/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

Class Cidade: NSObject{
    var nome: String
    var id: Int
    
    override var cidade: String{
        return self.nome
    }
    
    init(nome: String, id: Int){
        self.nome = nome
        self.id = id
    }
}
