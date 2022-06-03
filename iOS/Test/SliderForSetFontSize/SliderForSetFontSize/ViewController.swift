//
//  ViewController.swift
//  SliderForSetFontSize
//
//  Created by 李懿哲 on 2020/7/3.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var slider: UISlider!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        slider.addTarget(self, action: #selector(valueChange), for: .valueChanged)
    }
    
    @objc func valueChange() {
        slider.value = slider.intFloatValue
        print(slider.intFloatValue)
    }
    
    func setFontSizeScale(_ slideValue: Float) {
        var scaleValue: Float = 1
        switch slideValue {
        case 1: // 小
            scaleValue = 0.8
        case 2: // 标准
            scaleValue = 1
        case 3: // 大
            scaleValue = 1.4
        case 4: // 特大
            scaleValue = 1.8
        default:
            scaleValue = 1
        }
        
    }
}

extension UISlider {
    
    func numberFormat(_ num: Float) -> String {
        let formatter = NumberFormatter.init()
        formatter.positiveFormat = "0"
        let number = NSNumber.init(value: num)
        let rst = formatter.string(from: number) ?? "nil"
        return rst
    }
    
    /// 整数形的value
    var intFloatValue: Float {
        Float(numberFormat(value)) ?? 1
    }
}
