//
//  LandmarkList.swift
//  Landmarks
//
//  Created by 李懿哲 on 2019/12/19.
//  Copyright © 2019 Apple. All rights reserved.
//

import SwiftUI

struct LandmarkList: View {
    var body: some View {
        NavigationView{
            List(landmarkData, id: \.id) { landmark in
                NavigationLink(destination: LandmarkDetail(landmark: landmark)) {
                    LandmarkRow(landmark: landmark)
                }
                
            }
            .navigationBarTitle("Landmarks")
        }
        
    }
}

struct LandmarkList_Previews: PreviewProvider {
    static var previews: some View {
        LandmarkList()
    }
}
