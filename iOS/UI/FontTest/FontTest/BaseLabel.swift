//
//  BaseLabel.swift
//  FontTest
//
//  Created by 李懿哲 on 2020/5/24.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import UIKit

class BaseLabel: UILabel {
    
    static let noti = "noti"
    
    
    var fontScale: CGFloat = 1.0 {
        didSet {
            updateFontSize()
        }
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        registerNoti()
    }
    
    
    private func registerNoti() {
        NotificationCenter.default.addObserver(self, selector: #selector(changeFontSizeScale), name: NSNotification.Name.init(rawValue: BaseLabel.noti), object: nil)
    }
    
    
    @objc func changeFontSizeScale() {
        fontScale = 2.0
    }
    
    private func updateFontSize() {
         let originSize = font.pointSize
        font = UIFont(name: font.fontName, size: originSize * fontScale)
    }
    
    deinit {
        
    }

}

