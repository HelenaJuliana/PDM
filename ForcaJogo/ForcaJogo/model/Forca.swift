//
//  Forca.swift
//  ForcaJogo
//
//  Created by IFPB on 28/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

class Forca {
    
    var palavra: Array<Character>
    var status: Array<Character>
    var palavaDica: Dictionary<String, String>
    var tentativas: Int
    var letras: Array<Character>
    
    init(){
        self.palavaDica = Dictionary<String,String>()
        self.palavaDica["Lâmpada"] = "Acender"
        self.palavaDica["Gato"] = "Animal"
        self.palavaDica["Maçã"] = "Fruta"
       
        
        let quantPalavras = Array(self.palavaDica.keys).count
        self.palavra = Array(Array(self.palavaDica.keys)[Int.random(in: 0..<quantPalavras)])

        self.palavra = Array(palavra)
        self.letras = Array()
        self.tentativas = 0
        self.status = Array(repeating: "_", count: self.palavra.count)
    }
    
    func validarJogada(letra: Character) -> Bool{
        return !self.letras.contains(letra) && self.palavra.contains(letra) &&
            self.tentativas < 10
    }
    
    func jogar(letra: Character){
        if (self.validarJogada(letra: letra)){
            self.letras.append(letra)
            for i in 0..<self.palavra.count{
                if (self.palavra[i] == letra){
                    self.status[i] = letra
                }
            }
        }else{
            self.tentativas += 1
        }
    }
    
    func finalizou() -> Bool {
        return self.palavra == self.status || self.tentativas >= 10;
    }
    
    func resultado() -> String{
        if (self.finalizou()){
            if (self.palavra == self.status){
                return "Você ganhou"
            }else{
                return "Você perdeu"
            }
        }else{
            return "Continue Jogando"
        }
    }
    
    func getImage() -> String{
        return "forca\(self.tentativas).png"
    }
    
    func getDica() -> String? {
        return self.palavaDica[String(self.palavra)]
    }
    
}
