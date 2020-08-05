//
//  ContentView.swift
//  How to synchronize animations from one view to another with matchedGeometryEffect
//
//  Created by BugaCo on 2020/7/31.
//  Copyright © 2020 BugaCo. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    
    @State private var isFlipped = false
    
    var body: some View {
        VStack {
            if isFlipped {
                Circle()
                    .fill(Color.red)
                    .frame(width: 44, height: 44)
                Text("Taylor Swift - 1989")
                    .font(.headline)
            } else {
                Text("Taylor Swift - 1989")
                    .font(.headline)
                Circle()
                    .fill(Color.red)
                    .frame(width: 44, height: 44)
            }
        }
        .onTapGesture {
            withAnimation {
                self.isFlipped.toggle()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
