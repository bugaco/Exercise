//
//  MyCollectionViewCell.swift
//  UICollectionViewCell Auto Layout
//
//  Created by ZanyZephyr on 2021/3/23.
//

import UIKit

class MyCollectionViewCell: UICollectionViewCell {
    
    @IBOutlet weak var label: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    var model: Model? {
        didSet {
            guard let model = model else { return }
            label.text = model.title
        }
    }
    
    override func preferredLayoutAttributesFitting(_ layoutAttributes: UICollectionViewLayoutAttributes) -> UICollectionViewLayoutAttributes {
        
        setNeedsLayout()
        layoutIfNeeded()
        
        let fittingSize = systemLayoutSizeFitting(layoutAttributes.size)
        
        var cellFrame = layoutAttributes.frame
        cellFrame.size.height = fittingSize.height
        
        layoutAttributes.frame = cellFrame
        model?.height = fittingSize.height
        
        print("preferredLayoutAttributesFitting", fittingSize.height)
        
        return layoutAttributes
    }
}
