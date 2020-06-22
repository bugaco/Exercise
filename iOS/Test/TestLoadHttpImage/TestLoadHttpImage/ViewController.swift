//
//  ViewController.swift
//  TestLoadHttpImage
//
//  Created by 李懿哲 on 2020/6/20.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import UIKit
import Kingfisher

class ViewController: UIViewController {
    @IBOutlet weak var imageView: UIImageView!
    let imgUrl = "http://static.1sapp.com/qupost/img/2020/06/20/c24e4c984ed9363e232ca2608f1d44dd.jpeg"
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        if let url = URL.init(string: imgUrl) {
            imageView.kf.setImage(with: url)
        }
        
    }


}

