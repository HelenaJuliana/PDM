//
//  MainTableViewController.swift
//  Filmes
//
//  Created by IFPB on 22/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class MainTableViewController: UITableViewController {
    
    var filmeService: FilmeService!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.filmeService = (UIApplication.shared.delegate as! AppDelegate).filmeService
        
        let filme1 = Filme(name: "Lugar silencioso", nota: 10, timesWatched: 2, oscarIndication: false)
        let filme2 = Filme(name: "Filme 2", nota: 7, timesWatched: 1, oscarIndication: true)
        
        let filme3 = Filme(name: "Filme 3", nota: 9, timesWatched: 2, oscarIndication: false)
        self.filmeService.addFilme(filme: filme1)
        self.filmeService.addFilme(filme: filme2)
        self.filmeService.addFilme(filme: filme3)
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        self.navigationItem.leftBarButtonItem = self.editButtonItem
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return self.filmeService.count()
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "filme", for: indexPath)

        // Configure the cell...
        let filme = self.filmeService.getAt(index: indexPath.row)
        cell.textLabel?.text = filme.name
        
        return cell
    }
    

    
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }

    
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            self.filmeService.removeAt(index: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    
    
    private func moveRow(from: Int, to: Int) {

    }
    
    
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
        //moveRow(from: fromIndexPath.row, to: to.row)
        self.filmeService.moveFilmes(from: fromIndexPath.row, to: to.row)
    }
    

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.tableView.reloadData()
    }

}
