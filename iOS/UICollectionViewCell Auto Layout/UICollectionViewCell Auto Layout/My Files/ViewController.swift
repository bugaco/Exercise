//
//  ViewController.swift
//  UICollectionViewCell Auto Layout
//
//  Created by ZanyZephyr on 2021/3/23.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var collectionView: UICollectionView!
    var section1Models = [Model]()
    var section2Models = [Model]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        initDataSource()
        setupCollectionView()
    }
    
    func initDataSource() {
        
        let cellCount = 10
        for _ in 0..<cellCount {
            let model = genAModel()
            section1Models.append(model)
        }
    }
    
    private func genAModel() -> Model {
        let model = Model()
        let randomInt = arc4random_uniform(100) + 1
        var title = "\n count - \(randomInt) - \n"
        for j in 0...randomInt {
            title += "\(j)"
        }
        model.title = title
        return model
    }
    
    func setupCollectionView() {
        
        if let layout = collectionView.collectionViewLayout as? UICollectionViewFlowLayout {
            layout.minimumLineSpacing = 0
            layout.minimumInteritemSpacing = 0
            layout.estimatedItemSize = UICollectionViewFlowLayout.automaticSize
        }
        
        collectionView.register(UINib.init(nibName: "MyCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: "cell")
        collectionView.dataSource = self
        collectionView.delegate = self
        
    }
    
    @IBAction func refresh(_ sender: Any) {
        collectionView.reloadData()
    }
    @IBAction func add1(_ sender: Any) {
        section1Models.append(genAModel())
        collectionView.reloadData()
    }
    
    @IBAction func add2(_ sender: Any) {
        section2Models.append(genAModel())
        collectionView.reloadData()
    }
}

extension ViewController: UICollectionViewDataSource, UICollectionViewDelegateFlowLayout, UICollectionViewDelegate {
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 2
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        if section == 0 {
            return section1Models.count
        }
        return section2Models.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "cell", for: indexPath) as! MyCollectionViewCell
        var model: Model?
        if indexPath.section == 0 {
            model = section1Models[indexPath.row]
        } else {
            model = section2Models[indexPath.row]
        }
        cell.model = model
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
        return .zero
    }

    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let screenWidth = UIScreen.main.bounds.width
        
        var cellWidth: CGFloat = 0
        var cellHeight: CGFloat = 0
        
        if indexPath.section == 0 {
            cellHeight = section1Models[indexPath.row].height
            cellWidth = screenWidth
        } else {
            cellWidth = screenWidth / 2
            cellHeight = section2Models[indexPath.row].height
        }
        
        
        
        let size = CGSize(width: cellWidth, height: cellHeight)
        print("sizeForItemAt", indexPath, "model height:", cellHeight)
        return size
    }
}

