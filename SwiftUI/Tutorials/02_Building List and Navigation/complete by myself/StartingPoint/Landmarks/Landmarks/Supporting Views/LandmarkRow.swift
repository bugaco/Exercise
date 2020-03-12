//
//  LandmarkRow.swift
//  Landmarks
//
//  Created by 李懿哲 on 2019/12/19.
//  Copyright © 2019 Apple. All rights reserved.
//

import SwiftUI

struct LandmarkRow: View {
    var landmark: Landmark
    
    var body: some View {
        HStack() {
            landmark.image
                .resizable()
                .frame(width: 50, height: 50, alignment: .center)
            
            Text(landmark.name)
            Spacer()
        }
    }
}

struct LandmarkRow_Previews: PreviewProvider {
    static var previews: some View {
        LandmarkRow(landmark: landmarkData[1])
    }
}
