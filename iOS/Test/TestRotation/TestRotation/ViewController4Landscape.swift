//
//  ViewController4Landscape.swift
//  TestRotation
//
//  Created by 李懿哲 on 2020/6/20.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import UIKit

class ViewController4Landscape: UIViewController {
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        AppDelegate.AppUtility.lockOrientationToLandscapeRight()
    }
    @IBAction func dismiss(_ sender: Any) {
        
        dismiss(animated: false) {
            AppDelegate.AppUtility.lockOrientationToPortrait()
        }
    }
}
