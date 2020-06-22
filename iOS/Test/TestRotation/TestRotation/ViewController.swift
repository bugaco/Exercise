//
//  ViewController.swift
//  TestRotation
//
//  Created by 李懿哲 on 2020/6/20.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnTapped(_ sender: Any) {
        let vc = ViewController4Landscape()
        present(vc, animated: false) {
            print("present complation")
        }
    }
    
}

