//
//  ViewController.swift
//  XibLocalizationTest
//
//  Created by BugaCo on 9/25/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var contentLabel: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        contentLabel.text = "content".localized
    }


}

protocol localizable {
    var localized: String { get }
}

extension String: localizable {
    var localized: String {
        return NSLocalizedString(self, comment: "")
    }
}

protocol XIBLocalLizable {
    var xibLocKey: String? { get set }
}

extension UILabel: XIBLocalLizable {
    @IBInspectable var xibLocKey: String? {
        get {
            return nil
        }
        set(key) {
            text = key?.localized
        }
    }
}

extension UIButton: XIBLocalLizable {
    @IBInspectable var xibLocKey: String? {
        get {
            return nil
        }
        set(key) {
            setTitle(key?.localized, for: .normal)
        }
    }
}
