//
//  AddFilmeViewController.swift
//  Filmes
//
//  Created by IFPB on 17/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class AddFilmeViewController: UIViewController {
    
    @IBOutlet weak var tfName: UITextField!
    
    @IBOutlet weak var switchOscar: UISwitch!
    
    @IBOutlet weak var stepperWatched: UIStepper!
  
    @IBOutlet weak var lbNota: UILabel!
    
    @IBOutlet weak var lbWatched: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    @IBAction func didSlide(_ sender: UISlider) {
        let value = sender.value
        self.lbNota.text = String(Int(value))
    }
    
    
    @IBAction func didValueChange(_ sender: UIStepper) {
        self.lbWatched.text = String(Int(sender.value))
    }
    
    @IBAction func save(_ sender: UIBarButtonItem) {
        let filme = Filme(name: self.tfName.text ?? "", nota: Int(self.lbNota.text ?? "0")!, timesWatched: Int(self.lbWatched.text ?? "0")!, oscarIndication: self.switchOscar.isOn)
        let filmeService = (UIApplication.shared.delegate as! AppDelegate).filmeService
        filmeService.addFilme(filme: filme)
        
        self.navigationController?.popViewController(animated: true)
    }
}
