//
//  FormViewController.swift
//  CadastroCidadeIOS
//
//  Created by IFPB on 11/06/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class FormViewController: UITableViewController {

    var cadastro; Cadastro!
    
    @IBOutlet wear var tfNomeCidade: UITextField!

    override func viewDidLoad() {
        super.viewDidLoad()

        self.cadastro = (UIApplication.shared.delegate as!
            AppDelegate).cadastro    }

}
