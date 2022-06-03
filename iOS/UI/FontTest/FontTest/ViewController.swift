//
//  ViewController.swift
//  FontTest
//
//  Created by 李懿哲 on 2020/5/24.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var label: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }

    @IBAction func changeAppearance(_ sender: Any) {
        
        NotificationCenter.default.post(.init(name: .init(BaseLabel.noti)))
    }
    
}

