//
//  ContentView.swift
//  Landmarks_all_by_myself
//
//  Created by 李懿哲 on 2019/12/19.
//  Copyright © 2019 李懿哲. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            MapView()
                .frame(height: 300)
                .edgesIgnoringSafeArea(.top)
            
            CircleImage()
                .padding(.top, -130)
            HStack {
                VStack(alignment: .leading) {
                    Text("龟岛")
                        .font(.title)
                    HStack {
                        Text("Turtle Rock")
                            .font(.subheadline)
                        Spacer()
                        Text("艾泽拉斯")
                            .font(.subheadline)
                    }
                }
            }
            .padding()
            
            Spacer()
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
