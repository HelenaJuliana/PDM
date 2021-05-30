//
//  FileService.swift
//  Filmes
//
//  Created by IFPB on 29/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

class FilmeService {
    
    var filmes: Array<Filme>!
    
    init() {
        self.filmes = Array<Filme>()
    }
    
    public func addFilme(filme: Filme) {
        self.filmes.append(filme)
    }
    
    public func count() -> Int {
        return self.filmes.count
    }
    
    public func showFilmes() -> Array<Filme> {
        return self.filmes
    }
    
    public func getFilmes() -> Array<Filme> {
        return self.filmes
    }
    
    public func getAt(index: Int) -> Filme {
        return self.filmes[index]
    }

    public func removeAt(index: Int) {
        self.filmes.remove(at: index)
    }
    
    public func moveFilmes(from: Int, to: Int) {
        self.filmes.swapAt(from, to)
    }
    
}
