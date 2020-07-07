//
//  ViewController.swift
//  AnimationTest
//
//  Created by 李懿哲 on 2020/6/17.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var x: NSLayoutConstraint!
    @IBOutlet weak var y: NSLayoutConstraint!
    @IBOutlet weak var blueView: UIView!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 3) {
        
            self.x.constant = 100
            self.blueView.setNeedsUpdateConstraints()
            
            UIView.animate(withDuration: 3, animations: {
                self.view.layoutIfNeeded()
            }, completion: nil)
        }
        
    }


}

