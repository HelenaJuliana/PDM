//
//  ResulViewController.swift
//  Forca
//
//  Created by IFPB on 28/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//
//  Created by IFPB on 28/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class ResultViewController: UIViewController {
    
    @IBOutlet weak var lb_result: UILabel!
    var result: String?
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.lb_result.text = self.result
    }
    
    
    @IBAction func back(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
        
    }
}
