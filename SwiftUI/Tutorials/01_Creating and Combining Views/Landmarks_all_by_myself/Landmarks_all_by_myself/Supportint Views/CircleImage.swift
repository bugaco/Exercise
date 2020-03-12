//
//  CircleImage.swift
//  Landmarks_all_by_myself
//
//  Created by 李懿哲 on 2019/12/19.
//  Copyright © 2019 李懿哲. All rights reserved.
//

import SwiftUI

struct CircleImage: View {
    var body: some View {
        Image("turtlerock")
        .clipShape(Circle())
            .overlay(Circle().stroke(Color.white, lineWidth: 4))
        .shadow(radius: 10)
    }
}

struct CircleImage_Previews: PreviewProvider {
    static var previews: some View {
        CircleImage()
    }
}
