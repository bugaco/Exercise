//
//  AboutView.swift
//  bullseye
//
//  Created by 李懿哲 on 2020/3/11.
//  Copyright © 2020 zanyzephyr. All rights reserved.
//

import SwiftUI

struct AboutView: View {
    var body: some View {
        
        VStack {
            Text("🎯 Bullseye 🎯")
            Text("This is Bullseye, the game where you can win points and earn fame by dragging a slider.")
            Text("Your goal is to place the slider as close as possible to the target value. The closer you are, the more points you score.")
            Text("Enjoy!")
        }
    .navigationBarTitle(Text("About Bullseye"))
    }
}

struct AboutView_Previews: PreviewProvider {
    static var previews: some View {
        AboutView().previewLayout(.fixed(width: 896, height: 414))
    }
}
