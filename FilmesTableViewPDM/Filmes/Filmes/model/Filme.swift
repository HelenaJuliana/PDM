//
//  Filme.swift
//  Filmes
//
//  Created by IFPB on 29/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

class Filme: NSObject {
    var name: String
    var timesWatched: Int
    var nota: Int
    var oscarIndication: Bool
    
    override var description: String{
        return "Nome: \(self.name) Nota: \(self.nota) Assistidas: \(self.timesWatched) oscar: \(self.oscarIndication)"
    }
    
    init(name: String, nota: Int, timesWatched: Int, oscarIndication: Bool) {
        self.name = name
        self.nota = nota
        self.timesWatched = timesWatched
        self.oscarIndication = oscarIndication
    }
    
}
