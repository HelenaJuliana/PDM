//
//  ViewController.swift
//  Filmes
//
//  Created by IFPB on 17/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class AboutViewController: UIViewController {
    
    @IBOutlet weak var lbCountMovies: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        let filmeService = (UIApplication.shared.delegate as! AppDelegate).filmeService
        let count = filmeService.count()
        self.lbCountMovies.text = String(count)
        
        print(filmeService.showFilmes())
    }

}

